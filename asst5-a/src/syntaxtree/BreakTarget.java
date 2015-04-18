package syntaxtree;

public abstract class BreakTarget extends Statement {
	public BreakTarget(int pos) {
	  	super(pos);
	    stackHeight = Integer.MIN_VALUE;
	  }
	
	  public int stackHeight;
	  
		protected String[]stringsInDescr() {
			if (stackHeight == Integer.MIN_VALUE) {
			  	return super.stringsInDescr();
			}
			else {
			  	return strArrayPlus1(super.stringsInDescr(),
			  			"stackHeight="+stackHeight);
			}
		}
}
