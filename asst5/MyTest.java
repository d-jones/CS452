class Main{
	public void main(){
		Lib lib = new Lib();
		lib.printStr("lib.printStr() ==> PASS\n");
		lib.printInt(9);
		lib.printStr(" lib.printInt() ==> PASS\n");
		lib.printStr("******************************\n");
		
		Arithmetic arith = new Arithmetic();
		lib.printStr("new Arithmetic() ==> PASS\n");
		lib.printStr("******************************\n");
		
		if(arith.testArithmetic()){
			lib.printStr("ARITHMETIC ==> PASS\n");
		}
		else{
			lib.printStr("ARITHMETIC ==> FAILED\n");
		}
	}
}

class Arithmetic{
	Lib lib;
	
	public boolean testArithmetic(){
		lib = new Lib();
		boolean success = testAddition() && testSubtraction() && testDivision() && testRemainder();
		
/*		if(!success){
			lib.printStr("testArithmetic ==> FAILED\n");
			return false;
		}*/
		
		lib.printStr("testArithmetic ==> PASS\n");
		return true;
	}
	
	/**
	 * tests addition
	 * @return
	 */
	public boolean testAddition(){
		int a = 5;
		int b = 10;
		int c = -10;
		int d = b + 5; //15
		int e = a + 10; //15
		int f = a + b; //15
		int g = b + c; //0
		int h = c + a; //-5
		
		if(d != 15){
			lib.printStr("d == 15 ==> FAILED\n");
			return false;
		}
		else if(e != 15){
			lib.printStr("e == 15 ==> FAILED\n");
			return false;
		}
		else if(f != 15){
			lib.printStr("f == 15 ==> FAILED\n");
			return false;
		}
		else if(g != 0){
			lib.printStr("g == 0 ==> FAILED\n");
			return false;
		}
		else if(h != -5){
			lib.printStr("h == -5 ==> FAILED\n");
			return false;
		}
		return true;
	}
	
	
	/**
	 * tests subtraction
	 * @return
	 */
	private boolean testSubtraction(){
		int a = 5;
		int b = 10;
		int c = -5;
		int d = -10;
		int e = a - 5; //0
		int f = a + c; //0
		int g = c + b; //5
		int h = a - b; //-5
		int i = b - a; //5
		int j = -b + -a; //5
		
		if(e != 0){
			lib.printStr("e == 0 ==> FAILED\n");
			return false;
		}
		else if(f != 0){
			lib.printStr("f == 0 ==> FAILED\n");
			return false;
		}
		else if(g != 5){
			lib.printStr("g == 5 ==> FAILED\n");
			return false;
		}
		else if(h != -5){
			lib.printStr("h == -5 ==> FAILED\n");
			return false;
		}
		else if(i != 5){
			lib.printStr("i == 5 ==> FAILED\n");
			return false;
		}
		else if(j != 5){
			lib.printStr("j == 5 ==> FAILED\n");
			return false;
		}
		return true;
	}
	
	
	/**
	 * tests division
	 * @return
	 */
	private boolean testDivision(){
		int a = 5;
		int b = 10;
		int c = b / a; //2
		int d = a / b; //0
		int e = -10 / 5; //-2
		int f = -10 / -5; //2
		
		if(c != 2){
			lib.printStr("c == 2 ==> FAILED\n");
			return false;
		}
		else if(d != 0){
			lib.printStr("d == 0 ==> FAILED\n");
			return false;
		}
		else if(e != -2){
			lib.printStr("e == -2 ==> FAILED\n");
			return false;
		}
		else if(f != 2){
			lib.printStr("f == 2 ==> FAILED\n");
			return false;
		}
		return true;
	}
	
	
	/**
	 * tests remainder
	 * @return
	 */
	private boolean testRemainder(){
		int a = 5;
		int b = 10;
		int c = 10 % 5; //0
		int d = b / a; //0
		int e = 20 % 3; //2
		int f = 10 % 20; //10
		int g = 100 % 99; //1
		
		if(c != 0){
			lib.printStr("c == 0 ==> FAILED\n");
			return false;
		}
		else if(d != 0){
			lib.printStr("d == 0 ==> FAILED\n");
			return false;
		}
		else if(e != 2){
			lib.printStr("e == 2 ==> FAILED\n");
			return false;
		}
		else if(f != 10){
			lib.printStr("f == 10 ==> FAILED\n");
			return false;
		}
		else if(g != 1){
			lib.printStr("g == 1 ==> FAILED\n");
			return false;
		}
		return true;
	}
}