package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public abstract class MethodDecl extends Decl {
  public VarDeclList formals;
  public StatementList stmts;
  
  public MethodDecl superMethod;
  public int thisPtrOffset;
  public int vtableOffset;

  public MethodDecl(int pos, String aname, VarDeclList aformals,
                    StatementList astmts) {
  	super(pos,aname);
    formals=aformals; stmts=astmts;
    superMethod = null;
    vtableOffset = Integer.MIN_VALUE;
  }
 
	public Object accept(Visitor v) {
	    return v.visitMethodDecl(this);
	  }
  
	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return formals;
	        case 1: return stmts;
	      }
	      throw new TreeDrawException();
	}
	
	public AstNode[] links() {
		return new AstNode[]{superMethod};
	}
	
	protected String[]stringsInDescr() {
		if (vtableOffset == Integer.MIN_VALUE) {
		  	return super.stringsInDescr();
		}
		else { 
		  	return strArrayPlus1(super.stringsInDescr(),
		  			"vtableOffset="+vtableOffset);
		}
	}
}
