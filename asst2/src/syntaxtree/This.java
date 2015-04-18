package syntaxtree;
import visitor.Visitor;

public class This extends Exp {
  public This(int pos) {
  	super(pos);
  }
	public Object accept(Visitor v) {
	    return v.visitThis(this);
	  }
}
