package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class Assign extends Statement {
  public Exp lhs;
  public Exp rhs;

  public Assign(int pos, Exp alhs, Exp arhs) {
  	super(pos);
    lhs = alhs;
    rhs = arhs;
  }

  public Object accept(Visitor v) {
    return v.visitAssign(this);
  }

  public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
    switch (n) {
      case 0: return lhs;
      case 1: return rhs;
    }
    throw new TreeDrawException();
  }
}

