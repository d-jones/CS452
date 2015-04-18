package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class Case extends Statement {
  public Exp exp;

  public Case(int pos, Exp aexp) {
  	super(pos);
    exp=aexp;
  }

	public Object accept(Visitor v) {
	    return v.visitCase(this);
	  }

	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return exp;
	      }
	      throw new TreeDrawException();
	}
}

