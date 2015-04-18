package syntaxtree;
import visitor.Visitor;

public class BooleanType extends Type {
	
	public BooleanType(int pos) {
		super(pos);
	}
	
	public Object accept(Visitor v) {
		return v.visitBooleanType(this);
	}
	
	public boolean equals(Object obj) {
		return obj instanceof BooleanType;
	} 
	
	public int hashCode() {
		return 327236434;
	}
	
	public String toString2() {
		return "boolean";
	}
}
