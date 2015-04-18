package syntaxtree;
import visitor.Visitor;

public class Not extends UnExp {
  
  public Not(int pos, Exp ae) {
    super(pos, ae); 
  }

	public Object accept(Visitor v) {
	    return v.visitNot(this);
	  }
}
