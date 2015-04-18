package parse;
import java.util.ArrayList;
import java.util.List;
import errorMsg.*;
import syntaxtree.*;

public class MJGrammar
		implements wrangLR.runtime.MessageObject, wrangLR.runtime.FilePosObject {
	
	public static final boolean FILTER_GRAMMAR = true;
	
	// constructor
	public MJGrammar(ErrorMsg em) {
		errorMsg = em;
		topObject = null;
	}
	
	// error message object
	private ErrorMsg errorMsg;
	
	// object returned by the parse
	private Program topObject;

	// method for printing error message
	public void error(int pos, String msg) {
		errorMsg.error(pos, msg);
	}

	// method for printing warning message
	public void warning(int pos, String msg) {
		errorMsg.warning(pos, msg);
	}

	// method for converting file position to line/character
	// position
	public String filePosString(int pos) {
		return errorMsg.lineAndChar(pos);
	}
	
	// method to register a newline
	public void registerNewline(int pos) {
		errorMsg.newline(pos-1);
	}

	// returns the object produced by the parse
	public Program parseResult() {
		return topObject;
	}
	
	//===============================================================
	// start symbol
	//===============================================================

	//: <start> ::= ws* <program> =>
	public void topLevel(Program obj) {
		topObject = obj;
	}
	
	//================================================================
	//top-level program constructs
	//================================================================

	//: <program> ::= # <class decl>+ =>
	public Program createProgram(int pos, List<ClassDecl> vec) {
		return new Program(pos, new ClassDeclList(vec));
	}

	//: <class decl> ::= `class # ID `{ <decl in class>* `} =>
	public ClassDecl createClassDecl(int pos, String name, List<Decl> vec) {
		return new ClassDecl(pos, name, "Object", new DeclList(vec));
	}

	//: <decl in class> ::= <method decl> => pass
	//: <decl in class> ::= <inst var decl> => pass

	//: <method decl> ::= `public `void # ID `( `) `{ <stmt>* `} =>
	public Decl createMethodDeclVoid(int pos, String name, List<Statement> stmts) {
		return new MethodDeclVoid(pos, name, new VarDeclList(new VarDeclList()),
				new StatementList(stmts));
	}
	
	//: <inst var decl> ::= # <type> ID `; =>
	public Decl createInstVarDecl(int pos, Type t, String s){
		return new InstVarDecl(pos, t, s);
	}

	//: <type> ::= # `int =>
	public Type intType(int pos) {
		return new IntegerType(pos);
	}
	//: <type> ::= # `boolean =>
	public Type booleanType(int pos) {
		return new BooleanType(pos);
	}
	//: <type> ::= # ID =>
	public Type identifierType(int pos, String name) {
		return new IdentifierType(pos, name);
	}
	//: <type> ::= # <type> <empty bracket pair> =>
	public Type newArrayType(int pos, Type t, Object dummy) {
		return new ArrayType(pos, t);
	}

	//: <empty bracket pair> ::= `[ `] => null

	//================================================================
	//statement-level program constructs
	//================================================================

	//: <stmt> ::= <assign> `; => pass
	//: <stmt> ::= # `break =>
	public Statement newBreak(int pos){
		return new Break(pos);
	}
	
	//: <stmt> ::= # `{ <stmt>* `} =>
	public Statement newBlock(int pos, List<Statement> sl) {
		return new Block(pos, new StatementList(sl));
	}
	//: <stmt> ::= <local var decl> `; => pass
	

	//: <stmt decl> ::= <local var decl> => pass

	//: <assign> ::= <exp> # `= <exp> =>
	public Statement assign(Exp lhs, int pos, Exp rhs) {
		return new Assign(pos, lhs, rhs);
	}
	//: <assign> ::= ID # `++ =>
	public Statement incrBack(String s, int pos){
		IntegerLiteral num = new IntegerLiteral(pos, s.charAt(0));
		IntegerLiteral one = new IntegerLiteral(pos, 1);
		return new Assign(pos, num, new Plus(pos, num, one));
	}
	//: <assign> ::= # `++ ID =>
	public Statement incrFront(int pos, String s){
		IntegerLiteral num = new IntegerLiteral(pos, s.charAt(0));
		IntegerLiteral one = new IntegerLiteral(pos, 1);
		return new Assign(pos, num, new Plus(pos, num, one));
	}
	//: <assign> ::= ID # `-- =>
	public Statement subBack(String s, int pos){
		IntegerLiteral num = new IntegerLiteral(pos, s.charAt(0));
		IntegerLiteral one = new IntegerLiteral(pos, 1);
		return new Assign(pos, num, new Minus(pos, num, one));
	}
	//: <assign> ::= # `-- ID =>
		public Statement subBack(int pos, String s){
			IntegerLiteral num = new IntegerLiteral(pos, s.charAt(0));
			IntegerLiteral one = new IntegerLiteral(pos, 1);
			return new Assign(pos, num, new Minus(pos, num, one));
		}

	//: <local var decl> ::= <type> # ID `= <exp> =>
	public Statement localVarDecl(Type t, int pos, String name, Exp init) {
		return new LocalVarDecl(pos, t, name, init);
	}

	//================================================================
	//expressions
	//================================================================

	//: <exp> ::= <exp1> => pass
	
	//: <exp1> ::= <exp1> # `|| <exp2> =>
	public Exp newOr(Exp e1, int pos, Exp e2){
		return new Or(pos, e1, e2);
	}
	//: <exp1> ::= <exp2> => pass
	
	//: <exp2> ::= <exp2> # `&& <exp3> =>
	public Exp newAnd(Exp e1, int pos, Exp e2){
		return new And(pos, e1, e2);
	}
	//: <exp2> ::= <exp3> => pass
	
	//: <exp3> ::= <exp3> # `!= <exp4> =>
	public Exp newNotEquals(Exp e1, int pos, Exp e2){
		return new Not(pos, new Equals(pos, e1, e2));
	}
	//: <exp3> ::= <exp3> # `== <exp4> =>
	public Exp newEquals(Exp e1, int pos, Exp e2){
		return new Equals(pos,e1,e2);
	}
	//: <exp3> ::= <exp4> => pass
	
	//: <exp4> ::= <exp4> # `< <exp5> =>
	public Exp newLessThan(Exp e1, int pos, Exp e2){
		return new LessThan(pos, e1, e2);
	}	
	//: <exp4> ::= <exp4> # `> <exp5> =>
	public Exp newGreaterThan(Exp e1, int pos, Exp e2){
		return new GreaterThan(pos, e1, e2);
	}	
	//: <exp4> ::= <exp4> # `<= <exp5> =>
	public Exp newLessThanEquals (Exp e1, int pos, Exp e2){
		return new Not(pos, new GreaterThan(pos, e1, e2));
	}	
	//: <exp4> ::= <exp4> # `>= <exp5> =>
	public Exp newGreaterEquals(Exp e1, int pos, Exp e2){
		return new Not(pos, new LessThan(pos, e1, e2));
	}	
	//: <exp4> ::= <exp4> # `instanceof ID =>
	public Exp newInstanceOf(Exp e1, int pos, String s){
		return new InstanceOf(pos, e1, new IdentifierType(pos, s));
	}
	//: <exp4> ::= <exp5> => pass
	
	//: <exp5> ::= <exp5> # `+ <exp6> =>
	public Exp newPlus(Exp e1, int pos, Exp e2) {
		return new Plus(pos, e1, e2);
	}	
	//: <exp5> ::= <exp5> # `- <exp6> =>
	public Exp newMinus(Exp e1, int pos, Exp e2){
		return new Minus(pos, e1, e1);
	}
	//: <exp5> ::= <exp6> => pass

	//: <exp6> ::= <exp6> # `* <exp7> =>
	public Exp newTimes(Exp e1, int pos, Exp e2) {
		return new Times(pos, e1, e2);
	}	
	//: <exp6> ::= <exp6> # `/ <exp7> =>
	public Exp newDivide(Exp e1, int pos, Exp e2){
		return new Divide(pos, e1, e2);
	}	
	//: <exp6> ::= <exp6> # `% <exp7> =>
	public Exp newRemainder(Exp e1, int pos, Exp e2){
		return new Remainder(pos, e1, e2);
	}
	//: <exp6> ::= <exp7> => pass

	//: <exp7> ::= <cast exp> => pass
	//: <exp7> ::= <unary exp> => pass

	//: <cast exp> ::= # `( <type> `) <cast exp> =>
	public Exp newCast(int pos, Type t, Exp e) {
		return new Cast(pos, t, e);
	}
	//: <cast exp> ::= # `( <type> `) <exp8> => Exp newCast(int, Type, Exp)

	//: <unary exp> ::= # `- <unary exp> =>
	public Exp newUnaryMinus(int pos, Exp e) {
		return new Minus(pos, new IntegerLiteral(pos, 0), e);
	}
	
	//: <unary exp> ::= # `+ <unary exp> =>
	public Exp newUnaryPlus(int pos, Exp e){
		return new Plus(pos, new IntegerLiteral(pos,0), e);
	}
	
	//: <unary exp> ::= # `! <unary exp> =>
	public Exp newUnaryNot(int pos, Exp e){
		return new Not(pos, e);
	}
	//: <unary exp> ::= <exp8> => pass
	
	//: <exp8> ::= # ID  =>
	public Exp newIdentfierExp(int pos, String name) {
		return new IdentifierExp(pos, name);
	}
	//: <exp8> ::= <exp8> !<empty bracket pair> # `[ <exp> `] =>
	public Exp newArrayLookup(Exp e1, int pos, Exp e2) {
		return new ArrayLookup(pos, e1, e2);
	}
	//: <exp8> ::= # INTLIT =>
	public Exp newIntegerLiteral(int pos, int n) {
		return new IntegerLiteral(pos, n);
	}
	//: <exp8> ::= # STRINGLIT =>
	public Exp newStringLiteral(int pos, String s){
		return new StringLiteral(pos, s);
	}
	//: <exp8> ::= # CHARLIT =>
	public Exp newCharLiteral(int pos, int c){
		return new IntegerLiteral(pos, c);
	}
	//: <exp8> ::= # `this =>
	public Exp newThis(int pos){
		return new This(pos);
	}
	//: <exp8> ::= # `true =>
	public Exp newTrue(int pos){
		return new True(pos);
	}
	//: <exp8> ::= # `false =>
	public Exp newFalse(int pos){
		return new False(pos);
	}
	//: <exp8> ::= # <exp8> `. ID =>
	public Exp newInstVarAccess(int pos, Exp e, String s){
		return new InstVarAccess(pos, e, s);
	}
	//: <exp8> ::= # `new <type> `[ <exp> `] <empty bracket pair>* =>
	public Exp newMultiArray(int pos, Type t, Exp e, List<Object> dummy){
		return new NewArray(pos, t, e);
	}
	//: <exp8> ::= # `new ID `( `) =>
	public Exp newObject(int pos, String s){
		return new NewObject(pos, new IdentifierType(pos, s));
	}

	
/*	//: <exp8> ::= # <call exp> => pass
	
	//: <call exp> ::= # ID `( <exp list>? `) =>
	public ExpStatement newMethodCall(int pos, String s, ExpList el){
		return new ExpStatement(pos, new Call(pos, new This(pos), s, el));
	}
	//: <call exp> ::= # `super `. ID `( <exp list>? `) =>
	public ExpStatement newSuperMethodCall(int pos, String s, ExpList el){
		return new ExpStatement(pos, new Call(pos, new Super(pos), s, el));
	}
	//: <call exp> ::= # <exp8> `. ID `( <exp list> `) =>
	public ExpStatement newMethodCall2(int pos, Exp e, String s, ExpList el){
		return new ExpStatement(pos, new Call(pos, e, s, el));
	}
	
	//: <exp list> ::= <exp> `, <exp> =>
	public ExpList newExpList(Exp e1, Exp e2){
		List<Exp> list = new ArrayList<Exp>();
		list.add(e1);
		list.add(e2);
		return new ExpList(list);
	}*/
	

	//================================================================
	// Lexical grammar for filtered language begins here: DO NOT MODIFY
	// ANYTHING BELOW THIS, UNLESS YOU REPLACE IT WITH YOUR ENTIRE
	// LEXICAL GRAMMAR, and set the constant FILTER_GRAMMAR (defined
	// near the top of this file) to false.
	//================================================================

	//: letter ::= {"a".."z" "A".."Z"} => pass
	//: letter128 ::= {225..250 193..218} =>
	public char sub128(char orig) {
		return (char)(orig-128);
	}
	//: digit ::= {"0".."9"} => pass
	//: digit128 ::= {176..185} => char sub128(char)
	//: any ::= {0..127} => pass
	//: any128 ::= {128..255} => char sub128(char)
	//: ws ::= " "
	//: ws ::= {10} registerNewline
	//: registerNewline ::= # => void registerNewline(int)
	//: `boolean ::= "#bo" ws*
	//: `class ::= "#cl" ws*
	//: `extends ::= "#ex" ws*
	//: `void ::= "#vo" ws*
	//: `int ::= "#it" ws*
	//: `while ::= "#wh" ws*
	//: `if ::= '#+' ws*
	//: `else ::= "#el" ws*
	//: `for ::= "#fo" ws*
	//: `break ::= "#br" ws*
	//: `this ::= "#th" ws*
	//: `false ::= '#fa' ws*
	//: `true ::= "#tr" ws*
	//: `super ::= "#su" ws*
	//: `null ::= "#nu" ws*
	//: `return ::= "#re" ws*
	//: `instanceof ::= "#in" ws*
	//: `new ::= "#ne" ws*
	//: `abstract ::= "#ab" ws*
	//: `assert ::= "#as" ws*
	//: `byte ::= "#by" ws*
	//: `case ::= "#ce" ws*
	//: `catch ::= "#ca" ws*
	//: `char ::= "#ch" ws*
	//: `const ::= "#ct" ws*
	//: `continue ::= "#co" ws*
	//: `default ::= "#de" ws*
	//: `do ::= "#-" ws*
	//: `double ::= "#do" ws*
	//: `enum ::= "#en" ws*
	//: `final ::= "#fi" ws*
	//: `finally ::= "#fy" ws*
	//: `float ::= "#fl" ws*
	//: `goto ::= "#go" ws*
	//: `implements ::= "#is" ws*
	//: `import ::= "#im" ws*
	//: `interface ::= "#ie" ws*
	//: `long ::= "#lo" ws*
	//: `native ::= "#na" ws*
	//: `package ::= "#pa" ws*
	//: `private ::= "#pr" ws*
	//: `protected ::= "#pd" ws*
	//: `public ::= "#pu" ws*
	//: `short ::= "#sh" ws*
	//: `static ::= '#sc' ws*
	//: `strictfp ::= "#st" ws*
	//: `switch ::= "#sw" ws*
	//: `synchronized ::= "#sy" ws*
	//: `throw ::= "#tw" ws*
	//: `throws ::= "#ts" ws*
	//: `transient ::= "#tt" ws*
	//: `try ::= "#ty" ws*
	//: `volatile ::= "#ve" ws*
	
	//: `! ::=  "!" ws* => void
	//: `!= ::=  "@!" ws* => void
	//: `% ::= "%" ws* => void
	//: `&& ::= "@&" ws* => void
	//: `* ::= "*" ws* => void
	//: `( ::= "(" ws* => void
	//: `) ::= ")" ws* => void
	//: `{ ::= "{" ws* => void
	//: `} ::= "}" ws* => void
	//: `- ::= "-" ws* => void
	//: `+ ::= "+" ws* => void
	//: `= ::= "=" ws* => void
	//: `== ::= "@=" ws* => void
	//: `[ ::= "[" ws* => void
	//: `] ::= "]" ws* => void
	//: `|| ::= "@|" ws* => void
	//: `< ::= "<" ws* => void
	//: `<= ::= "@<" ws* => void
	//: `, ::= "," ws* => void
	//: `> ::= ">"  !'=' ws* => void
	//: `>= ::= "@>" ws* => void
	//: `: ::= ":" ws* => void
	//: `. ::= "." ws* => void
	//: `; ::= ";" ws* => void
	//: `++ ::= "@+" ws* => void
	//: `-- ::= "@-" ws* => void
	//: `/ ::= "/" ws* => void

	
	//: ID ::= letter128 ws* => text
	//: ID ::= letter idChar* idChar128 ws* => text
	
	//: INTLIT ::= {"1".."9"} digit* digit128 ws* => 
	public int convertToInt(char c, List<Character> mid, char last) {
		return Integer.parseInt(""+c+mid+last);
	}
	//: INTLIT ::= digit128 ws* => 
	public int convertToInt(char c) {
		return Integer.parseInt(""+c);
	}
	//: INTLIT ::= "0" hexDigit* hexDigit128 ws* => 
	public int convert16ToInt(char c, List<Character> mid, char last) {
		return Integer.parseInt(""+c+mid+last, 16);
	}
	//: STRINGLIT ::= '@"' ws* =>
	public String emptyString(char x, char xx) {
		return "";
	}
	//: STRINGLIT ::= '"' any* any128 ws* =>
	public String string(char x, List<Character> mid, char last) {
		return ""+mid+last;
	}
	//: CHARLIT ::= "'" any ws* =>
	public int charVal(char x, char val) {
		return val;
	}
	
	//: idChar ::= letter => pass
	//: idChar ::= digit => pass
	//: idChar ::= "_" => pass
	//: idChar128 ::= letter128 => pass
	//: idChar128 ::= digit128 => pass
	//: idChar128 ::= {223} => 
	public char underscore(char x) {
		return '_';
	}
	//: hexDigit ::= {"0".."9" "a".."z" "A".."Z"} => pass
	//: hexDigit128 ::= {176..185 225..230 193..198} => char sub128(char)

}

