package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class NewObject extends Exp {
	
	public IdentifierType objType;
  
  public NewObject(int pos, IdentifierType atype) {
  	super(pos);
    objType=atype;
  }

	public Object accept(Visitor v) {
	    return v.visitNewObject(this);
	}

	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return objType;
	      }
	      throw new TreeDrawException();
	}

}
