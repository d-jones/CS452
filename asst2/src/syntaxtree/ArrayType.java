package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class ArrayType extends Type {
	public Type baseType;
	
	public ArrayType(int pos, Type base) {
		super(pos);
		baseType = base;
	}
	
	public Object accept(Visitor v) {
		return v.visitArrayType(this);
	}
	
	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
		switch (n) {
			case 0: return baseType;
		}
		throw new TreeDrawException();
	}
	
	public boolean equals(Object obj) {
		return obj instanceof ArrayType && this.baseType.equals(((ArrayType)obj).baseType);
	}
	
	public int hashCode() {
		return 18623 + 274673*this.baseType.hashCode();
	}
	
	public String toString2() {
		return ""+baseType+"[]";
	}
}
