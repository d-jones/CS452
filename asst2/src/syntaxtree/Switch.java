package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class Switch extends Statement {
  public Exp exp;
  public StatementList stmts;

  public Switch(int pos, Exp aexp, StatementList astmts) {
  	super(pos);
    exp=aexp; stmts = astmts;
  }

	public Object accept(Visitor v) {
	    return v.visitSwitch(this);
	  }

	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return exp;
	        case 1: return stmts;
	      }
	      throw new TreeDrawException();
	}
}

