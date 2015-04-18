/*
 * Created on Jun 18, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package syntaxtree;

import visitor.Visitor;

/**
 * @author faculty
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class GreaterThan extends BinExp {
	public GreaterThan(int pos, Exp ae1, Exp ae2) { 
	    super(pos, ae1, ae2);
	  }

	public Object accept(Visitor v) {
	    return v.visitGreaterThan(this);
	  }

}