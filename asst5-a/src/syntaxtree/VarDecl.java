package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public abstract class VarDecl extends Decl {
	public Type type;
	
	public int offset;
	
	public VarDecl(int pos, Type atype, String aname) {
		super(pos, aname);
		type=atype;
		offset = Integer.MIN_VALUE;
	}
	
	public Object accept(Visitor v) {
		return v.visitVarDecl(this);
	}
	
	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
		switch (n) {
			case 0: return type;
		}
		throw new TreeDrawException();
	}
	
	protected String[]stringsInDescr() {
		if (offset == Integer.MIN_VALUE) {
		  	return super.stringsInDescr();
		}
		else {
		  	return strArrayPlus1(super.stringsInDescr(),
		  			"offset="+offset);
		}
	}
}
