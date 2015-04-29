package visitor;

import syntaxtree.*;

import errorMsg.*;
import java.io.*;

public class CG3Visitor extends ASTvisitor {


	// the purpose here is to annotate things with their offsets:
	// - formal parameters, with respect to the (callee) frame
	// - local variables, with respect to the frame
	// - instance variables, with respect to their slot in the object
	// - methods, with respect to their slot in the v-table
	// - while statements, with respect to the stack-size at the time
	//   of loop-exit
	
	// IO stream to which we will emit code
	CodeStream code;

	// current stack height
	int stackHeight;
	
	// error-message object
	ErrorMsg errorMsg;
	
	public CG3Visitor(ErrorMsg e, PrintStream out) {
		initInstanceVars(e, out);
	}
	
	private void initInstanceVars(ErrorMsg e, PrintStream out) {
		errorMsg = e;
		code = new CodeStream(out, errorMsg);
		stackHeight = 0;
	}
	
	
	
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitAnd(syntaxtree.And)
	 */
	@Override
	public Object visitAnd(And a){
		code.indent(a);
		
		a.left.accept(this);
		code.emit(a, "lw $t0, ($sp)");
		code.emit(a, "beq $t0, $zero, skip_" + a.uniqueId);
		code.emit(a, "addu $sp, $sp, 4");
		stackHeight -= 4;
		a.right.accept(this);
		code.emit(a,  "skip_" + a.uniqueId + ":");
		
		code.unindent(a);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitArrayLength(syntaxtree.ArrayLength)
	 */
	@Override
	public Object visitArrayLength(ArrayLength al){
		code.indent(al);
		
		al.exp.accept(this);
		code.emit(al, "lw $t0, ($sp)");
		code.emit(al, "beq $t0, $zero, nullPtrException");
		code.emit(al, "lw $t0, -4($t0)"); //-4($t0)...
		code.emit(al, "sw $s5, ($sp)");
		code.emit(al, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(al, "sw $t0, ($sp)");
		
		code.unindent(al);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitArrayLookup(syntaxtree.ArrayLookup)
	 */
	@Override
	public Object visitArrayLookup(ArrayLookup a){
		code.indent(a);
		
		a.arrExp.accept(this);
		a.idxExp.accept(this);
		code.emit(a, "lw $t0, 8($sp)");
		code.emit(a, "beq $t0, $zero, nullPtrException");
		code.emit(a, "lw $t1, -4($t0)");
		code.emit(a, "lw $t2, ($sp)");
		code.emit(a, "bgeu $t2, $t1, arrayIndexOutOfBounds");
		code.emit(a, "sll $t2, $t2, 2");
		code.emit(a, "addu $t2, $t2, $t0");
		code.emit(a, "lw $t0, ($t2)");
		
		//Type arrType = ((IdentifierExp)a.arrExp).link.type;
		
		
		//System.out.println(arrType);
		if(a.type instanceof IntegerType){
			code.emit(a, "sw $t0, 4($sp)");
			code.emit(a, "sw $s5, 8($sp)");
			code.emit(a, "addu $sp, $sp, 4");
			stackHeight -= 4;
		}
		else if(a.type instanceof Object || a.type instanceof ArrayType
			|| a.type instanceof BooleanType){
				code.emit(a, "sw $t0, 8($sp)");
				code.emit(a, "addu $sp, $sp, 8");
				stackHeight -= 8;
			}
		
		code.unindent(a);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitAssign(syntaxtree.Assign)
	 */
	@Override
	public Object visitAssign(Assign a){
		code.indent(a);
		
		if(a.lhs instanceof IdentifierExp){
			a.rhs.accept(this);
			code.emit(a, "lw $t0, ($sp)");
			VarDecl var = ((IdentifierExp)a.lhs).link;
			
			if(var instanceof InstVarDecl){
				int NNN = var.offset;
				code.emit(a, "sw $t0, " + NNN + "($s2)");
			}
			else if(var instanceof LocalVarDecl || var instanceof FormalDecl){
				int MMM = stackHeight + var.offset;
				code.emit(a, "sw $t0, " + MMM + "($sp)");
			}
			
			if(var.type instanceof IntegerType){
				code.emit(a, "addu $sp, $sp, 8");
				stackHeight -= 8;
			}
			else if(var.type instanceof Object || var.type instanceof ArrayType || var.type instanceof BooleanType){
				code.emit(a, "addu $sp, $sp, 4");
				stackHeight -= 4;
			}	
		}
		//ARRAY LOOKUP
		else if(a.lhs instanceof ArrayLookup){
			ArrayLookup arr = (ArrayLookup)a.lhs;
			arr.arrExp.accept(this);
			arr.idxExp.accept(this);
			a.rhs.accept(this);
			code.emit(a, "lw $t0, ($sp)");
			
			if(a.rhs.type instanceof IntegerType){
				code.emit(a, "lw $t1, 16($sp)");
				code.emit(a, "beq $t1, $zero, nullPtrException");
				code.emit(a, "lw $t2, 8($sp)");
				code.emit(a, "lw $t3, -4($t1)");
				code.emit(a, "bgeu $t2, $t3, arrayIndexOutOfBounds");
				code.emit(a, "sll $t2, $t2, 2");
				code.emit(a, "addu $t2, $t2, $t1");
				code.emit(a, "sw $t0, ($t2)");
				code.emit(a, "addu $sp, $sp, 20");
				stackHeight -= 20;
			}
			else{
				code.emit(a, "lw $t1, 12($sp)");
				code.emit(a, "beq $t1, $zero, nullPtrException");
				code.emit(a, "lw $t2, 4($sp)");
				code.emit(a, "lw $t3, -4($t1)");
				code.emit(a, "bgeu $t2, $t3, arrayIndexOutOfBounds");
				code.emit(a, "sll $t2, $t2, 2");
				code.emit(a, "addu $t2, $t2, $t1");
				code.emit(a, "sw $t0, ($t2)");
				code.emit(a, "addu $sp, $sp, 16");
				stackHeight -= 16;
			}
		}
		//INSTANCE VAR ACCESS
		else if(a.lhs instanceof InstVarAccess){
			InstVarAccess iva = (InstVarAccess)a.lhs;
			iva.exp.accept(this);
			a.rhs.accept(this);
			code.emit(a, "lw $t0, ($sp)");
			int SSS;
			if(a.lhs.type instanceof IntegerType){
				SSS = 8;
			}
			else{
				SSS = 4;
			}
			code.emit(a,  "lw $t1, " + SSS + "($sp)");
			code.emit(a, "beq $t1, $zero, nullPtrException");
			int NNN = iva.varDec.offset;
			code.emit(a, "sw $t0, " + NNN + "($t1)");
			
			if(a.lhs.type instanceof IntegerType){
				code.emit(a, "addu $sp, $sp, 12");
				stackHeight -= 12;
			}
			else if(a.lhs.type instanceof Object || a.lhs.type instanceof ArrayType || 
					a.lhs.type instanceof BooleanType){
				code.emit(a, "addu $sp, $sp, 8");
				stackHeight -= 8;
			}
		}
		
		code.unindent(a);
		return null;
	}
	
	
	/*
	 * 
	 */
	@Override
	public Object visitBlock(Block b){
		code.indent(b);
		
		int sHeight = stackHeight;
		b.stmts.accept(this);
		if(sHeight - stackHeight != 0){
			int DDD = stackHeight - sHeight;
			code.emit(b, "addu $sp, " + DDD);
		}
		stackHeight = sHeight;
		
		code.unindent(b);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitBreak(syntaxtree.Break)
	 */
	@Override
	public Object visitBreak(Break b){
		code.indent(b);
		
		int NNN = stackHeight - b.breakLink.stackHeight;
		if(NNN != 0){
			code.emit(b, "addu $sp, " + NNN);
		}
		code.emit(b, "j while_exit_" + b.breakLink.uniqueId);
		
		code.unindent(b);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitThis(syntaxtree.This)
	 */
	@Override
	public Object visitCall(Call c){
		code.indent(c);
		
		int sHeight = stackHeight;
		c.obj.accept(this);
		c.parms.accept(this); 
		/*for(Exp e : c.parms){
			e.accept(this);
		}*/
		
		//calling a super method
		if(c.obj instanceof Super){
			if(c.methodLink.pos < 0){
				code.emit(c, "jal " + c.methName); //c.methodLink.name?
			}
			else if(c.methodLink.pos > 0){
				code.emit(c, "jal fcn_" + c.methodLink.uniqueId + "_" + c.methName);
			}
		}
		//not a super method
		else{
			int MMM = c.methodLink.thisPtrOffset - 4;
			int NNN = 4*c.methodLink.vtableOffset;
			code.emit(c, "lw $t0, " + MMM + "($sp)");
			code.emit(c, "beq $t0, $zero, nullPtrException");
			code.emit(c, "lw $t0, -12($t0)");
			code.emit(c, "lw $t0, " + NNN + "($t0)");
			code.emit(c, "jalr $t0");
		}
		
		if(c.type instanceof IntegerType){
			stackHeight = sHeight + 8;
		}
		else if(c.type instanceof VoidType){
			stackHeight = sHeight;
		}
		else{
			stackHeight = sHeight + 4;
		}
		
		code.unindent(c);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitCast(syntaxtree.Cast)
	 */
	@Override
	public Object visitCast(Cast c){
		code.indent(c);
		
		c.exp.accept(this);
		
		code.emit(c, "la $t0, CLASS_" + c.castType);
		code.emit(c, "la $t1, CLASS_END_" + c.castType);
		code.emit(c, "jal checkCast");
		
		code.unindent(c);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitDivide(syntaxtree.Divide)
	 */
	@Override
	public Object visitDivide(Divide d){
		code.indent(d);
		
		d.left.accept(this);
		d.right.accept(this);
		code.emit(d, "jal divide");
		stackHeight -= 8;
		
		code.unindent(d);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitEquals(syntaxtree.Equals)
	 */
	@Override
	public Object visitEquals(Equals eq){
		code.indent(eq);
		
		eq.left.accept(this);
		eq.right.accept(this);
		if(eq.left.type instanceof IntegerType && eq.right.type instanceof IntegerType){
			code.emit(eq, "lw $t0, ($sp)");
			code.emit(eq, "lw $t1, 8($sp)");
			code.emit(eq, "seq $t0, $t0, $t1");
			code.emit(eq, "addu $sp, $sp, 12");
			stackHeight -= 12;
			code.emit(eq, "sw $t0, ($sp)");
		}
		else{
			code.emit(eq, "lw $t0, ($sp)");
			code.emit(eq, "lw $t1, 4($sp)");
			code.emit(eq, "seq $t0, $t0, $t1");
			code.emit(eq, "addu $sp, $sp, 4");
			stackHeight -= 4;
			code.emit(eq, "sw $t0, ($sp)");
		}
		
		code.unindent(eq);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitExpStatement(syntaxtree.ExpStatement)
	 */
	@Override
	public Object visitExpStatement(ExpStatement exp){
		code.indent(exp);
		
		exp.exp.accept(this);
		if(exp.exp.type instanceof IntegerType){
			code.emit(exp, "addu $sp, $sp, 8");
			stackHeight -= 8;
		}
		else if(!(exp.exp.type instanceof VoidType)){
			code.emit(exp, "addu $sp, $sp, 4");
			stackHeight -= 4;
		}
		
		code.unindent(exp);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitFalse(syntaxtree.False)
	 */
	@Override
	public Object visitFalse(False f){
		code.indent(f);
		
		code.emit(f, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(f, "sw $zero, ($sp)");
		
		code.unindent(f);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitGreaterThan(syntaxtree.GreaterThan)
	 */
	@Override
	public Object visitGreaterThan(GreaterThan gt){
		code.indent(gt);
		
		gt.left.accept(this);
		gt.right.accept(this);
		code.emit(gt, "lw $t0, ($sp)");
		code.emit(gt, "lw $t1, 8($sp)");
		code.emit(gt, "sgt $t0, $t1, $t0");
		code.emit(gt, "addu $sp, $sp, 12");
		stackHeight -= 12;
		code.emit(gt, "sw $t0, ($sp)");
		
		code.unindent(gt);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitIdentifierExp(syntaxtree.IdentifierExp)
	 */
	@Override
	public Object visitIdentifierExp(IdentifierExp iExp){
		code.indent(iExp);
		
		//the variable is a LocalVarDecl
		Type expType = iExp.link.type;
		if(iExp.link instanceof InstVarDecl){
			int NNN = iExp.link.offset;
			code.emit(iExp, "lw $t0, " + NNN + "($s2)");
		}
		//the variable is an InstVarDecl
		else{
			int sDepth = stackHeight + iExp.link.offset;
			code.emit(iExp, "lw $t0, " + sDepth + "($sp)");
		}
		
		//the variable is an integer
		if(expType instanceof IntegerType){
			code.emit(iExp, "subu $sp, $sp, 8");
			stackHeight += 8;
			code.emit(iExp,  "sw $s5, 4($sp)");
			code.emit(iExp,  "sw $t0, ($sp)");
		}
		else if(expType instanceof Object || expType instanceof ArrayType || 
				expType instanceof BooleanType){
			code.emit(iExp, "subu $sp, $sp, 4");
			stackHeight += 4;
			code.emit(iExp,  "sw $t0, ($sp)");
		}
		
		code.unindent(iExp);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitIf(syntaxtree.If)
	 */
	@Override
	public Object visitIf(If i){
		code.indent(i);
		
		i.exp.accept(this);
		code.emit(i, "lw $t0, ($sp)");
		code.emit(i, "addu $sp, $sp, 4");
		stackHeight -= 4;
		code.emit(i, "beq $t0, $zero, if_else_" + i.uniqueId);
		
		i.trueStmt.accept(this);
		code.emit(i, "j if_done_" + i.uniqueId);
		code.emit(i, "if_else_" + i.uniqueId + ":");
		
		i.falseStmt.accept(this);
		code.emit(i, "if_done_" + i.uniqueId + ":");
		
		code.unindent(i);
		return null;
	}
	
	
	/*	
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitInstanceOf(syntaxtree.InstanceOf)
	 **/
	@Override
	public Object visitInstanceOf(InstanceOf in){
		code.indent(in);
		
		in.exp.accept(this);
		code.emit(in, "la $t0, CLASS_" + in.checkType.toString2());
		code.emit(in, "la $t1, CLASS_END_" + in.checkType.toString2());
		code.emit(in, "jal instanceOf");
		
		code.unindent(in);
		return null;
	}
	

	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitInstVarAccess(syntaxtree.InstVarAccess)
	 */
	@Override
	public Object visitInstVarAccess(InstVarAccess iva){
		code.indent(iva);
		
		iva.exp.accept(this);
		int NNN = iva.varDec.offset;
		code.emit(iva, "lw $t0, ($sp)");
		code.emit(iva, "beq $t0, $zero, nullPtrException");
		code.emit(iva, "lw $t0, " + NNN + "($t0)"); //NNN($sp)?????
		
		if(iva.varDec.type instanceof IntegerType){
			code.emit(iva, "subu $sp, $sp, 4"); //is this supposed to be 8???
			stackHeight += 4; //Is this the correct placement???????????
			code.emit(iva, "sw $s5, 4($sp)");
			code.emit(iva, "sw $t0, ($sp)");
		}
		else if(iva.varDec.type instanceof Object || iva.varDec.type instanceof ArrayType
				|| iva.varDec.type instanceof BooleanType){
			code.emit(iva, "sw $t0, ($sp)");
		}
		
		code.unindent(iva);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitIntegerLiteral(syntaxtree.IntegerLiteral)
	 */
	@Override
	public Object visitIntegerLiteral(IntegerLiteral intLit){
		code.indent(intLit);
		
		code.emit(intLit, "subu $sp, $sp, 8");
		stackHeight += 8;
		code.emit(intLit,  "sw $s5, 4($sp)");
		code.emit(intLit, "li $t0, " + intLit.val);
		code.emit(intLit, "sw $t0, ($sp)");
		
		code.unindent(intLit);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitLessThan(syntaxtree.LessThan)
	 */
	@Override
	public Object visitLessThan(LessThan lt){
		code.indent(lt);
		
		lt.left.accept(this);
		lt.right.accept(this);
		code.emit(lt, "lw $t0, ($sp)");
		code.emit(lt, "lw $t1, 8($sp)");
		code.emit(lt, "slt $t0, $t1, $t0");
		code.emit(lt, "addu $sp, $sp, 12");
		stackHeight -= 12;
		code.emit(lt, "sw $t0, ($sp)");
		
		code.unindent(lt);
		return null;
	}
	

	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitLocalVarDecl(syntaxtree.LocalVarDecl)
	 */
	@Override
	public Object visitLocalVarDecl(LocalVarDecl lVar){
		code.indent(lVar);
		
		lVar.initExp.accept(this);
		if(lVar.type instanceof IntegerType){
			lVar.offset = -stackHeight;
		}
		else{
			lVar.offset = -stackHeight;
		}
		
		code.unindent(lVar);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitMethodDeclNonVoid(syntaxtree.MethodDeclNonVoid)
	 */
	@Override
	public Object visitMethodDeclNonVoid(MethodDeclNonVoid m){
		code.indent(m);
		
		code.emit(m, ".globl fcn_" + m.uniqueId + "_" + m.name); 	//.globl fcn_999_methodName
		code.emit(m, "fcn_" + m.uniqueId + "_" + m.name + ":"); 			//fcn_999_methodName
		code.emit(m,  "subu $sp, $sp, 8"); 								//subu $sp, $sp, 8
		code.emit(m, "sw $ra, 4($sp)"); 									//sw $41, 4($sp)
		code.emit(m, "sw $s2, ($sp)");									//sw $s2, ($sp)
		stackHeight = 4;
		int NNN = 4 + m.thisPtrOffset;									//
		code.emit(m, "lw $s2, " + NNN + "($sp)");						//lw $s2, NNN($sp)
		m.stmts.accept(this);
		m.rtnExp.accept(this);
		int JJJ = stackHeight;												//the depth of the return address?
		int KKK = stackHeight - 4;														//saved this-pointer?
		code.emit(m, "lw $ra, " + JJJ + "($sp)");
		code.emit(m, "lw $s2, " + KKK + "($sp)");
		
		int parmsSpace = 0;
		for(VarDecl var : m.formals){
			if(var.type instanceof IntegerType){
				parmsSpace += 8;
			}
			else{
				parmsSpace += 4;
			}
		}
		
		int MMM;
		int YYY = stackHeight + m.thisPtrOffset;
		
		if(m.rtnType instanceof IntegerType){
			YYY -= 4;
			int ZZZ = YYY + 4;
			code.emit(m, "lw $t0, ($sp)");
			code.emit(m, "sw $t0, " + YYY + "($sp)");
			code.emit(m, "sw $s5, " + ZZZ + "($sp)");
			
			MMM = stackHeight + parmsSpace;
		}
		else{
			code.emit(m, "lw $t0, ($sp)");
			code.emit(m, "sw $t0, " + YYY + "($sp)");
			MMM = stackHeight + parmsSpace + 4;
		}
		
		code.emit(m, "addu $sp, $sp, " + MMM);
		code.emit(m, "jr $ra");
		
		code.indent(m);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitMethodDeclVoid(syntaxtree.MethodDeclVoid)
	 */
	@Override
	public Object visitMethodDeclVoid(MethodDeclVoid meth){
		code.indent(meth);
		
		code.emit(meth, ".globl fcn_" + meth.uniqueId + "_" + meth.name); 	//.globl fcn_999_methodName
		code.emit(meth, "fcn_" + meth.uniqueId + "_" + meth.name + ":"); 			//fcn_999_methodName
		code.emit(meth,  "subu $sp, $sp, 8"); 								//subu $sp, $sp, 8
		code.emit(meth, "sw $ra, 4($sp)"); 									//sw $41, 4($sp)
		code.emit(meth, "sw $s2, ($sp)");									//sw $s2, ($sp)
		stackHeight = 4;
		int NNN = 4 + meth.thisPtrOffset;									//
		code.emit(meth, "lw $s2, " + NNN + "($sp)");						//lw $s2, NNN($sp)
		meth.stmts.accept(this);											//generate code for method's body
		int JJJ = stackHeight;												//the depth of the return address?
		int KKK = stackHeight - 4;														//saved this-pointer?
		code.emit(meth, "lw $ra, " + JJJ + "($sp)");
		code.emit(meth, "lw $s2, " + KKK + "($sp)");
		
		int parmsSpace = 0;
		for(VarDecl var : meth.formals){
			if(var.type instanceof IntegerType){
				parmsSpace += 8;
			}
			else{
				parmsSpace += 4;
			}
		}
		
		int MMM = stackHeight + 4  + parmsSpace+ 4;
		code.emit(meth, "addu $sp, $sp, " + MMM);
		code.emit(meth, "jr $ra");
		
		code.unindent(meth);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitMinus(syntaxtree.Minus)
	 */
	@Override
	public Object visitMinus(Minus minus){
		code.indent(minus);
		
		minus.left.accept(this);
		minus.right.accept(this);
		code.emit(minus, "lw $t0, ($sp)");
		code.emit(minus, "lw $t1, 8($sp)");
		code.emit(minus, "subu $t0, $t1, $t0");
		code.emit(minus, "addu $sp, $sp, 8");
		stackHeight -= 8;
		code.emit(minus, "sw $t0, ($sp)");
		
		code.indent(minus);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitNewArray(syntaxtree.NewArray)
	 */
	@Override
	public Object visitNewArray(NewArray arr){
		code.indent(arr);
		
		arr.sizeExp.accept(this);
		code.emit(arr, "lw $s7, ($sp)");
		code.emit(arr, "addu $sp, $sp, 8");
		stackHeight -= 8;
		
		if(arr.type instanceof IntegerType || arr.type instanceof BooleanType){
			code.emit(arr, "li $s6, -1");
		}
		else if(!(arr.type instanceof VoidType)){
			code.emit(arr, "li $s6, 0");
		}
		
		code.emit(arr,  "jal newObject");
		stackHeight += 4;
		
		code.unindent(arr);
		return null;
	}
	
	/*
	 *  (non-Javadoc)
	 * @see visitor.ASTvisitor#visitNewObject(syntaxtree.NewObject)
	 */
	@Override
	public Object visitNewObject(NewObject no){
		code.indent(no);
		
		int NNN = no.objType.link.numObjInstVars;
		int MMM = no.objType.link.numDataInstVars + 1;
		code.emit(no, "li $s6, " + MMM);
		code.emit(no, "li $s7, " + NNN);
		code.emit(no, "jal newObject");
		stackHeight += 4;
		code.emit(no, "la $t0, CLASS_" + no.objType.name);
		code.emit(no, "sw $t0, -12($s7)");
		
		
	/*	code.emit(no, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(no, "sw $zero, ($sp)");*/
		
		code.unindent(no);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitNot(syntaxtree.Not)
	 */
	@Override
	public Object visitNot(Not n){
		code.indent(n);
		
		n.exp.accept(this);
		code.emit(n, "lw $t0, ($sp)");
		code.emit(n, "xor $t0, $t0, 1");
		code.emit(n, "sw $t0, ($sp)");
		
		code.unindent(n);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitNull(syntaxtree.Null)
	 */
	@Override
	public Object visitNull(Null n){
		code.indent(n);
		
		code.emit(n, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(n, "sw $zero, ($sp)");
		
		code.unindent(n);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitOr(syntaxtree.Or)
	 */
	@Override
	public Object visitOr(Or o){
		code.indent(o);
		
		o.left.accept(this);
		code.emit(o, "lw $t0, ($sp)");
		code.emit(o, "bne $t0, $zero, skip_" + o.uniqueId);
		code.emit(o, "addu $sp, $sp, 4");
		stackHeight -= 4;
		o.right.accept(this);
		code.emit(o, "skip_" + o.uniqueId + ":");
		
		code.unindent(o);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitPlus(syntaxtree.Plus)
	 */
	@Override
	public Object visitPlus(Plus plus){
		code.indent(plus);
		
		plus.left.accept(this);
		plus.right.accept(this);
		code.emit(plus, "lw $t0, ($sp)");
		code.emit(plus, "lw $t1, 8($sp)");
		code.emit(plus, "addu $t0, $t0, $t1");
		code.emit(plus, "addu $sp, $sp, 8");
		stackHeight -= 8;
		code.emit(plus, "sw $t0, ($sp)");
		
		code.unindent(plus);
		return null;
	}
	

	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitProgram(syntaxtree.Program)
	 */
	@Override
	public Object visitProgram(Program prog){
		code.indent(prog);
		
		//prog.mainStatement.accept(this);
		//code.emit(prog, "CLASS_Object:");
		//code.emit(prog, "CLASS_String:");
		
		code.emit(prog,  ".text");
		code.emit(prog, ".globl main");
		code.emit(prog, "main:");
		code.emit(prog, "jal vm_init");
		this.stackHeight = 0;
		
		prog.mainStatement.accept(this);
		
		code.emit(prog, "li $v0, 10");
		code.emit(prog,  "syscall");
		prog.classDecls.accept(this);
		code.flush();
		
		code.unindent(prog);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitRemainder(syntaxtree.Remainder)
	 */
	@Override
	public Object visitRemainder(Remainder r){
		code.indent(r);
		
		r.left.accept(this);
		r.right.accept(this);
		code.emit(r, "jal remainder");
		stackHeight -= 8;
		
		code.unindent(r);
		return null;
	}

	
	@Override
	public Object visitStringLiteral(StringLiteral s){
		code.indent(s);
		
		code.emit(s, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(s, "la $t0, strLit_" + s.uniqueCgRep.uniqueId);
		code.emit(s, "sw $t0, ($sp)");
		
		code.unindent(s);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitThis(syntaxtree.This)
	 */
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitThis(syntaxtree.This)
	 */
	@Override
	public Object visitSuper(Super s){
		code.indent(s);
		
		code.emit(s, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(s, "sw $s2, ($sp)");
		
		code.unindent(s);
		return null;
	}

	@Override
	public Object visitThis(This t){
		code.indent(t);
		
		code.emit(t, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(t, "sw $s2, ($sp)");
		
		code.unindent(t);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitTimes(syntaxtree.Times)
	 */
	@Override
	public Object visitTimes(Times t){
		code.indent(t);
		
		t.left.accept(this);
		t.right.accept(this);
		code.emit(t, "lw $t0, ($sp)");
		code.emit(t, "lw $t1, 8($sp)");
		code.emit(t, "mult $t0, $t1");
		code.emit(t, "mflo $t0");
		code.emit(t, "addu $sp, $sp, 8");
		stackHeight -= 8;
		code.emit(t, "sw $t0, ($sp)");
		
		code.unindent(t);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitTrue(syntaxtree.True)
	 */
	@Override
	public Object visitTrue(True t){
		code.indent(t);
		
		code.emit(t, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(t, "li $t0, 1");
		code.emit(t, "sw $t0, ($sp)");
		
		code.unindent(t);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitWhile(syntaxtree.While)
	 */
	@Override
	public Object visitWhile(While w){
		code.indent(w);
		
		w.stackHeight = stackHeight;
		code.emit(w, "j while_enter_" + w.uniqueId);
		code.emit(w, "while_top_" + w.uniqueId + ":");
		w.body.accept(this);
		code.emit(w, "while_enter_" + w.uniqueId + ":");
		w.exp.accept(this);
		code.emit(w, "lw $t0, ($sp)");
		code.emit(w, "addu $sp, $sp, 4");
		stackHeight -= 4;
		code.emit(w, "bne $t0, $zero, while_top_" + w.uniqueId);
		code.emit(w, "while_exit_" + w.uniqueId + ":");
		
		code.unindent(w);
		return null;
	}
}