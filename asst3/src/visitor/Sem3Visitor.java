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
			int possSpellError = spellCheckIExp(iExp, localSymTab, null);
			//if it's in the current class' instance variable table
			if(currentClass.instVarTable.containsKey(iExp.name)){
				iExp.link = currentClass.instVarTable.get(iExp.name);
			}
			possSpellError = spellCheckIExp(iExp, null, currentClass.instVarTable);
			//if it's in the super class' instance variable table
			ClassDecl superClass = traverseSuper(currentClass.superLink, iExp.name, null);
			if(superClass != null){
				iExp.link = superClass.instVarTable.get(iExp.name);
			}
			//not found anywhere :/
			else{
				//there's no possible spelling error
				if(possSpellError != 0){
					errorMsg.error(iExp.pos, "Undefined name: " + iExp.name);
				}
			}
		}
		return null;
	}
	
	
	/**
	 * spellCheckIExp()
	 * 
	 * Description: Attempts to check for possible spelling errors in undefined names.
	 * @param c
	 * @return
	 */
	private int spellCheckIExp(IdentifierExp iExp, Hashtable<String, VarDecl> lTable, Hashtable<String, InstVarDecl> iTable){
		int success = -1;
		if(lTable == null){
			Collection<InstVarDecl> vars = iTable.values();
			for(InstVarDecl var : vars){
				success = spellCheckIExpHelper(iExp, null, var);
			}
		}
		else{
			Collection<VarDecl> vars = lTable.values();
			for(VarDecl var : vars){
				success = spellCheckIExpHelper(iExp, var, null);
			}
		}
		
		//we didn't find any possible spelling errors
		return success;
	}
	
	/**
	 * a helper method for the IdentifierExp spell checker
	 * @param iExp
	 * @param lVar
	 * @param iVar
	 * @return
	 */
	private int spellCheckIExpHelper(IdentifierExp iExp, VarDecl lVar, InstVarDecl iVar){
		VarDecl var;
		if(lVar == null){
			var = iVar;
		}
		else{
			var = lVar;
		}
		/* if one of the strings is more than one character longer than the other,
		 * we on't even bother testing them, since they can't be "off by one", and 
		   a "case" difference won't matter.*/
		int difference = Math.abs(iExp.name.length() - var.name.length());
		if(difference <= 1){
			if(!iExp.name.equals(var.name)){
				//the superclass names only differ by case
				if(testCaseIExp(iExp, var) == 0){
					errorMsg.error(iExp.pos, "Error: Undefined name, possible spelling mistake. Did you mean \"" + iExp.name + "\", or \"" + var.name + "\"?");
					return 0;
				}
				else{
					char[] iExp1Name = iExp.name.toLowerCase().toCharArray();
					char[] iExp2Name = var.name.toLowerCase().toCharArray();
					//the (lowercase) superclass names are only off by one character.
					if(testOffByOne(iExp1Name, iExp2Name, difference) == 0){
						errorMsg.error(iExp.pos, "Error: Undefined name, possible spelling mistake. Did you mean \"" + iExp.name + "\", or \"" + var.name + "\"?");
						return 0;
					}
				}
			}
		}
		return -1;
	}
	
	
	/**
	 * testOffByOne()
	 * 
	 * Description: Tests if the (lowercase) class names are only of by one character.
	 * @param class1Name
	 * @param class2Name
	 * @return
	 */
	private int testOffByOne(char[] class1Name, char[] class2Name, int difference){
		int numCharsDiff = 0;
		if(class1Name.length > class2Name.length){
			numCharsDiff = getNumCharsDiff(class2Name, class1Name, difference);
		}
		else if(class2Name.length > class1Name.length){
			numCharsDiff = getNumCharsDiff(class1Name, class2Name, difference);
		}
		else{
			numCharsDiff = getNumCharsDiff(class2Name, class1Name, difference);
		}
		
		if(numCharsDiff == 1){
			return 0;
		}
		return -1;
	}
	
	
	/**
	 * getNumCharsDiff()
	 * 
	 * Description: Gets the number of characters in the class names that are different.
	 * @param class1Name -- The smaller(if applicable) class
	 * @param class2Name
	 * @return
	 */
	private int getNumCharsDiff(char[] class1Name, char[] class2Name, int difference){
		int numCharsDiff = 0;
		for(int i = 0; i < class1Name.length; ++i){
			if(numCharsDiff == 0){
				if(class1Name[i] == class2Name[i]){
				}
				else{
					++numCharsDiff;
				}
			}
			else{
				if(class1Name[i-1] == class2Name[i]){
				}
				else{
					++numCharsDiff;
				}
			}
		}
		
		if(numCharsDiff == 0 && difference == 1){
			return ++numCharsDiff;
		}
		return numCharsDiff;
	}
	
	
	/**
	 * testCaseIExp()
	 * 
	 * Description: Tests if the two class names only differ by case.
	 * @param class1
	 * @param class2
	 * @return
	 */
	private int testCaseIExp(IdentifierExp iExp, VarDecl var){
		if(iExp.name.toLowerCase().equals(var.name.toLowerCase())){
			return 0;
		}
		return -1;
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
	private ClassDecl traverseSuper(ClassDecl c, String name, IdentifierExp iExp){
		if(c == null){
			return null;
		}
		else if(c.instVarTable.containsKey(name)){
			return c;
		}
		if(spellCheckIExp(iExp, null, c.instVarTable) == 0){
			return null;
		}
		

		return traverseSuper(c.superLink, name, null);
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitIdentifierType(syntaxtree.IdentifierType)
	 */
	@Override
	public Object visitIdentifierType(IdentifierType iType){
		int possSpellError = 0;
		if(globalSymTab.containsKey(iType.name)){
			iType.link = globalSymTab.get(iType.name);
		}
		else{
			possSpellError = spellCheck(iType);
			//no possible spelling error
			if(possSpellError != 0){
				errorMsg.error(iType.pos,  "Undefined name: " + iType.name);
			}
		}
		return null;
	}
	
	
	/**
	 * spellCheck()
	 * 
	 * Description: Attempts to check for possible spelling errors in undefined names.
	 * @param c
	 * @return
	 */
	private int spellCheck(IdentifierType iType){
		Collection<ClassDecl> classes = globalSymTab.values();
		for(ClassDecl classTest : classes){
			/* if one of the strings is more than one character longer than the other,
			 * we on't even bother testing them, since they can't be "off by one", and 
			   a "case" difference won't matter.*/
			int difference = Math.abs(iType.name.length() - classTest.name.length());
			if(difference <= 1){
				if(!iType.name.equals(classTest.name)){
					//the superclass names only differ by case
					if(testCase(iType, classTest) == 0){
						errorMsg.error(iType.pos, "Error: Undefined name, possible spelling mistake. Did you mean \"" + iType.name + "\", or \"" + classTest.name + "\"?");
						return 0;
					}
					else{
						char[] class1Name = iType.name.toLowerCase().toCharArray();
						char[] class2Name = classTest.name.toLowerCase().toCharArray();
						//the (lowercase) superclass names are only off by one character.
						if(testOffByOne(class1Name, class2Name, difference) == 0){
							errorMsg.error(iType.pos, "Error: undefined name, possible spelling mistake. Did you mean \"" + iType.name + "\", or \"" + classTest.name + "\"?");
							return 0;
						}
					}
				}
			}
		}
		//we didn't find any possible spelling errors
		return -1;
	}
	
	
	/**
	 * testCase()
	 * 
	 * Description: Tests if the two class names only differ by case.
	 * @param class1
	 * @param class2
	 * @return
	 */
	private int testCase(IdentifierType iType, ClassDecl class1){
		if(iType.name.toLowerCase().equals(class1.name.toLowerCase())){
			return 0;
		}
		return -1;
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

	
