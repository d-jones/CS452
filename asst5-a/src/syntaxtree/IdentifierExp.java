package syntaxtree;
import visitor.Visitor;

public class IdentifierExp extends Exp {
  public String name;
  
  public VarDecl link;
  
  public IdentifierExp(int pos, String aname) {
  	super(pos);
    name=aname;
    link=null;
  }

	public Object accept(Visitor v) {
	    return v.visitIdentifierExp(this);
	  }

  protected String[]stringsInDescr() {
  	return strArrayPlus1(name, super.stringsInDescr());
  }
  public AstNode[] links() {
  	return new AstNode[]{link};
  }
}
