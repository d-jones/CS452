package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class NewArray extends Exp {
  public Exp sizeExp;
  public Type objType;
  
  public NewArray(int pos, Type atype, Exp asizeExp) {
  	super(pos);
  	objType=atype;
    sizeExp=asizeExp; 
  }

	public Object accept(Visitor v) {
	    return v.visitNewArray(this);
	  }

  
	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return objType;
	        case 1: return sizeExp;
	      }
	      throw new TreeDrawException();
	}
}
