package syntaxtree;
import visitor.Visitor;

public class True extends Exp {
  public True(int pos) {
  	super(pos);
  }
	public Object accept(Visitor v) {
	    return v.visitTrue(this);
	  }
}
