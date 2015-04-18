package syntaxtree;
import visitor.Visitor;

public class Super extends Exp {
  public Super(int pos) {
  	super(pos);
  }
	public Object accept(Visitor v) {
	    return v.visitSuper(this);
	  }
}
