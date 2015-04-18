package visitor;

import syntaxtree.*;
import java.util.*;
import errorMsg.*;

// the purpose of this class is to
// - link each ClassDecl to the ClassDecl for its superclass (via
//   its 'superLink'
// - link each ClassDecl to each of its subclasses (via the
//   'subclasses' instance variable
// - ensure that there are no cycles in the inheritance hierarchy
// - ensure that no class has 'String' or 'RunMain' as its superclass
public class Sem2Visitor extends ASTvisitor {
	
	Hashtable<String,ClassDecl> globalSymTab;
	ErrorMsg errorMsg;
	
	public Sem2Visitor(Hashtable<String,ClassDecl> globalSymTb, ErrorMsg e) {
		errorMsg = e;
		initInstanceVars(globalSymTb);
	}

	private void initInstanceVars(Hashtable<String,ClassDecl> globalTab) {
		globalSymTab = globalTab;
	}
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitProgram(syntaxtree.Program)
	 */
	@Override
	public Object visitProgram(Program prog){
		super.visitProgram(prog);
		ClassDeclList classes = prog.classDecls;
		for(ClassDecl c: classes){
			if(c.superName.equals("String")){
				errorMsg.error(c.pos, "String cannot be a superclass");
			}
			else if(c.superName.equals("RunMain")){
				errorMsg.error(c.pos, "RunMain cannot be a superclass");
			}
			else if(isCycle(c, classes.size())){
				errorMsg.error(c.pos, "Cyclical class definition: " + c.name);
			}
		}
		
		return null;
	}
	
	
	/*
	 * isCycle()
	 * 
	 * Returns true if the class definition is cyclical
	 */
	private boolean isCycle(ClassDecl c, int numClasses){
		boolean success = cycleRecurse(c, c.superLink, numClasses);
		
		return success;
	}
	
	
	/*
	 * cycleRecurse()
	 * 
	 * Recursively traverses the super classes
	 */
	private boolean cycleRecurse(ClassDecl c, ClassDecl superClass, int numClasses){
		if(superClass == null){
			return false;
		}
		//we've iterated more times than we have classes
		else if(numClasses < 0){
			return true;
		}
		else if(superClass.equals(c)){
			return true;
		}
		return cycleRecurse(superClass, superClass.superLink, numClasses - 1);
	}
	
	
	/**
	 * spellCheck()
	 * 
	 * Description: Attempts to check for possible spelling errors in undefined names.
	 * @param c
	 * @return
	 */
	private int spellCheck(ClassDecl c){
		Collection<ClassDecl> classes = globalSymTab.values();
		for(ClassDecl classTest : classes){
			/* if one of the strings is more than one character longer than the other,
			 * we on't even bother testing them, since they can't be "off by one", and 
			   a "case" difference won't matter.*/
			int difference = Math.abs(c.superName.length() - classTest.name.length());
			if(difference <= 1){
				if(!c.superName.equals(classTest.name)){
					//the superclass names only differ by case
					if(testCase(c, classTest) == 0){
						errorMsg.error(c.pos, "Error: possible spelling mistake. Did you mean \"" + c.superName + "\", or \"" + classTest.name + "\"?");
						return 0;
					}
					else{
						char[] class1Name = c.superName.toLowerCase().toCharArray();
						char[] class2Name = classTest.name.toLowerCase().toCharArray();
						//the (lowercase) superclass names are only off by one character.
						if(testOffByOne(class1Name, class2Name, difference) == 0){
							errorMsg.error(c.pos, "Error: possible spelling mistake. Did you mean \"" + c.superName + "\", or \"" + classTest.name + "\"?");
							return 0;
						}
					}
				}
			}
		}
		//we didn't find any possible spelling errors
		return -1;
	}
	
	
	/**
	 * testOffByOne()
	 * 
	 * Description: Tests if the (lowercase) class names are only of by one character.
	 * @param class1Name
	 * @param class2Name
	 * @return
	 */
	private int testOffByOne(char[] class1Name, char[] class2Name, int difference){
		int numCharsDiff = 0;
		if(class1Name.length > class2Name.length){
			numCharsDiff = getNumCharsDiff(class2Name, class1Name, difference);
		}
		else if(class2Name.length > class1Name.length){
			numCharsDiff = getNumCharsDiff(class1Name, class2Name, difference);
		}
		else{
			numCharsDiff = getNumCharsDiff(class2Name, class1Name, difference);
		}
		
		if(numCharsDiff == 1){
			return 0;
		}
		return -1;
	}
	
	
	/**
	 * getNumCharsDiff()
	 * 
	 * Description: Gets the number of characters in the class names that are different.
	 * @param class1Name -- The smaller(if applicable) class
	 * @param class2Name
	 * @return
	 */
	private int getNumCharsDiff(char[] class1Name, char[] class2Name, int difference){
		int numCharsDiff = 0;
		for(int i = 0; i < class1Name.length; ++i){
			if(numCharsDiff == 0){
				if(class1Name[i] == class2Name[i]){
				}
				else{
					++numCharsDiff;
				}
			}
			else{
				if(class1Name[i-1] == class2Name[i]){
				}
				else{
					++numCharsDiff;
				}
			}
		}
		
		if(numCharsDiff == 0 && difference == 1){
			return ++numCharsDiff;
		}
		return numCharsDiff;
	}
	
	
	/**
	 * testCase()
	 * 
	 * Description: Tests if the two class names only differ by case.
	 * @param class1
	 * @param class2
	 * @return
	 */
	private int testCase(ClassDecl class1, ClassDecl class2){
		if(class1.superName.toLowerCase().equals(class2.name.toLowerCase())){
			return 0;
		}
		return -1;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see visitor.ASTvisitor#visitClassDecl(syntaxtree.ClassDecl)
	 */
	@Override
	public Object visitClassDecl(ClassDecl n){
		if(!globalSymTab.containsKey(n.superName)){
			//check for spelling errors
			if(spellCheck(n) != 0){
				errorMsg.error(n.pos, "Undefined class name: " + n.name);
			}
		}
		else{
			n.superLink = globalSymTab.get(n.superName);
			n.superLink.subclasses.addElement(n);
		}
		return null;
	}
	
}

	
