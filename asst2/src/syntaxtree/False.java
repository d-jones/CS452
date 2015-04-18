package syntaxtree;
import visitor.Visitor;

public class False extends Exp {
  public False(int pos) {
  	super(pos);
  }
	public Object accept(Visitor v) {
	    return v.visitFalse(this);
	  }
}
