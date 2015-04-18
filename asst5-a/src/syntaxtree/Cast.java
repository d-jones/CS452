package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class Cast extends Exp {
	  public Type castType;
	  public Exp exp;
  
  public Cast(int pos, Type atype, Exp aexp) {
  	super(pos);
    castType=atype;
    exp=aexp;
  }

	public Object accept(Visitor v) {
	    return v.visitCast(this);
	  }
  
	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return castType;
	        case 1: return exp;
	      }
	      throw new TreeDrawException();
	}
}
