package syntaxtree;
import visitor.Visitor;

public abstract class Decl extends Statement {
  public String name;
  
  public Decl(int pos, String aname) {
  	super(pos);
    name=aname;
  }

	public Object accept(Visitor v) {
	    return v.visitDecl(this);
	  }

	  protected String[]stringsInDescr() {
	  	return strArrayPlus1(super.stringsInDescr(),name);
	  }
}
