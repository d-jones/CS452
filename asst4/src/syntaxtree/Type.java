package syntaxtree;
import visitor.Visitor;

public abstract class Type extends AstNode {
	public Type(int pos) {
		super(pos);
	}
	public Object accept(Visitor v) {
		return v.visitType(this);
	}
	public String toString2() {
		return "(unknown type)";
	}
}
