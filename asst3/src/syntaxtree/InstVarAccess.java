package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class InstVarAccess extends Exp {
	public Exp exp;
	public String varName;
	
	public InstVarDecl varDec;
	
	public InstVarAccess(int pos, Exp aexp, String avarName) {
		super(pos);
		exp=aexp; varName=avarName;
	}
	
	public Object accept(Visitor v) {
		return v.visitInstVarAccess(this);
	}
	
	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
		switch (n) {
			case 0: return exp;
		}
		throw new TreeDrawException();
	}
	
	protected String[]stringsInDescr() {
	  	return strArrayPlus1(varName, super.stringsInDescr());
	}
	
	public AstNode[] links() {
		return new AstNode[]{varDec};
	}
}
