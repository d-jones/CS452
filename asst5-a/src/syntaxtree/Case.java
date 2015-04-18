package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class Case extends Statement {
  public Exp exp;
  public Switch enclosingSwitch;

  public Case(int pos, Exp aexp) {
  	super(pos);
    exp=aexp;
    enclosingSwitch=null;
  }

	public Object accept(Visitor v) {
	    return v.visitCase(this);
	  }
	
	//	method to give the elements we have links to
	public AstNode[] links() {
		return new AstNode[]{enclosingSwitch};
	}

	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return exp;
	      }
	      throw new TreeDrawException();
	}
}

