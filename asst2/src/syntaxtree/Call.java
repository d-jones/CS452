package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class Call extends Exp {
  public Exp obj;
  public String methName;
  public ExpList parms;
  
  public MethodDecl methodLink;
  
  public Call(int pos, Exp aobj, String amethName, ExpList aparms) {
  	super(pos);
    obj=aobj; methName=amethName; parms=aparms;
    methodLink = null;
  }

	public Object accept(Visitor v) {
	    return v.visitCall(this);
	  }
  
	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return obj;
	        case 1: return parms;
	      }
	      throw new TreeDrawException();
	}
	  protected String[]stringsInDescr() {
	  	return strArrayPlus1(methName,super.stringsInDescr());
	  }
	  
	  public AstNode[] links() {
	  	return new AstNode[]{methodLink};
	  }
}
