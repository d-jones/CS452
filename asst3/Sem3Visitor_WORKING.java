package visitor;

import syntaxtree.*;

import java.util.*;
import errorMsg.*;
// The purpose of this class is to:
// - link each variable reference to its corresponding VarDecl
//   (via its 'link' instance variable)
//   - undefined variable names are reported
// - link each type reference to its corresponding ClassDecl
//   - undefined type names are reported
// - link each Break expression to its enclosing While
//   statement
//   - a break that is not inside any while loop is reported
// - report conflicting local variable names (including formal
//   parameter names)
// - ensure that no instance variable has the name 'length'
public class Sem3Visitor extends ASTvisitor {
	
	Hashtable<String, ClassDecl> globalSymTab;
	ClassDecl currentClass;
	Hashtable<String, VarDecl> localSymTab;
	ErrorMsg errorMsg;
	Stack<While> loopStack;
	LocalVarDecl currentLocalDecl;
	
	public Sem3Visitor(Hashtable globalSymTb, ErrorMsg e) {
		errorMsg = e;
		initInstanceVars(globalSymTb);
	}

	private void initInstanceVars(Hashtable<String,ClassDecl> globalTab) {
		loopStack = new Stack<While>();
		globalSymTab = globalTab;
		localSymTab = new Hashtable<String,VarDecl>();
		currentClass = null;
		currentLocalDecl = null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitClassDecl(syntaxtree.ClassDecl)
	 */
	@Override
	public Object visitClassDecl(ClassDecl c){
		currentClass = c;
		super.visitClassDecl(c);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitMethodDecl(syntaxtree.MethodDecl)
	 */
	@Override
	public Object visitMethodDecl(MethodDecl method){
		localSymTab.clear();
		super.visitMethodDecl(method);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitVarDecl(syntaxtree.VarDecl)
	 */
	@Override
	public Object visitFormalDecl(FormalDecl var){		
		super.visitFormalDecl(var);
		//There's a duplicate variable name
		if(localSymTab.containsKey(var.name)){
			errorMsg.error(var.pos, "Duplicate variable name: " + var.name);
		}
		//put the variable into the local symbol table
		else{
			localSymTab.put(var.name, var);
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitLocalVarDecl(syntaxtree.LocalVarDecl)
	 */
	@Override
	public Object visitLocalVarDecl(LocalVarDecl var){
		if(var instanceof LocalVarDecl){
			currentLocalDecl = (LocalVarDecl)var;
		}
		
		super.visitLocalVarDecl(var);
		//There's a duplicate variable name
		if(localSymTab.containsKey(var.name)){
			errorMsg.error(var.pos, "Duplicate variable name: " + var.name);
		}
		//put the variable into the local symbol table
		else{
			localSymTab.put(var.name, var);
		}
		
		currentLocalDecl = null;
		return null;
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitInstVarDecl(syntaxtree.InstVarDecl)
	 */
	@Override
	public Object visitInstVarDecl(InstVarDecl iVar){
		if(iVar.name.equals("length")){
			errorMsg.error(iVar.pos, "Illegal name \"length\" for an instance variable.");
		}
		super.visitInstVarDecl(iVar);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitBlock(syntaxtree.Block)
	 */
	@Override
	public Object visitBlock(Block block){
		super.visitBlock(block);
		for(Statement s : block.stmts){
			localSymTab.remove(s);
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitIdentifierExp(syntaxtree.IdentifierExp)
	 */
	@Override
	public Object visitIdentifierExp(IdentifierExp iExp){
		if(currentLocalDecl != null && iExp.name.equals(currentLocalDecl.name)){
			errorMsg.error(iExp.pos, "Error: Cannot initialize a variable to itself (" + iExp.name + ")");
		}
		
		//the iExp's name is in the local symbol table
		if(localSymTab.containsKey(iExp.name)){
			iExp.link = localSymTab.get(iExp.name);
		}
		//not found
		else{
			//if it's in the current class' instance variable table
			if(currentClass.instVarTable.containsKey(iExp.name)){
				iExp.link = currentClass.instVarTable.get(iExp.name);
			}
			//if it's in the super class' instance variable table
			ClassDecl superClass = traverseSuper(currentClass.superLink, iExp.name);
			if(superClass != null){
				iExp.link = superClass.instVarTable.get(iExp.name);
			}
			//not found anywhere :/
			else{
				errorMsg.error(iExp.pos, "Undefined name1: " + iExp.name);
			}
		}
		return null;
	}
	
	
	/**
	 * traverseSuper()
	 * 
	 * Description: Recursively traverses the given class' superclass until it find the 
	 * 	variable in the instance variable table, or finds null.
	 * @param c -- The current class' superclass
	 * @param name -- The name of the Identifier Expression
	 * @return -- The superclass which contains the instVarTable which contains the 
	 * 				IdentifierExp.
	 */
	private ClassDecl traverseSuper(ClassDecl c, String name){
		if(c == null){
			return null;
		}
		else if(c.instVarTable.containsKey(name)){
			return c;
		}
		

		return traverseSuper(c.superLink, name);
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitIdentifierType(syntaxtree.IdentifierType)
	 */
	@Override
	public Object visitIdentifierType(IdentifierType iType){
		if(globalSymTab.containsKey(iType.name)){
			iType.link = globalSymTab.get(iType.name);
		}
		else{
			errorMsg.error(iType.pos,  "Undefined name2: " + iType.name);
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitWhile(syntaxtree.While)
	 */
	@Override
	public Object visitWhile(While w){
		loopStack.push(w);
		super.visitWhile(w);
		loopStack.pop();
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitBreak(syntaxtree.Break)
	 */
	@Override
	public Object visitBreak(Break b){
		if(loopStack.empty()){
			errorMsg.error(b.pos, "Break statement outside of loop.");
		}
		else{
			b.loopLink = loopStack.peek();
		}
		return null;
	}
}

	
