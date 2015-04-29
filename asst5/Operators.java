// some simple operator tests
//
// Correct output:
// 90 76 581 11 6 53 -53 
// T F T F T F F F T T F T 
// F T T F T F F F T T T F 

// main class
class Main extends Lib {
    
    // main method
    public void main() {

	// arithmetic operators
	printIntVal(83+7);
	printIntVal(83-7);
	printIntVal(83*7);
	printIntVal(83/7);
	printIntVal(83%7);
	printIntVal(+53);
	printIntVal(-53);
	printStr("\n");

	// comparison operators
	printBoolVal(83>7);
	printBoolVal(83<7);
	printBoolVal(83>=7);
	printBoolVal(83<=7);
	printBoolVal(83!=7);
	printBoolVal(83==7);
	printBoolVal(83>83);
	printBoolVal(83<83);
	printBoolVal(83>=83);
	printBoolVal(83<=83);
	printBoolVal(83!=83);
	printBoolVal(83==83);
	printStr("\n");

	// boolean operators
	printBoolVal(!true);
	printBoolVal(!false);
	printBoolVal(!!true);
	printBoolVal(!!false);
	printBoolVal(true&&true);
	printBoolVal(true&&false);
	printBoolVal(false&&true);
	printBoolVal(false&&false);
	printBoolVal(true||true);
	printBoolVal(true||false);
	printBoolVal(false||true);
	printBoolVal(false||false);
	printStr("\n");
    }

    // prints an int, followed by a space character
    public void printIntVal(int val) {
	printInt(val);
	printStr(" ");
    }

    // prints an boolean, followed by a space character
    public void printBoolVal(boolean val) {
    	if (val) {
    		printStr("T ");
    	}
    	else {
    		printStr("F ");
    	}
    }
}
