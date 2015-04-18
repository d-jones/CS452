package syntaxtree;
import visitor.Visitor;

public class Null extends Exp {
  public Null(int pos) {
  	super(pos);
  }
  
	public Object accept(Visitor v) {
	    return v.visitNull(this);
	  }
}
