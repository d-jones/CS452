package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class If extends Statement {
  public Exp exp;
  public Statement trueStmt;
  public Statement falseStmt;

  public If(int pos, Exp aexp, Statement atrueStmt, Statement afalseStmt) {
  	super(pos);
    exp=aexp; trueStmt=atrueStmt; falseStmt=afalseStmt;
  }

	public Object accept(Visitor v) {
	    return v.visitIf(this);
	  }

	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return exp;
	        case 1: return trueStmt;
	        case 2: return falseStmt;
	      }
	      throw new TreeDrawException();
	}
}

