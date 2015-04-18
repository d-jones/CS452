package syntaxtree;

import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class MethodDeclNonVoid extends MethodDecl {
  public Type rtnType;
  public Exp rtnExp;

  public MethodDeclNonVoid(int pos, Type at, String as, VarDeclList afl,
                    StatementList asl, Exp ae) {
  	super(pos, as, afl, asl);
    rtnType=at; rtnExp=ae;
  }
 
	public Object accept(Visitor v) {
	    return v.visitMethodDeclNonVoid(this);
	  }
  
	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return rtnType;
	        case 1: return formals;
	        case 2: return stmts;
	        case 3: return rtnExp;
	      }
	      throw new TreeDrawException();
	}
}
