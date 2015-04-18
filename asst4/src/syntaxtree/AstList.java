package syntaxtree;

import java.util.List;
import java.util.Vector;
import treedisplay.*;
import visitor.Visitor;

public abstract class AstList<T> extends Vector<T> implements TreeDisplayable {

	public AstList() {
		super();
	}

	public AstList(List<T> lst) {
		this();
		this.addAll(lst);
	}

	public void addElement(T n) {
		super.addElement(n);
	}

	public void addElementAtFront(T n) {
		super.insertElementAt(n, 0);
	}

	public abstract Object accept(Visitor v);

	public TreeDisplayable getDrawTreeSubobj(int n) throws TreeDrawException {
		try {
			return (TreeDisplayable)this.elementAt(n);
		}
		catch (Exception x) {
			throw new TreeDrawException();
		}
	}

	public TreeDisplayable[] getDrawTreeLinks() {
		return null;
	}

	public String shortDescription(Object auxData) {
		return "";
	}

	public String longDescription(Object auxData) {
		return shortDescription(auxData);
	}
	public boolean nodeIsList() {
		return true;
	}

}
