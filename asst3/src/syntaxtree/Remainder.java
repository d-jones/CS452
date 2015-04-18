package syntaxtree;
import visitor.Visitor;

public class Remainder extends BinExp {
  
  public Remainder(int pos, Exp ae1, Exp ae2) { 
    super(pos, ae1, ae2);
  }

	public Object accept(Visitor v) {
	    return v.visitRemainder(this);
	  }
}
