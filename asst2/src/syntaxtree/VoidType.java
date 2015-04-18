package syntaxtree;
import visitor.Visitor;

public class VoidType extends Type {
	public VoidType(int pos) {
		super(pos);
	}
	public Object accept(Visitor v) {
		return v.visitVoidType(this);
	}
	public boolean equals(Object obj) {
		return obj instanceof VoidType;
	}
	public int hashCode() {
		return 23672;
	}
	public String toString2() {
		return "void";
	}
}
