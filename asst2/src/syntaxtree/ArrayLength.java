package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class ArrayLength extends UnExp {
  
  public ArrayLength(int pos, Exp arrExp) {
  	super(pos, arrExp);
  }

  public Object accept(Visitor v) {
    return v.visitArrayLength(this);
  }

}
