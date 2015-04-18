package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class ArrayLookup extends Exp {
  public Exp arrExp;
  public Exp idxExp;
  
  public ArrayLookup(int pos, Exp aarrExp, Exp aidxExp) {
  	super(pos);
    arrExp=aarrExp; idxExp=aidxExp;
  }

  public Object accept(Visitor v) {
    return v.visitArrayLookup(this);
  }

  public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
    switch (n) {
      case 0: return arrExp;
      case 1: return idxExp;
    }
    throw new TreeDrawException();
  }
  
}
