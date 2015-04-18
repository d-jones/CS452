package syntaxtree;
import visitor.Visitor;

public class MethodDeclVoid extends MethodDecl {

  public MethodDeclVoid(int pos, String as, VarDeclList afl,
                    StatementList asl) {
  	super(pos, as, afl, asl);
  }
 
	public Object accept(Visitor v) {
	    return v.visitMethodDeclVoid(this);
	  }
}
