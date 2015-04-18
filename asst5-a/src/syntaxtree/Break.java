package syntaxtree;
import visitor.Visitor;

public class Break extends Statement {

	public BreakTarget breakLink;

	public Break(int pos) {
		super(pos);
		breakLink = null;
	}

	public Object accept(Visitor v) {
		return v.visitBreak(this);
	}

	//	method to give the elements we have links to
	public AstNode[] links() {
		return new AstNode[]{breakLink};
	}
}
