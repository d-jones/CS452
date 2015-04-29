// sums the elements of a two-dimensional array
//
// correct output:
// 52650

// main class
class Main extends Lib {
    
    // main method
    public void main() {
	
	// create a 20x30 array of int
	int[][] mpyArray = new int[20][];
	for (int i = 0; i < mpyArray.length; i++) {
	    mpyArray[i] = new int[30];
	}
	
	// initialize the array so that it is a multiplication table
	// that with values in the range 1..20 and 1..30 respectively
	for (int i = 0; i < mpyArray.length; i++) {
	    for (int j = 0; j < mpyArray[i].length; j++) {
		mpyArray[i][j] = (i+1)*(j+1);
	    }
	}
	
	// negate all the elements that are odd
	for (int i = 0; i < mpyArray.length; i++) {
	    for (int j = 0; j < mpyArray[i].length; j++) {
		if (mpyArray[i][j] % 2 == 1) {
		    mpyArray[i][j] = -mpyArray[i][j];
		}
	    }
	}
	
	// sum and print the elements
	int sum = 0;
	for (int i = 0; i < mpyArray.length; i++) {
	    for (int j = 0; j < mpyArray[i].length; j++) {
		sum = sum + mpyArray[i][j];
	    }
	}
	printInt(sum);
	printStr("\n");
    }
}

