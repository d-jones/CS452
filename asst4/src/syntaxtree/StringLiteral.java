package syntaxtree;
import visitor.Visitor;

public class StringLiteral extends Exp {
  public String str;
  
  public StringLiteral uniqueCgRep;

  public StringLiteral(int pos, String astr) {
  	super(pos);
    str = astr;
    uniqueCgRep = null;
  }

	public Object accept(Visitor v) {
	    return v.visitStringLiteral(this);
	  }

  protected String[]stringsInDescr() {
  	return strArrayPlus1(str, super.stringsInDescr());
  }
  
  public AstNode[] links() {
  	return new AstNode[]{uniqueCgRep};
  }
}
