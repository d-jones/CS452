package syntaxtree;
import visitor.Visitor;

public class IntegerType extends Type {
	public IntegerType(int pos) {
		super(pos);
	}
	public Object accept(Visitor v) {
		return v.visitIntegerType(this);
	}
	public boolean equals(Object obj) {
		return obj instanceof IntegerType;
	}
	
	public int hashCode() {
		return 657643445;
	}
	
	public String toString2() {
		return "int";
	}
}
