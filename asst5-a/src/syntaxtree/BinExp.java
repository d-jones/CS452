package syntaxtree;

import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public abstract class BinExp extends Exp {
	public Exp left;
	public Exp right;
	
	public BinExp(int pos, Exp aleft, Exp aright) { 
		super(pos);
	    left=aleft; right = aright;
	}
	
	public Object accept(Visitor v) {
	    return v.visitBinExp(this);
	}
	
	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
	    switch (n) {
	        case 0: return left;
	        case 1: return right;
	      }
	      throw new TreeDrawException();
	}
}