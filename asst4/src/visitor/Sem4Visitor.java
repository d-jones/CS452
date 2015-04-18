package visitor;

import syntaxtree.*;

import java.util.*;

import errorMsg.*;
// The purpose of this class is to do type-checking and related
// actions.  These include:
// - evaluate the type for each expression, filling in the 'type'
//   link for each
// - ensure that each expression follows MiniJava's type rules (e.g.,
//   that the arguments to '*' are both integer, the argument to
//   '.length' is an array, etc.)
// - ensure that each method-call follows Java's type rules:
//   - there exists a method for the given class (or a superclass)
//     for the receiver's object type
//   - the method has the correct number of parameters
//   - the types of each actual parameter is compatible with that
//     of its corresponding formal parameter
// - ensure that for each instance variable access (e.g., abc.foo),
//   there is an instance variable defined for the given class (or
//   in a superclass
//   - sets the 'varDec' link in the InstVarAccess to refer to the
//     method
// - ensure that the RHS expression in each assignment statement is
//   type-compatible with its corresponding LHS
//   - also checks that the LHS an lvalue
// - ensure that if a method with a given name is defined in both
//   a subclass and a superclass, that they have the same parameters
//   (with identical types) and the same return type
// - ensure that the declared return-type of a method is compatible
//   with its "return" expression
// - ensuring that the type of the control expression for an if- or
//   while-statement is boolean
public class Sem4Visitor extends ASTvisitor {
	
	ClassDecl currentClass;
	IdentifierType currentClassType;
	IdentifierType currentSuperclassType;
	ErrorMsg errorMsg;
	Hashtable<String,ClassDecl> globalSymTab;
	
	BooleanType theBoolType;
	IntegerType theIntType;
	NullType theNullType;
	VoidType theVoidType;
	IdentifierType theStringType;
	
	public Sem4Visitor(Hashtable<String,ClassDecl> globalSymTb, ErrorMsg e) {
		globalSymTab = globalSymTb;
		errorMsg = e;
		initInstanceVars();
	}

