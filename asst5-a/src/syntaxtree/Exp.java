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
		if (type == null) {
			return super.stringsInDescr();
		}
		else {
			return strArrayPlus1(super.stringsInDescr(),""+type);
		}
	}
}