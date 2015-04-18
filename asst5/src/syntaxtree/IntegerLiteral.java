package syntaxtree;
import visitor.Visitor;

public class IntegerLiteral extends Exp {
	public int val;
	
	public IntegerLiteral(int pos, int aval) {
		super(pos);
		val=aval;
	}
	
	public Object accept(Visitor v) {
		return v.visitIntegerLiteral(this);
	}
	
	protected String[]stringsInDescr() {
		return strArrayPlus1(""+val,super.stringsInDescr());
	}
}
