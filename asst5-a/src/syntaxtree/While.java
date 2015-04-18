package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class While extends BreakTarget {
  public Exp exp;
  public Statement body;
  
  public While(int pos, Exp aexp, Statement abody) {
  	super(pos);
    exp=aexp; body=abody;
  }
  
	public Object accept(Visitor v) {
	    return v.visitWhile(this);
	  }

	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return exp;
	        case 1: return body;
	      }
	      throw new TreeDrawException();
	}
}

