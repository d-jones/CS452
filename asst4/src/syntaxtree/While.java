package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class While extends Statement {
  public Exp exp;
  public Statement body;
  
  public int stackHeight;

  public While(int pos, Exp aexp, Statement abody) {
  	super(pos);
    exp=aexp; body=abody;
    stackHeight = Integer.MIN_VALUE;
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
	
	protected String[]stringsInDescr() {
		if (stackHeight == Integer.MIN_VALUE) {
		  	return super.stringsInDescr();
		}
		else {
		  	return strArrayPlus1(super.stringsInDescr(),
		  			"stackHeight="+stackHeight);
		}
	}
}

