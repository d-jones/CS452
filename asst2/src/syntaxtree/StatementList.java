package syntaxtree;

import java.util.List;

import visitor.Visitor;

public class StatementList extends AstList<Statement> {
	
	public StatementList() {
		super();
	}

	public StatementList(List<Statement> lst) {
		super(lst);
	}
	
	public Object accept(Visitor v) {
		return v.visitStatementList(this);
	}
}
