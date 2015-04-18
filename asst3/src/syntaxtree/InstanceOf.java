package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class InstanceOf extends Exp {
	  public Exp exp;
	  public Type checkType;
  
  public InstanceOf(int pos, Exp aexp, Type atype) {
  	super(pos);
    exp=aexp;
    checkType=atype;
  }

	public Object accept(Visitor v) {
	    return v.visitInstanceOf(this);
	  }
  
	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return exp;
	        case 1: return checkType;
	      }
	      throw new TreeDrawException();
	}
}
