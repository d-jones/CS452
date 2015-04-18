package syntaxtree;
import visitor.Visitor;
import treedisplay.*;

public class Program extends AstNode {
  public ClassDeclList classDecls;
  public Statement mainStatement;

  public Program(int pos, ClassDeclList acl) {
  	super(pos);
  	IdentifierType mainType = new IdentifierType(-1, "Main"); 
  	Exp newExp = new NewObject(-1, mainType);
  	Exp callExp = new Call(-1, newExp, "main", new ExpList());
  	mainStatement = new ExpStatement(-1, callExp);
    classDecls=acl; 
  }

	public Object accept(Visitor v) {
	    return v.visitProgram(this);
	  }
  
  public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
    switch (n) {
    case 0: return classDecls;
    case 1: return mainStatement;
    }
    throw new TreeDrawException();
  }

}
