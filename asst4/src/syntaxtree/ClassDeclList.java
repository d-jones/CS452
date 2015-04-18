package syntaxtree;

import visitor.Visitor;
import java.util.List;

public class ClassDeclList extends AstList<ClassDecl> {
	
	public ClassDeclList() {
		super();
	}
	
	public ClassDeclList(List<ClassDecl> lst) {
		super(lst);
	}
	
	public Object accept(Visitor v) {
		return v.visitClassDeclList(this);
	}
	
}
