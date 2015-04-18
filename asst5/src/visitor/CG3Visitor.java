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
	 * @see visitor.InhVisitor#visitIntegerLiteral(syntaxtree.IntegerLiteral)
	 */
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
	 * @see visitor.InhVisitor#visitIdentifierExp(syntaxtree.IdentifierExp)
	 */
	@Override
	public Object visitIdentifierExp(IdentifierExp iExp){
		//the variable is a LocalVarDecl
		if(iExp.link instanceof LocalVarDecl){
			int sDepth = stackHeight + iExp.link.offset;
			code.emit(iExp, "lw $t0, " + sDepth + "($sp)");
			if(iExp.link.type instanceof IntegerType){
				code.emit(iExp, "subu $sp, $sp, 8");
				stackHeight += 8;
				code.emit(iExp,  "sw $s5, 4($sp)");
				code.emit(iExp,  "sw $t0, ($sp)");
			}
			else{
				code.emit(iExp, "subu $sp, $sp, 4");
				stackHeight += 4;
				code.emit(iExp,  "sw $t0, ($sp)");
			}
		}
		
		return null;
	}
	

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
	 * @see visitor.InhVisitor#visitStringLiteral(syntaxtree.StringLiteral)
	 */
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitNewObject(syntaxtree.NewObject)
	 */
	@Override
	public Object visitNewObject(NewObject no){
		code.emit(no, "subu $sp, $sp, 4");
		stackHeight += 4;
		code.emit(no, "sw $zero, ($sp)");
		
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
}


	
