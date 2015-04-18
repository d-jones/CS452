package visitor;

import syntaxtree.*;

public abstract class InhVisitor implements Visitor {
	
	public final Object visit(AstNode n) {
		return n.accept(this);
	}

	public abstract Object visitAstNode(AstNode n);
	
	public abstract Object visitAstList(AstList n);
	
	public Object visitAnd(And n) {
		return visitBinExp(n);
	}
	public Object visitArrayLength(ArrayLength n) {
		return visitUnExp(n);
	}
	public Object visitArrayLookup(ArrayLookup n) {
		return visitExp(n);
	}
	public Object visitArrayType(ArrayType n) {
		return visitType(n);
	}
	public Object visitAssign(Assign n) {
		return visitStatement(n);
	}
	public Object visitBlock(Block n) {
		return visitStatement(n);
	}
	public Object visitBinExp(BinExp n) {
		return visitExp(n);
	}
	public Object visitBooleanType(BooleanType n) {
		return visitType(n);
	}
	public Object visitBreak(Break n) {
		return visitStatement(n);
	}
	public Object visitCall(Call n) {
		return visitExp(n);
	}
	public Object visitCast(Cast n) {
		return visitExp(n);
	}
	public Object visitCase(Case n) {
		return visitStatement(n);
	}
	public Object visitClassDecl(ClassDecl n) {
		return visitDecl(n);
	}
	public Object visitDecl(Decl n) {
		return visitStatement(n);
	}
	public Object visitDivide(Divide n) {
		return visitBinExp(n);
	}
	public Object visitEquals(Equals n) {
		return visitBinExp(n);
	}
	public Object visitExp(Exp n) {
		return visitAstNode(n);
	}
	public Object visitExpStatement(ExpStatement n) {
		return visitStatement(n);
	}
	public Object visitFalse(False n) {
		return visitExp(n);
	}
  	public Object visitFormalDecl(FormalDecl n) {
		return visitVarDecl(n);
	}
	public Object visitGreaterThan(GreaterThan n) {
		return visitBinExp(n);
	}
	public Object visitIdentifierExp(IdentifierExp n) {
		return visitExp(n);
	}
	public Object visitIdentifierType(IdentifierType n) {
		return visitType(n);
	}
	public Object visitIf(If n) {
		return visitStatement(n);
	}
	public Object visitInstVarAccess(InstVarAccess n) {
		return visitExp(n);
	}
  	public Object visitInstVarDecl(InstVarDecl n) {
		return visitVarDecl(n);
	}
	public Object visitIntegerLiteral(IntegerLiteral n) {
		return visitExp(n);
	}
	public Object visitIntegerType(IntegerType n) {
		return visitType(n);
	}
	public Object visitLessThan(LessThan n) {
		return visitBinExp(n);
	}
  	public Object visitLocalVarDecl(LocalVarDecl n) {
		return visitVarDecl(n);
	}
	public Object visitMethodDecl(MethodDecl n) {
		return visitDecl(n);
	}
	public Object visitMethodDeclNonVoid(MethodDeclNonVoid n) {
		return visitMethodDecl(n);
	}
	public Object visitMethodDeclVoid(MethodDeclVoid n) {
		return visitMethodDecl(n);
	}
  	public Object visitMinus(Minus n) {
		return visitBinExp(n);
	}
  	public Object visitNewArray(NewArray n) {
		return visitExp(n);
	}
  	public Object visitNewObject(NewObject n) {
		return visitExp(n);
	}
  	public Object visitNot(Not n) {
		return visitUnExp(n);
	}
  	public Object visitNull(Null n) {
		return visitExp(n);
	}
	public Object visitNullType(NullType n) {
		return visitType(n);
	}
  	public Object visitOr(Or n) {
		return visitBinExp(n);
	}
  	public Object visitPlus(Plus n) {
		return visitBinExp(n);
	}
  	public Object visitProgram(Program n) {
		return visitAstNode(n);
	}
  	public Object visitRemainder(Remainder n) {
		return visitBinExp(n);
	}
  	public Object visitStatement(Statement n) {
		return visitAstNode(n);
	}
  	public Object visitStringLiteral(StringLiteral n) {
		return visitExp(n);
	}
  	public Object visitSuper(Super n) {
		return visitExp(n);
	}
	public Object visitSwitch(Switch n) {
		return visitStatement(n);
	}
  	public Object visitThis(This n) {
		return visitExp(n);
	}
  	public Object visitTimes(Times n) {
		return visitBinExp(n);
	}
  	public Object visitTrue(True n) {
		return visitExp(n);
	}
  	public Object visitType(Type n) {
		return visitAstNode(n);
	}
  	public Object visitUnExp(UnExp n) {
		return visitExp(n);
	}
  	public Object visitVarDecl(VarDecl n) {
		return visitDecl(n);
	}
	public Object visitVoidType(VoidType n) {
		return visitType(n);
	}
  	public Object visitWhile(While n) {
		return visitStatement(n);
	}
  	
  	public Object visitClassDeclList(ClassDeclList n) {
		return visitAstList(n);
	}
  	public Object visitExpList(ExpList n) {
		return visitAstList(n);
	}
  	public Object visitDeclList(DeclList n) {
		return visitAstList(n);
	}
  	public Object visitStatementList(StatementList n) {
		return visitAstList(n);
	}
  	public Object visitVarDeclList(VarDeclList n) {
		return visitAstList(n);
	}
}

