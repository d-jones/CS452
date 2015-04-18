package syntaxtree;
import visitor.Visitor;

public class InstVarDecl extends VarDecl {
  
  public InstVarDecl(int pos, Type atype, String aname) {
  	super(pos, atype, aname);
  }

	public Object accept(Visitor v) {
	    return v.visitInstVarDecl(this);
	  }
}
