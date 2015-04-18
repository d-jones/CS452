package visitor;

import syntaxtree.*;
import java.util.*;
import errorMsg.*;
// The purpose of the Sem1Visitor class is to:
// - enter each class declaration into the global symbol table)
//   - duplicate class names are detected
// - enter each method declaration into the method symbol table
//   for its class
//   - duplicate method names for a class are detected
// - enter each instance variable declaration into the respective
//   instance-variable symbol table for its class
//   - duplicate instance variable names for a class are detected
// - all of the above are also done for the predefined classes
public class Sem1Visitor extends ASTvisitor {
	
	public static final boolean doStringMethods = true;
	
	Hashtable<String,ClassDecl> globalSymTab;
	ClassDecl currentClass;
	protected ErrorMsg errorMsg;
	
	public Sem1Visitor(ErrorMsg e) {
		errorMsg = e;
		initInstanceVars();
		initGlobalSymTab();
	}
	
	/*
	 * The overridden classDecl method
	 * @see visitor.ASTvisitor#visitClassDecl(syntaxtree.ClassDecl)
	 */
	@Override
	public Object visitClassDecl(ClassDecl n){
		if(globalSymTab.containsKey(n.name)){
			errorMsg.error(n.pos, "Duplicate class declaration name: " + n.name);
		}
		else{
			globalSymTab.put(n.name, n); //place declaration in symbol table
		}
		
		currentClass = n;
		
		super.visitClassDecl(n);
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.InhVisitor#visitInstVarDecl(syntaxtree.InstVarDecl)
	 */
	@Override
	public Object visitInstVarDecl(InstVarDecl var){
		if(currentClass.instVarTable.containsKey(var.name)){
			errorMsg.error(var.pos, "Duplicate instance variable declaration name: " + var.name);
		}
		else{
			currentClass.instVarTable.put(var.name, var);
		}
		return null;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitMethodDecl(syntaxtree.MethodDecl)
	 */
	@Override
	public Object visitMethodDecl(MethodDecl method){
		if(currentClass.methodTable.containsKey(method.name)){
			errorMsg.error(method.pos, "Duplicate method declaration name: " + method.name);
		}
		else{
			currentClass.methodTable.put(method.name, method);
		}
		
		return null;
	}
	
	
	public Hashtable<String,ClassDecl> getGlobalSymTab() {
		return globalSymTab;
	}
	
	private void initGlobalSymTab() {
		ClassDecl classObjectDecl = createClass("Object", "");
		ClassDecl classStringDecl = createClass("String", "Object");
		ClassDecl classLibDecl = createClass("Lib", "Object");
		ClassDecl classRunMainDecl = createClass("RunMain", "Object");
		
	    addDummyMethod(classLibDecl, "readLine", "String", new String[]{});
	    addDummyMethod(classLibDecl, "readInt", "int", new String[]{});
	    addDummyMethod(classLibDecl, "readChar", "int", new String[]{});
		addDummyMethod(classLibDecl, "printStr", "void", new String[]{"String"});
		addDummyMethod(classLibDecl, "printBool", "void", new String[]{"boolean"});
		addDummyMethod(classLibDecl, "printInt", "void", new String[]{"int"});
		addDummyMethod(classLibDecl, "intToString", "String",
				new String[]{"int"});
		addDummyMethod(classLibDecl, "intToChar", "String",
				new String[]{"int"});
		addDummyMethod(classStringDecl, "concat", "String",
				new String[]{"String"});
		addDummyMethod(classStringDecl, "substring", "String",
				new String[]{"int","int"});
		addDummyMethod(classStringDecl, "length", "int", new String[]{});
		addDummyMethod(classStringDecl, "charAt", "int",
				new String[]{"int"});
		addDummyMethod(classStringDecl, "compareTo", "int",
				new String[]{"String"});

		this.visitClassDecl(classObjectDecl);
		this.visitClassDecl(classLibDecl);
		this.visitClassDecl(classStringDecl);
		this.visitClassDecl(classRunMainDecl);

		Sem2Visitor s2 = new Sem2Visitor(globalSymTab, errorMsg);
		s2.visit(classLibDecl);
		s2.visit(classStringDecl);
		s2.visit(classRunMainDecl);
		
		Sem3Visitor s3 = new Sem3Visitor(globalSymTab, errorMsg);
		s3.visit(classLibDecl);
		s3.visit(classStringDecl);
		s3.visit(classRunMainDecl);
		
	}
	
	private static ClassDecl createClass(String name, String superName) {
		return new ClassDecl(-1, name, superName, new DeclList());
	}
	private static void addDummyMethod(ClassDecl dec, String methName, String rtnTypeName, String[] parmTypeNames) {
		VarDeclList parmDecls = new VarDeclList();
		for (int i = 0; i < parmTypeNames.length; i++) {
			Type t = convertToType(parmTypeNames[i]);
			String parmName = "parm"+i;
			VarDecl vd = new FormalDecl(-1, t, parmName);
			parmDecls.addElement(vd);
		}
		Type t = convertToType(rtnTypeName);
		StatementList sl = new StatementList(); // dummied up
		sl.addElement(new ExpStatement(dec.pos,
				new StringLiteral(dec.pos, methName)));
		MethodDecl md;
		if (t == null) { // void return-type
			md = new MethodDeclVoid(-1, methName, parmDecls, sl);
		}
		else { // non-void return type
			Exp rtnExpr = new Null(-1);
			md = new MethodDeclNonVoid(-1, t, methName, parmDecls, sl, rtnExpr);
		}
		dec.decls.addElement(md);
	}
	
	private static Type convertToType(String s) {
		if (s.equals("void")) {
			return null;
		}
		else if (s.equals("boolean")) {
			return new BooleanType(-1);
		}
		else if (s.equals("int")) {
			return new IntegerType(-1);
		}
		else {
			return new IdentifierType(-1, s);
		}
	}

	private void initInstanceVars() {
		globalSymTab = new Hashtable<String,ClassDecl>();
		currentClass = null;
	}
	
}

	
