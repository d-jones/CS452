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
	 * A helper method to see if hte given ArrayList contains the given name.
	 * @param name
	 * @param names
	 * @return
	 */
	private boolean containsName(String name, ArrayList<String> names){
		for(String n : names){
			if(name.equals(n)){
				return true;
			}
		}
		return false;
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
	 * A helper method to determine the number of methods
	 * the tiven class/its superclasses have.
	 * @param cd -- The current class
	 * @return -- The number of methods
	 */
	private int numMethods(ClassDecl cd){
		int num = 0;
		ClassDecl superClass = findObjectClass(cd);
		
		if(superClass != null){
			Set<String> methNames = superClass.methodTable.keySet();
			ClassDeclList subList = superClass.subclasses;
			
			for(ClassDecl c : subList){
				for(String name : c.methodTable.keySet()){
					methNames.add(name);
				}
			}
			
			ArrayList<String> namesSeen = new ArrayList<String>();
			
			for(String name : methNames){
				if(!containsName(name, namesSeen)){
					namesSeen.add(name);
					num++;
				}
			}
			return num;
		}
		else{
			return cd.methodTable.size();
		}
	}
	
	
	/**
	 * A helper method to find the Object class for the
	 * given ClassDecl c.
	 * @param c -- The class to search through
	 * @return -- The Object ClassDecl.
	 */
	private ClassDecl findObjectClass(ClassDecl c){
		if(c.superLink == null){
			return c;
		}
		else{
			return findObjectClass(c.superLink);
		}
	}
	
/*	
	
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitClassDecl(syntaxtree.ClassDecl)
	 
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
		code.emit(c, superclassMethodTables.peek();
		
		return null;
	}
	
	
	
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitProgram(syntaxtree.Program)
	 
	@Override
	public Object visitProgram(Program p){
		code.emit(p, ".data");
		for(ClassDecl c : p.classDecls){
			ClassDecl objClassDecl = findObjectClass(c);
			if(objClassDecl != null){
				objClassDecl.accept(this);
			}
		}
		
		code.flush();
		return null;
	}*/
}
	
