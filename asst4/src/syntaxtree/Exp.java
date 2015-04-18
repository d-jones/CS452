package syntaxtree;
import visitor.Visitor;

public abstract class Exp extends AstNode {
	
	public Type type;
	
	public Exp(int pos) {
		super(pos);
		type=null;
	}
	public Object accept(Visitor v) {
		return v.visitExp(this);
	}
	
	protected String[]stringsInDescr() {
		String extra;
		if (type == null) {
			extra = "???";
		}
		else {
			extra = type.toString2();
		}
		return strArrayPlus1(super.stringsInDescr(),extra);
	}
}