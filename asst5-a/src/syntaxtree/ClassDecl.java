package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;
import java.util.*;

public class ClassDecl extends Decl {
	public String superName;
	public DeclList decls;
	
	public ClassDecl superLink;
	public ClassDeclList subclasses;
	public Hashtable<String,InstVarDecl> instVarTable;
	public Hashtable<String,MethodDecl> methodTable;
	
	// total number of instance variables of the respective
	// kinds, including those inherited from superclasses
	public int numDataInstVars;
	public int numObjInstVars;
	
	public ClassDecl(int pos, String aname, String asuperName, 
            DeclList aDeclList) {
		super(pos, aname);
	    superName=asuperName; decls = aDeclList;
	    superLink = null;
	    subclasses = new ClassDeclList();
	    instVarTable = new Hashtable<String,InstVarDecl>();
	    methodTable = new Hashtable<String,MethodDecl>();
	}

	public Object accept(Visitor v) {
	    return v.visitClassDecl(this);
	}
	  
		public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
		    switch (n) {
		        case 0: return decls;
		      }
		      throw new TreeDrawException();
		}

		  protected String[]stringsInDescr() {
		  	return strArrayPlus1(super.stringsInDescr(), superName);
		  }
		  
		  public AstNode[] links() {
		  	return new AstNode[]{superLink};
		  }
}
