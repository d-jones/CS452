package syntaxtree;
import visitor.Visitor;

public class Times extends BinExp {
  
  public Times(int pos, Exp ae1, Exp ae2) {
    super(pos, ae1, ae2);
  }

	public Object accept(Visitor v) {
	    return v.visitTimes(this);
	  }
}
