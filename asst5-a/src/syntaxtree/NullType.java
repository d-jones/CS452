package syntaxtree;
import visitor.Visitor;

public class NullType extends Type {
	public NullType(int pos) {
		super(pos);
	}
	public Object accept(Visitor v) {
		return v.visitNullType(this);
	}
	
	public boolean equals(Object obj) {
		return obj instanceof NullType;
	}
	
	public int hashCode() {
		return 7326834;
	}
	
	public String toString2() {
		return "(null type)";
	}
}
