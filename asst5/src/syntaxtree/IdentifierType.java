package syntaxtree;
import visitor.Visitor;

public class IdentifierType extends Type {
	public String name;
	
	public ClassDecl link;
	
	public IdentifierType(int pos, String aname) {
		super(pos);
		name=aname;
		link = null;
	}
	
	public Object accept(Visitor v) {
		return v.visitIdentifierType(this);
	}
	
	protected String[]stringsInDescr() {
	  	return strArrayPlus1(super.stringsInDescr(),name);
	}
	
	public AstNode[] links() {
		return new AstNode[]{link};
	}
	
	public boolean equals(Object obj) {
		return obj instanceof IdentifierType &&
		this.link != null &&
		this.link == ((IdentifierType)obj).link;
	} 
	
	public int hashCode() {
		if (name == null) {
			return 23977;
		}
		else return 826427*name.hashCode()+83473;
	}

	public String toString2() {
		return name;
	}
}
