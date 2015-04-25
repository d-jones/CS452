package visitor;

import syntaxtree.*;

import java.util.*;

import errorMsg.*;
import java.io.*;
import java.awt.Point;

//the purpose here is to annotate things with their offsets:
// - formal parameters, with respect to the (callee) frame
// - instance variables, with respect to their slot in the object
// - methods, with respect to their slot in the v-table
public class CG1Visitor extends ASTvisitor {
	
	// IO stream to which we will emit code
	CodeStream code;
	
	// v-table offset of next method we encounter
	int currentMethodOffset;
	
	// offset in object of next "object" instance variable we encounter
	int currentObjInstVarOffset;
	
	// offset in object of next "data" instance variable we encounter
	int currentDataInstVarOffset;
	
	// stack-offset of next formal parameter we encounter
	int currentFormalVarOffset;
	
	// stack method tables for current class and all superclasses
	Stack<Vector<String>> superclassMethodTables;
	
	// current method table
	Vector<String> currentMethodTable;
	
	// error-message object
	ErrorMsg errorMsg;
	
	
	public CG1Visitor(ErrorMsg e, PrintStream out) {
		initInstanceVars(e, out);
	}
	
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	private ClassDecl findObjectClass(ClassDecl c){
		if(c != null){
			if(c.superLink == null){
				return c;
			}
			else{
				return findObjectClass(c.superLink);
			}
		}
		else{
			return null;
		}
	}


	private void initInstanceVars(ErrorMsg e, PrintStream out) {
		errorMsg = e;
		currentMethodOffset = 0;
		currentObjInstVarOffset = 0;
		currentDataInstVarOffset = 0;
		code = new CodeStream(out, e);
		superclassMethodTables = new Stack<Vector<String>>();
		superclassMethodTables.addElement(new Vector<String>());
	}
	

	/**
	 * 
	 * @param cd
	 * @return
	 */
	private int numMethods(ClassDecl cd){
		if(cd == null){
			return 0;
		}
		
		HashSet<String> names = new HashSet<String>();
		
		ClassDecl traverseClass = cd;
		
		while(traverseClass != null){
			for(String s : traverseClass.methodTable.keySet()){
				names.add(s);
			}
			traverseClass = traverseClass.superLink;
		}
		
		return names.size();
	}
	
	
	/**
	 * 
	 * @param m
	 */
	private void registerMethodInTable(MethodDecl m){
		if(currentMethodTable.size() < m.vtableOffset){
			currentMethodTable.setSize(m.vtableOffset);
		}

		if(m.pos >= 0){
			if(currentMethodTable.contains(m.vtableOffset)){
				currentMethodTable.set(m.vtableOffset, "fcn_" + m.uniqueId + "_" + m.name);
			}
			else{
				currentMethodTable.add(m.vtableOffset, "fcn_" + m.uniqueId + "_" + m.name);
			}
		}
		else{
			if(currentMethodTable.contains(m.vtableOffset)){
				currentMethodTable.set(m.vtableOffset, m.name);
			}
			else{
				currentMethodTable.add(m.vtableOffset, m.name);
			}
		}
	}
	
	
	
	
	 /*
	  * (non-Javadoc)
	  * @see visitor.ASTvisitor#visitClassDecl(syntaxtree.ClassDecl)
	  */
	@Override
	public Object visitClassDecl(ClassDecl c){
		currentMethodTable = superclassMethodTables.lastElement();
		currentMethodOffset = 1 + numMethods(c.superLink);
		
		//set the currentDataInstVarOffset & 
		//currentObjInstVarOffset
		if(c.superLink == null){
			currentDataInstVarOffset = -16;
			currentObjInstVarOffset = 0;
		}
		else{
			currentDataInstVarOffset = -16 - 4*c.superLink.numDataInstVars;
			currentObjInstVarOffset = 4*c.superLink.numObjInstVars;
		}
		
		//do the subnode traversal
		super.visitClassDecl(c);
		ClassDecl objClassDecl = findObjectClass(c);
		objClassDecl.numDataInstVars = (-16 - currentDataInstVarOffset)/4;
		objClassDecl.numObjInstVars = currentObjInstVarOffset / 4;
		code.emit(c, "CLASS_" + c.name + ":");
		
		if(c.superLink == null){
			code.emit(c, ".word 0");
		}
		else{
			code.emit(c, ".word CLASS_" + c.superName);
		}
		
		for(String s : currentMethodTable){
			if(s != null){
				code.emit(c, ".word " + s);
			}
		}
		
		superclassMethodTables.push(currentMethodTable);
		
		c.subclasses.accept(this);
		superclassMethodTables.pop();
		code.emit(c, "CLASS_END_" + c.name + ":");
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitInstVarDecl(syntaxtree.InstVarDecl)
	 */
	@Override
	public Object visitInstVarDecl(InstVarDecl var){
		super.visitInstVarDecl(var);
		
		if(var.type instanceof IntegerType || var.type instanceof BooleanType){
			var.offset = currentDataInstVarOffset;
			currentDataInstVarOffset -= 4;
		}
		else if(var.type instanceof Object || var.type instanceof ArrayType){
			var.offset = currentObjInstVarOffset;
			currentObjInstVarOffset += 4;
		}
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitFormalDecl(syntaxtree.FormalDecl)
	 */
	@Override
	public Object visitFormalDecl(FormalDecl d){
		super.visitFormalDecl(d);
		
		if(d.type instanceof IntegerType){
			currentFormalVarOffset -= 8;
		}
		else{
			currentFormalVarOffset -= 4;
		}
		
		d.offset = currentFormalVarOffset;
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitMethodDecl(syntaxtree.MethodDecl)
	 */
	@Override
	public Object visitMethodDecl(MethodDecl m){
		int numWords = wordsOnStackFrame(m.formals);
		m.thisPtrOffset = 4*(1 + numWords);
		
		currentFormalVarOffset = m.thisPtrOffset;
		super.visitMethodDecl(m);
		
		if(m.superMethod != null){
			m.vtableOffset = m.superMethod.vtableOffset;
		}
		else{
			m.vtableOffset = currentMethodOffset;
			currentMethodOffset++;
		}
		
		registerMethodInTable(m);
		
		return null;
	}
	
	
	
	
	 /*
	  * (non-Javadoc)
	  * @see visitor.ASTvisitor#visitProgram(syntaxtree.Program)
	  */
	@Override
	public Object visitProgram(Program p){
		code.emit(p, ".data");
		ClassDecl objClassDecl = findObjectClass(p.classDecls.elementAt(0));
		objClassDecl.accept(this);
		code.flush();
		return null;
	}
	
	
	/**
	 * 
	 * @param vList
	 * @return
	 */
	private int wordsOnStackFrame(VarDeclList vList){
		int num = 0;
		
		for(VarDecl var : vList){
			if(var.type instanceof IntegerType){
				num += 2;
			}
			else if(var.type instanceof VoidType){
				
			}
			else{
				num += 1;
			}
		}
		
		return num;
	}
}
	
