// correct output:
//    -119 -55
class Main {
    Lib lib;
    public void main() {
	lib = new Lib();
	lib.printInt(diffSquares(5, 12, false));
	lib.printStr(" ");
	lib.printInt(diffSquares(8, 3, true));
	lib.printStr("\n");
    }
    public int diffSquares(int a, int b, boolean reverse) {
	int aSquared = a*a;
	int bSquared = b*b;
	int result = aSquared-bSquared;
	if (reverse) {
	    result = -result;
	}
	return result;
    }
}
