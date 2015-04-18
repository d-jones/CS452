package syntaxtree;
import visitor.Visitor;

public class Break extends Statement {
	
	public While loopLink;

  public Break(int pos) {
  	super(pos);
  	loopLink = null;
  }

	public Object accept(Visitor v) {
	    return v.visitBreak(this);
	  }
	
	//	method to give the elements we have links to
	public AstNode[] links() {
		return new AstNode[]{loopLink};
	}
}
