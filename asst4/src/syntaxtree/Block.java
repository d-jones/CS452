package syntaxtree;
import treedisplay.TreeDisplayable;
import treedisplay.TreeDrawException;
import visitor.Visitor;

public class Block extends Statement {
	public StatementList stmts;
	
	public Block(int pos, StatementList astmts) {
		super(pos);
		stmts = astmts;
	}
	
	public Object accept(Visitor v) {
		return v.visitBlock(this);
	}
	
	
	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
		switch (n) {
			case 0: return stmts;
		}
		throw new TreeDrawException();
	}
	
}

