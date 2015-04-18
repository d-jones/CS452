package syntaxtree;

import visitor.Visitor;

public class FormalDecl extends VarDecl {
  
  public FormalDecl(int pos, Type atype, String aname) {
  	super(pos, atype, aname);
  }

	public Object accept(Visitor v) {
	    return v.visitFormalDecl(this);
	  }
}