	private void initInstanceVars() {
		currentClass = null;
		
		theBoolType = new BooleanType(-1);
		theIntType = new IntegerType(-1);
		theNullType = new NullType(-1);
		theVoidType = new VoidType(-1);
		if (globalSymTab != null) {
			theStringType = new IdentifierType(-1, "String");
			theStringType.link = globalSymTab.get("String");
		}
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitIntegerLiteral(syntaxtree.IntegerLiteral)
	 */
	@Override
	public Object visitIntegerLiteral(IntegerLiteral intLit){
		super.visitIntegerLiteral(intLit);
		intLit.type = theIntType;
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitNull(syntaxtree.Null)
	 */
	@Override
	public Object visitNull(Null n){
		super.visitNull(n);
		n.type = theNullType;
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitStringLiteral(syntaxtree.StringLiteral)
	 */
	@Override
	public Object visitStringLiteral(StringLiteral stringLit){
		super.visitStringLiteral(stringLit);
		stringLit.type = theStringType;
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitTrue(syntaxtree.True)
	 */
	@Override
	public Object visitTrue(True t){
		super.visitTrue(t);
		t.type = theBoolType;
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitFalse(syntaxtree.False)
	 */
	@Override
	public Object visitFalse(False f){
		super.visitFalse(f);
		f.type = theBoolType;
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitIdentifierExp(syntaxtree.IdentifierExp)
	 */
	@Override
	public Object visitIdentifierExp(IdentifierExp iExp){
		super.visitIdentifierExp(iExp);
		iExp.type = iExp.link.type;
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitThis(syntaxtree.This)
	 */
	@Override
	public Object visitThis(This t){
		super.visitThis(t);
		t.type = currentClassType;
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitSuper(syntaxtree.Super)
	 */
	@Override
	public Object visitSuper(Super s){
		super.visitSuper(s);
		s.type = currentSuperclassType;
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitPlus(syntaxtree.Plus)
	 */
	@Override
	public Object visitPlus(Plus plus){
		super.visitPlus(plus);
		//both the LHS and RHS are matching types
		if(matchTypesExact(plus.left.type, theIntType, plus.pos) && 
				matchTypesExact(plus.right.type,theIntType, plus.pos)){
			plus.type = theIntType;
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitMinus(syntaxtree.Minus)
	 */
	@Override
	public Object visitMinus(Minus minus){
		super.visitMinus(minus);
		if(matchTypesExact(minus.left.type, theIntType, minus.pos) && 
				matchTypesExact(minus.right.type, theIntType, minus.pos)){
			minus.type = theIntType;
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitTimes(syntaxtree.Times)
	 */
	@Override
	public Object visitTimes(Times times){
		super.visitTimes(times);
		
		if(matchTypesExact(times.left.type, theIntType, times.pos) && 
				matchTypesExact(times.right.type, theIntType, times.pos)){
			times.type = theIntType;
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitDivide(syntaxtree.Divide)
	 */
	@Override
	public Object visitDivide(Divide divide){
		super.visitDivide(divide);
		
		if(matchTypesExact(divide.left.type, theIntType, divide.pos) && 
				matchTypesExact(divide.right.type, theIntType, divide.pos)){
			divide.type = theIntType;
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitGreaterThan(syntaxtree.GreaterThan)
	 */
	@Override
	public Object visitGreaterThan(GreaterThan gt){
		super.visitGreaterThan(gt);
		
		if(matchTypesExact(gt.left.type, theIntType, gt.pos) && 
				matchTypesExact(gt.right.type, theIntType, gt.pos)){
			gt.type = theBoolType;
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitLessThan(syntaxtree.LessThan)
	 */
	@Override
	public Object visitLessThan(LessThan lt){
		super.visitLessThan(lt);
		
		if(matchTypesExact(lt.left.type, theIntType, lt.pos) && 
				matchTypesExact(lt.right.type, theIntType, lt.pos)){
			lt.type = theBoolType;
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitRemainder(syntaxtree.Remainder)
	 */
	@Override
	public Object visitRemainder(Remainder rem){
		super.visitRemainder(rem);
		
		if(matchTypesExact(rem.left.type, theIntType, rem.pos) && 
				matchTypesExact(rem.right.type, theIntType, rem.pos)){
			rem.type = theIntType;
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitEquals(syntaxtree.Equals)
	 */
	@Override
	public Object visitEquals(Equals equals){
		super.visitEquals(equals);
		if(matchTypesEqCompare(equals.left.type, equals.right.type, equals.pos)){
			equals.type = theBoolType;
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitNot(syntaxtree.Not)
	 */
	@Override
	public Object visitNot(Not not){
		super.visitNot(not);
		if(matchTypesExact(not.exp.type, theBoolType, not.pos)){
			not.type = theBoolType;
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitAnd(syntaxtree.And)
	 */
	@Override
	public Object visitAnd(And and){
		if(matchTypesExact(and.left.type, theBoolType, and.pos) && 
				matchTypesExact(and.right.type, theBoolType, and.pos)){
			and.type = theBoolType;
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitAnd(syntaxtree.And)
	 */
	@Override
	public Object visitOr(Or or){
		if(matchTypesExact(or.left.type, theBoolType, or.pos) && 
				matchTypesExact(or.right.type, theBoolType, or.pos)){
			or.type = theBoolType;
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitArrayLength(syntaxtree.ArrayLength)
	 */
	@Override
	public Object visitArrayLength(ArrayLength aLength){
		super.visitArrayLength(aLength);
		if(aLength.exp.type != null && aLength.exp.type instanceof ArrayType){
			aLength.type = theIntType;
		}
		else{
			errorMsg.error(aLength.pos, "Error: taking length on non-array type " + aLength.exp.type.toString2());
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitArrayLookup(syntaxtree.ArrayLookup)
	 */
	@Override
	public Object visitArrayLookup(ArrayLookup aLook){
		super.visitArrayLookup(aLook);
		if(matchTypesExact(aLook.idxExp.type, theIntType, -1)){
			if(aLook.arrExp.type instanceof ArrayType){
				aLook.type = aLook.arrExp.type;
			}
			else{
				if(aLook.pos >= 0){
					errorMsg.error(aLook.pos, "Error: " + aLook.arrExp.type.toString2() + " must be an array type.");
				}
			}
		}
		else if(aLook.pos >= 0){
			errorMsg.error(aLook.pos, "Error: " + aLook.idxExp.type.toString2() + " must be an int.");
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitInstVarAccess(syntaxtree.InstVarAccess)
	 */
	@Override
	public Object visitInstVarAccess(InstVarAccess iVar){
		super.visitInstVarAccess(iVar);
		if(iVar.exp.type == null){
			return null;
		}
		else{
			iVar.varDec = instVarLookup(iVar.varName, globalSymTab.get(iVar.exp.getClass().toString()), iVar.pos, 
					"Error: variable " + iVar.varName + " is undeclared.");
			if(iVar.varDec != null){
				iVar.type = iVar.varDec.type;
			}
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitCast(syntaxtree.Cast)
	 */
	@Override
	public Object visitCast(Cast cast){
		super.visitCast(cast);
		if(matchTypesAssign(cast.exp.type, cast.castType, cast.pos)){
			cast.type = cast.castType;
		}
		else if (matchTypesAssign(cast.castType, cast.exp.type, -1)){
			cast.type = cast.castType;
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitInstanceOf(syntaxtree.InstanceOf)
	 */
	@Override
	public Object visitInstanceOf(InstanceOf instOf){
		super.visitInstanceOf(instOf);
		if(matchTypesAssign(instOf.exp.type, instOf.checkType, instOf.pos)){
			instOf.type = theBoolType;
		}
		else if(matchTypesAssign(instOf.checkType, instOf.exp.type, -1)){
			instOf.type = theBoolType;
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitNewObject(syntaxtree.NewObject)
	 */
	@Override
	public Object visitNewObject(NewObject newOb){
		super.visitNewObject(newOb);
		newOb.type = newOb.objType;
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitNewArray(syntaxtree.NewArray)
	 */
	@Override
	public Object visitNewArray(NewArray newArr){
		super.visitNewArray(newArr);
		if(matchTypesExact(newArr.sizeExp.type, theIntType, -1)){
			ArrayType aType = (ArrayType)newArr.objType;
			
			newArr.type = new ArrayType(newArr.pos, aType.baseType);
		}
		else if(newArr.pos >= 0){
			errorMsg.error(newArr.pos, "Error: " + newArr.sizeExp.type.toString2() + " must be an int.");
		}
		return null;
	}
	
	
    /*	
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitCall(syntaxtree.Call)
	 */
	@Override
	public Object visitCall(Call call){
		super.visitCall(call);
		if(call.obj.type == null){
			return null;
		}
		call.methodLink = methodLookup(call.methName, currentClass, call.pos, 
				"Error: " + call.methName + " is not defined.");
		int params = 0;
		int formalParams = 0;
		if(call.methodLink != null){
			if(call.parms != null){
				Enumeration<Exp> parms = call.parms.elements();
				while(parms.hasMoreElements()){
					++params;
					parms.nextElement();
				}
			}
			if(call.methodLink.formals != null){
				Enumeration<VarDecl> formalParms = call.methodLink.formals.elements();
				while(formalParms.hasMoreElements()){
					++formalParams;
					formalParms.nextElement();
				}
			}
		}
		if(params == formalParams){
			if(call.parms != null && call.methodLink != null && call.methodLink.formals != null){
				if(paramTypesMatchAssign(call.parms, call.methodLink.formals)){
					if(call.methodLink instanceof MethodDeclVoid){
						call.type = theVoidType;
					}
					else{
						call.type = ((MethodDeclNonVoid)call.methodLink).rtnType;
					}
				}
			}
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitClassDecl(syntaxtree.ClassDecl)
	 */
	@Override
	public Object visitClassDecl(ClassDecl c){
		Collection<ClassDecl> values = globalSymTab.values();
		
		currentClass = c;
		currentClassType = new IdentifierType(currentClass.pos, currentClass.name);
		currentClassType.link = currentClass;
		
		currentSuperclassType = new IdentifierType(currentClass.superLink.pos, currentClass.superLink.name);
		currentSuperclassType.link = currentClass.superLink;
		super.visitClassDecl(c);

		return null;
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitMethodDeclVoid(syntaxtree.MethodDeclVoid)
	 */
	@Override
	public Object visitMethodDeclVoid(MethodDeclVoid mdv){
		super.visitMethodDeclVoid(mdv);
		
		MethodDecl superMeth = methodLookup(mdv.name, currentClass.superLink, -1, "");
		if(superMeth != null){
			if(superMeth instanceof MethodDeclVoid){
				VarDeclList mdvParams = mdv.formals;
				int mdvParamsNum = 0;
				VarDeclList superMethParams = superMeth.formals;
				int superMethParamsNum = 0;
				if(mdvParams != null){
					for(VarDecl v : mdvParams){
						++mdvParamsNum;
					}
				}
				if(superMethParams != null){
					for(VarDecl v : superMethParams){
						++superMethParamsNum;
					}
				}
				if(mdvParamsNum == superMethParamsNum && paramTypesMatch(mdv.formals, superMeth.formals)){
					mdv.superMethod = superMeth;
				}
			}
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitMethodDeclNonVoid(syntaxtree.MethodDeclNonVoid)
	 */
	@Override
	public Object visitMethodDeclNonVoid(MethodDeclNonVoid mdnv){
		super.visitMethodDeclNonVoid(mdnv);
		
		if(matchTypesAssign(mdnv.rtnType, mdnv.rtnExp.type, mdnv.pos)){
			MethodDecl superMeth = methodLookup(mdnv.name, currentClass.superLink, -1, "");
			if(superMeth != null){
				if(superMeth instanceof MethodDeclNonVoid){
					VarDeclList mdnvParams = mdnv.formals;
					int mdnvParamsNum = 0;
					VarDeclList superMethParams = superMeth.formals;
					int superMethParamsNum = 0;
					if(mdnvParams != null){
						for(VarDecl v : mdnvParams){
							++mdnvParamsNum;
						}
					}
					if(superMethParams != null){
						for(VarDecl v : superMethParams){
							++superMethParamsNum;
						}
					}
					if(mdnvParamsNum == superMethParamsNum && paramTypesMatch(mdnv.formals, superMeth.formals)){
						if(matchTypesExact(mdnv.rtnType, ((MethodDeclNonVoid) superMeth).rtnType, -1)){
							mdnv.superMethod = superMeth;
						}
					}
				}
			}
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitAssign(syntaxtree.Assign)
	 */
	@Override
	public Object visitAssign(Assign ass){
		super.visitAssign(ass);
		if(ass.lhs instanceof IdentifierExp || ass.lhs instanceof ArrayLookup || 
				ass.lhs instanceof InstVarAccess){
					if(matchTypesAssign(ass.rhs.type, ass.lhs.type, ass.pos)){
						
					}
				}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitLocalVarDecl(syntaxtree.LocalVarDecl)
	 */
	@Override
	public Object visitLocalVarDecl(LocalVarDecl lVar){
		super.visitLocalVarDecl(lVar);
		
		if(matchTypesAssign(lVar.initExp.type, lVar.type, lVar.pos)){
			
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitIf(syntaxtree.If)
	 */
	@Override
	public Object visitIf(If ifStmt){
		super.visitIf(ifStmt);
		if(matchTypesExact(ifStmt.exp.type, theBoolType, ifStmt.pos)){
			
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitWhile(syntaxtree.While)
	 */
	@Override
	public Object visitWhile(While whileStmt){
		super.visitWhile(whileStmt);
		if(matchTypesExact(whileStmt.exp.type, theBoolType, whileStmt.pos)){
			
		}
		return null;
	}
	
	
	/**
	 * A helper method to determine if two methods parameter types match.
	 * @param mdv -- The first MethodDeclVoid
	 * @param mdvSuper -- The second MethodDeclVoid
	 * @return success/failure
	 */
	private boolean paramTypesMatch(VarDeclList varList1, VarDeclList varList2){
		boolean success = false;
		
		for(VarDecl v1 : varList1){
			for(VarDecl v2 : varList2){
				if(matchTypesExact(v1.type, v2.type, -1)){
					success = true;
					break;
				}
				success = false;
			}
		}
		return success;
		
	}
	
	
	/**
	 * 
	 * @param expList
	 * @param varList
	 * @return
	 */
	private boolean paramTypesMatchAssign(ExpList expList, VarDeclList varList){
		boolean success = false;
		for(Exp ex : expList){
			for(VarDecl var : varList){
				if(matchTypesAssign(ex.type, var.type, -1)){
					if(matchTypesAssign(var.type, ex.type, -1)){
						success = true;
						break;
					}
				}
			}
		}
		return success;
	}
	
	
	/**
	 * (Adapted from Dr. Steven Vegdahl)
	 * 
	 * A helper method to determine if the type to evaluate (have) matches
	 * the required type (need).
	 * 
	 * @param have -- The type to evaluate
	 * @param need -- The required type
	 * @param pos -- The position
	 * 
	 * @return success/failure
	 */
	private boolean matchTypesExact(Type have, Type need, int pos){
		if(have == null){
			return false;
		}
		if(have.equals(need)){
			return true;
		}
		
		if(pos >= 0){
			errorMsg.error(pos, "Error: Incompatible types (" + have.toString2() + ", " + need.toString2() + ").");
		}
		return false;
	}
	
	
	/**
	 * (Adapted from Dr. Steven Vegdahl).
	 * 
	 * A helper method to determing is (src) is assignment-compatible
	 * with (target).
	 * 
	 * @param src -- 
	 * @param target
	 * @param pos
	 * @return
	 */
	private boolean matchTypesAssign(Type src, Type target, int pos){		
		if(src == null || target == null){
			return false;
		}
		
		ClassDecl targetClass = globalSymTab.get(target.toString2());
		ClassDecl srcClass = globalSymTab.get(src.toString2());
		
		if(src.equals(theVoidType) || target.equals(theVoidType) && pos >= 0){
			errorMsg.error(pos, "Error: Incompatible types (" + src.toString2() + 
					", " + target.toString2() + ").");
		}
		else if(src.equals(target)){
			return true;
		}
		else if(src.equals(theNullType) && (target instanceof IdentifierType || 
				target instanceof ArrayType)){
			return true;
		}
		else if(src instanceof ArrayType && target instanceof IdentifierType && 
				target.toString2().equals("Object")){
			return true;
		}
		else if(src instanceof IdentifierType && isSuperClass(srcClass.superLink, targetClass)){
			return true;
		}
		else{
			if(pos >= 0){
				errorMsg.error(pos,  "Error: Incompatible types (" + src.toString2() + ", " + target.toString2() + ").");
			}
		}
		return false;
	}
	
	
	/**
	 * (Adapted from Dr. Steven Vegdahl)
	 * 
	 * A helper method to determine if the types (t1 & t2)
	 * can be compared using == or !=.
	 * 
	 * @param t1 -- The first type to compare.
	 * @param t2 -- The second type to compare.
	 * @param pos -- The position
	 * 
	 * @return success/failure
	 */
	private boolean matchTypesEqCompare(Type t1, Type t2, int pos){
		if(t1 == null || t2 == null){
			return false;
		}
		else if(matchTypesAssign(t1, t2, -1) && matchTypesAssign(t2, t1, -1)){
			return true;
		}
		else{
			if(pos >= 0){
				errorMsg.error(pos, "Error: Incompatible types (" + t1.toString2() + ", " + t2.toString2() + ").");
			}
		}
		return false;
	}
	
	
	/**
	 * A helper method to determine if (target) matches the superclass
	 * of the given class.
	 * @param superClass -- The superclass
	 * @param target -- The target class.
	 * 
	 * @return success/failure
	 */
	private boolean isSuperClass(ClassDecl superClass, ClassDecl target){
		if (superClass == null || target == null){
			return false;
		}
		else if(target.name.equals(superClass.name)){
			return true;
		}
		return isSuperClass(target, superClass.superLink);
	}
	
	
	/**
	 * (Adapted from Dr. Steven Vegdahl)
	 * A helper method to look up an instance variable declaration
	 * object for the class (c) or null.
	 * @param name -- The name of the instance variable
	 * @param c -- the name of the class
	 * @param pos -- The instance variable position
	 * @param msg -- The error message to print (if applicable)
	 * @return -- The instance variable (or null)
	 */
	private InstVarDecl instVarLookup(String name, ClassDecl c, int pos, String msg){
		if(c != null){
			if(c.instVarTable.get(name) != null){
				return c.instVarTable.get(name);
			}
			else if(c.superLink != null){
				instVarLookup(name, c.superLink, pos, msg);
			}
		}
		if(pos >= 0){
			errorMsg.error(pos,  msg);
		}
		return null;
	}
	
	
	/**
	 * (Adapted from Dr. Steven Vegdahl)
	 * A helper method which determines if a method declaration (name)
	 * is in the current class or its superclasses.
	 * @param name -- The name of the method
	 * @param c -- The current class
	 * @param pos -- The position of the method
	 * @param msg -- The error message to print (if applicable).
	 * @return -- The method declaration (or null)
	 */
	private MethodDecl methodLookup(String name, ClassDecl c, int pos, String msg){
		if(c != null){
			if(c.methodTable.get(name) != null){
				return c.methodTable.get(name);
			}
			else if(c.superLink != null){
				methodLookup(name, c.superLink, pos, msg);
			}
		}
		if(pos >= 0){
			errorMsg.error(pos, msg);
		}
		return null;
	}
}
	
