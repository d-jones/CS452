package syntaxtree;
import visitor.Visitor;

public abstract class Statement extends AstNode {
  public Statement(int pos) {
  	super(pos);
  }
  
	public Object accept(Visitor v) {
	    return v.visitStatement(this);
	  }

}
