package visitor;

import syntaxtree.*;

import java.util.*;

import errorMsg.*;
import java.io.*;
import java.awt.Point;

//the purpose here is to annotate things with their offsets:
// - formal parameters, with respect to the (callee) frame
// - instance variables, with respect to their slot in the object
// - methods, with respect to their slot in the v-table
public class CG1Visitor extends ASTvisitor {
	
	// IO stream to which we will emit code
	CodeStream code;
	
	// v-table offset of next method we encounter
	int currentMethodOffset;
	
	// offset in object of next "object" instance variable we encounter
	int currentObjInstVarOffset;
	
	// offset in object of next "data" instance variable we encounter
	int currentDataInstVarOffset;
	
	// stack-offset of next formal parameter we encounter
	int currentFormalVarOffset;
	
	// stack method tables for current class and all superclasses
	Stack<Vector<String>> superclassMethodTables;
	
	// current method table
	Vector<String> currentMethodTable;
	
	// error-message object
	ErrorMsg errorMsg;
	
	public CG1Visitor(ErrorMsg e, PrintStream out) {
		initInstanceVars(e, out);
	}
	
	private void initInstanceVars(ErrorMsg e, PrintStream out) {
		errorMsg = e;
		currentMethodOffset = 0;
		currentObjInstVarOffset = 0;
		currentDataInstVarOffset = 0;
		code = new CodeStream(out, e);
		superclassMethodTables = new Stack<Vector<String>>();
		superclassMethodTables.addElement(new Vector<String>());
	}
	

}
	
