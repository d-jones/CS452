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
		a.left.accept(this);
		code.emit(a, "lw $t0, ($sp)");
		code.emit(a, "beq $t0, $zero, skip_" + a.uniqueId);
		code.emit(a, "addu $sp, $sp, 4");
		stackHeight -= 4;
		a.right.accept(this);
		code.emit(a,  "skip_" + a.uniqueId + ":");
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitArrayLength(syntaxtree.ArrayLength)
	 */
	@Override
	public Object visitArrayLength(ArrayLength al){
		al.exp.accept(this);
		code.emit(al, "lw $t0, ($sp)");
		code.emit(al, "beq $t0, $zero, nullPtrException");
		code.emit(al, "lw $t0, -4($t0)"); //-4($t0)...
		code.emit(al, "sw $s5, ($sp)");
		code.emit(al, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(al, "sw $t0, ($sp)");
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitArrayLookup(syntaxtree.ArrayLookup)
	 */
	@Override
	public Object visitArrayLookup(ArrayLookup a){
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
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitAssign(syntaxtree.Assign)
	 */
	@Override
	public Object visitAssign(Assign a){
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
		
		return null;
	}
	
	
	/*
	 * 
	 */
	@Override
	public Object visitBlock(Block b){
		int sHeight = stackHeight;
		b.stmts.accept(this);
		if(sHeight - stackHeight != 0){
			int DDD = stackHeight - sHeight;
			code.emit(b, "addu $sp, " + DDD);
		}
		stackHeight = sHeight;
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitBreak(syntaxtree.Break)
	 */
	@Override
	public Object visitBreak(Break b){
		int NNN = stackHeight - b.breakLink.stackHeight;
		if(NNN != 0){
			code.emit(b, "addu $sp, " + NNN);
		}
		code.emit(b, "j while_exit_" + b.breakLink.uniqueId);
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitThis(syntaxtree.This)
	 */
	@Override
	public Object visitCall(Call c){
		int sHeight = stackHeight;
		c.obj.accept(this);
		//c.parms.accept(this); 
		for(Exp e : c.parms){
			e.accept(this);
		}
		if(c.methodLink.pos < 0){
			code.emit(c, "jal " + c.methName); //c.methodLink.name?
		}
		else if(c.methodLink.pos > 0){
			code.emit(c, "jal fcn_" + c.methodLink.uniqueId + "_" + c.methName);
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
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitDivide(syntaxtree.Divide)
	 */
	@Override
	public Object visitDivide(Divide d){
		d.left.accept(this);
		d.right.accept(this);
		code.emit(d, "jal divide");
		stackHeight -= 8;
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitEquals(syntaxtree.Equals)
	 */
	@Override
	public Object visitEquals(Equals eq){
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
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitExpStatement(syntaxtree.ExpStatement)
	 */
	@Override
	public Object visitExpStatement(ExpStatement exp){
		exp.exp.accept(this);
		if(exp.exp.type instanceof IntegerType){
			code.emit(exp, "addu $sp, $sp, 8");
			stackHeight -= 8;
		}
		else if(!(exp.exp.type instanceof VoidType)){
			code.emit(exp, "addu $sp, $sp, 4");
			stackHeight -= 4;
		}
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitFalse(syntaxtree.False)
	 */
	@Override
	public Object visitFalse(False f){
		code.emit(f, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(f, "sw $zero, ($sp)");
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitGreaterThan(syntaxtree.GreaterThan)
	 */
	@Override
	public Object visitGreaterThan(GreaterThan gt){
		gt.left.accept(this);
		gt.right.accept(this);
		code.emit(gt, "lw $t0, ($sp)");
		code.emit(gt, "lw $t1, 8($sp)");
		code.emit(gt, "sgt $t0, $t1, $t0");
		code.emit(gt, "addu $sp, $sp, 12");
		stackHeight -= 12;
		code.emit(gt, "sw $t0, ($sp)");
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitIdentifierExp(syntaxtree.IdentifierExp)
	 */
	@Override
	public Object visitIdentifierExp(IdentifierExp iExp){
		//the variable is a LocalVarDecl
		if(iExp.link instanceof LocalVarDecl){
			int sDepth = stackHeight + iExp.link.offset;
			code.emit(iExp, "lw $t0, " + sDepth + "($sp)");
		}
		//the variable is an InstVarDecl
		else{
			int NNN = iExp.link.offset;
			code.emit(iExp, "lw $t0, " + NNN + "($s2)");
		}
		
		//the variable is an integer
		if(iExp.link.type instanceof IntegerType){
			code.emit(iExp, "subu $sp, $sp, 8");
			stackHeight += 8;
			code.emit(iExp,  "sw $s5, 4($sp)");
			code.emit(iExp,  "sw $t0, ($sp)");
		}
		else if(!(iExp.link.type instanceof VoidType)){
			code.emit(iExp, "subu $sp, $sp, 4");
			stackHeight += 4;
			code.emit(iExp,  "sw $t0, ($sp)");
		}
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitIf(syntaxtree.If)
	 */
	@Override
	public Object visitIf(If i){
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
		
		return null;
	}
	
/*	
	
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitInstanceOf(syntaxtree.InstanceOf)
	 
	@Override
	public Object visitInstanceOf(InstanceOf in){
		in.exp.accept(this);
		code.emit(in, "la $t0, CLASS_" + in.checkType.toString2());
		code.emit(in, "la $t1, CLASS_END_" + in.checkType.toString2());
		code.emit(in, "jal instanceOf");
		
		return null;
	}*/
	

	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitInstVarAccess(syntaxtree.InstVarAccess)
	 */
	@Override
	public Object visitInstVarAccess(InstVarAccess iva){
		iva.exp.accept(this);
		int NNN = iva.varDec.offset;
		code.emit(iva, "lw $t0, ($sp)");
		code.emit(iva, "beq $t0, $zero, nullPtrException");
		code.emit(iva, "lw $t0, " + NNN + "($t0)"); //NNN($sp)?????
		
		if(iva.varDec.type instanceof IntegerType){
			code.emit(iva, "subu $sp, $sp, 4"); //is this supposed to be 8???
			stackHeight += 4; //Is this the correct placement???????????
			code.emit(iva, "sw $s5, 4($sp)");
			code.emit(iva, "$t0, ($sp)");
		}
		else if(!(iva.varDec.type instanceof VoidType)){
			code.emit(iva, "sw $t0, ($sp)");
		}
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitIntegerLiteral(syntaxtree.IntegerLiteral)
	 */
	@Override
	public Object visitIntegerLiteral(IntegerLiteral intLit){
		code.emit(intLit, "subu $sp, $sp, 8");
		stackHeight += 8;
		code.emit(intLit,  "sw $s5, 4($sp)");
		code.emit(intLit, "li $t0, " + intLit.val);
		code.emit(intLit, "sw $t0, ($sp)");
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitLessThan(syntaxtree.LessThan)
	 */
	@Override
	public Object visitLessThan(LessThan lt){
		lt.left.accept(this);
		lt.right.accept(this);
		code.emit(lt, "lw $t0, ($sp)");
		code.emit(lt, "lw $t1, 8($sp)");
		code.emit(lt, "slt $t0, $t1, $t0");
		code.emit(lt, "addu $sp, $sp, 12");
		stackHeight -= 12;
		code.emit(lt, "sw $t0, ($sp)");
		
		return null;
	}
	

	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitLocalVarDecl(syntaxtree.LocalVarDecl)
	 */
	@Override
	public Object visitLocalVarDecl(LocalVarDecl lVar){
		lVar.initExp.accept(this);
		if(lVar.type instanceof IntegerType){
			lVar.offset = -stackHeight;
		}
		else{
			lVar.offset = -stackHeight;
		}
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitMethodDeclVoid(syntaxtree.MethodDeclVoid)
	 */
	@Override
	public Object visitMethodDeclVoid(MethodDeclVoid meth){
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
		int KKK = NNN;														//saved this-pointer?
		code.emit(meth, "lw $ra, " + JJJ + "($sp)");
		code.emit(meth, "lw $s2, " + KKK + "($sp)");
		int MMM = stackHeight + 4 + 4;
		code.emit(meth, "addu $sp, $sp, " + MMM);
		code.emit(meth, "jr $ra");
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitMinus(syntaxtree.Minus)
	 */
	@Override
	public Object visitMinus(Minus minus){
		minus.left.accept(this);
		minus.right.accept(this);
		code.emit(minus, "lw $t0, ($sp)");
		code.emit(minus, "lw $t1, 8($sp)");
		code.emit(minus, "subu $t0, $t1, $t0");
		code.emit(minus, "addu $sp, $sp, 8");
		stackHeight -= 8;
		code.emit(minus, "sw $t0, ($sp)");
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitNewArray(syntaxtree.NewArray)
	 */
	@Override
	public Object visitNewArray(NewArray arr){
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
		
		return null;
	}
	
	/*
	 *  (non-Javadoc)
	 * @see visitor.ASTvisitor#visitNewObject(syntaxtree.NewObject)
	 */
	@Override
	public Object visitNewObject(NewObject no){
/*		int NNN = no.objType.link.numObjInstVars;
		int MMM = no.objType.link.numDataInstVars + 1;
		code.emit(no, "li $s6, " + MMM);
		code.emit(no, "li $s7, " + NNN);
		code.emit(no, "jal newObject");
		stackHeight += 4;
		code.emit(no, "la $t0, CLASS_" + no.objType.name);
		code.emit(no, "sw $t0, -12($s7)");*/
		
		
		code.emit(no, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(no, "sw $zero, ($sp)");
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitNot(syntaxtree.Not)
	 */
	@Override
	public Object visitNot(Not n){
		n.exp.accept(this);
		code.emit(n, "lw $t0, ($sp)");
		code.emit(n, "xor $t0, $t0, 1");
		code.emit(n, "sw $t0, ($sp)");
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitOr(syntaxtree.Or)
	 */
	@Override
	public Object visitOr(Or o){
		o.left.accept(this);
		code.emit(o, "lw $t0, ($sp)");
		code.emit(o, "bne $t0, $zero, skip_" + o.uniqueId);
		code.emit(o, "addu $sp, $sp, 4");
		stackHeight -= 4;
		o.right.accept(this);
		code.emit(o, "skip_" + o.uniqueId + ":");
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitPlus(syntaxtree.Plus)
	 */
	@Override
	public Object visitPlus(Plus plus){
		plus.left.accept(this);
		plus.right.accept(this);
		code.emit(plus, "lw $t0, ($sp)");
		code.emit(plus, "lw $t1, 8($sp)");
		code.emit(plus, "addu $t0, $t0, $t1");
		code.emit(plus, "addu $sp, $sp, 8");
		stackHeight -= 8;
		code.emit(plus, "sw $t0, ($sp)");
		
		return null;
	}
	

	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitProgram(syntaxtree.Program)
	 */
	@Override
	public Object visitProgram(Program prog){
		//prog.mainStatement.accept(this);
		code.emit(prog, "CLASS_Object:");
		code.emit(prog, "CLASS_String:");
		
		code.emit(prog,  ".text");
		code.emit(prog, ".global main");
		code.emit(prog, "main:");
		code.emit(prog, "jal vm_init");
		this.stackHeight = 0;
		
		prog.mainStatement.accept(this);
		
		code.emit(prog, "li $v0, 10");
		code.emit(prog,  "syscall");
		prog.classDecls.accept(this);
		code.flush();
		
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitRemainder(syntaxtree.Remainder)
	 */
	@Override
	public Object visitRemainder(Remainder r){
		r.left.accept(this);
		r.right.accept(this);
		code.emit(r, "jal remainder");
		stackHeight -= 8;
		
		return null;
	}

	
	@Override
	public Object visitStringLiteral(StringLiteral s){
		code.emit(s, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(s, "la $t0, strLit_" + s.uniqueCgRep.uniqueId);
		code.emit(s, "sw $t0, ($sp)");
		
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
		code.emit(s, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(s, "sw $s2, ($sp)");
		
		return null;
	}

	@Override
	public Object visitThis(This t){
		code.emit(t, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(t, "sw $s2, ($sp)");
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitTimes(syntaxtree.Times)
	 */
	@Override
	public Object visitTimes(Times t){
		t.left.accept(this);
		t.right.accept(this);
		code.emit(t, "lw $t0, ($sp)");
		code.emit(t, "lw $t1, 8($sp)");
		code.emit(t, "mult $t0, $t1");
		code.emit(t, "mflo $t0");
		code.emit(t, "addu $sp, $sp, 8");
		stackHeight -= 8;
		code.emit(t, "sw $t0, ($sp)");
		
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitTrue(syntaxtree.True)
	 */
	@Override
	public Object visitTrue(True t){
		code.emit(t, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(t, "li $t0, 1");
		code.emit(t, "sw $t0, ($sp)");
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitWhile(syntaxtree.While)
	 */
	@Override
	public Object visitWhile(While w){
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
		
		return null;
	}
}