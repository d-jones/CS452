package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class ExpStatement extends Statement {
  public Exp exp;

  public ExpStatement(int pos, Exp aexp) {
  	super(pos);
    exp = aexp;
  }

	public Object accept(Visitor v) {
	    return v.visitExpStatement(this);
	  }

	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return exp;
	      }
	      throw new TreeDrawException();
	}
}

