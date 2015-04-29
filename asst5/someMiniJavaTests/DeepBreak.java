// Tests a deeply nested break statement.
//
// Correct output:
// 26 369

// main class
class Main extends Lib {
    
    // main method: calls 'funnySum' method and prints its value
    public void main() {
	printInt(funnySum(50, 32, 57));
	printStr("\n");
    }
    
    // funnySum method: (possibly) iterates a number of times; when
    // conditions are right, prints the iteration-count, breaks out
    // of the loop. The value is then returned
    public int funnySum(int a, int b, int c) {
	int rtnVal = 227;
	for (int i = 0; ; i++) {
	    int x = a + b + i;
	    if (x > 0) {
		int y = b - c + i;
		if (y > 0) {
		    int z = c - a + i;
		    int zz = c + a + 10*i;
		    if (zz > 0) {
			// if we get here, it's time to return: compute
			// return-value, print iteration count, and break
			// out of loop
			rtnVal = rtnVal + x + y + z;
			printInt(i);
			printStr(" ");
			break;
		    }
		}
	    }
	}
	return rtnVal;
    }
}
