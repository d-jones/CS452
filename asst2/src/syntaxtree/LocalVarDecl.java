package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class LocalVarDecl extends VarDecl {
  public Exp initExp;
 
  public LocalVarDecl(int pos, Type at, String as, Exp initX) {
    super(pos, at, as);
    initExp = initX;
  }

	public Object accept(Visitor v) {
	    return v.visitLocalVarDecl(this);
	  }

	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return type;
	        case 1: return initExp;
	      }
	      throw new TreeDrawException();
	}
}
