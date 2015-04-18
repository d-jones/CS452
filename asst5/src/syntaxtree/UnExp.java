package syntaxtree;

import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public abstract class UnExp extends Exp {
  public Exp exp;
  
  public UnExp(int pos, Exp aexp) {
    super(pos);
    exp=aexp;
  }

	public Object accept(Visitor v) {
	    return v.visitUnExp(this);
	  }

	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return exp;
	      }
	      throw new TreeDrawException();
	}
}
