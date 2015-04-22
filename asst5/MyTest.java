class Main extends Lib{

	public void main(){
		int a = 9;
		int b = a + 2; //b = 11
		int c = b - 2; //c = 9
		
		int d = 1;
		super.printInt(d);
		super.printStr("\n");
		d = d + 1;
		super.printInt(d);
		super.printStr("\n");
		
		String s1 = "test string";
		
		super.printInt(a); //9
		super.printStr("\n");
		super.printInt(a); //9
		super.printStr("\n");
		super.printInt(a); //9
		super.printStr("\n");
		super.printInt(b); //11
		super.printStr("\n");
		super.printInt(b); //11
		super.printStr("\n");
		super.printInt(b); //11
		super.printStr("\n");
		super.printInt(c); //9
		super.printStr("\n");
		super.printInt(c); //9
		super.printStr("\n");
		super.printInt(c); //9
		super.printStr("\n");
		super.printInt(a - b); //-2
		super.printStr("\n");
		super.printInt(a - b); //-2
		super.printStr("\n");
		super.printInt(b - a); //2
		super.printStr("\n");
		super.printInt(b - a); //2
		super.printStr("\n");
		super.printInt(c + a - b); //7
		super.printStr("\n");
		super.printInt(b - a + c); //11
		super.printStr("\n");
		
		super.printStr(s1);
		super.printStr("\n");
		super.printStr("I THINK THIS IS WORKING!!!");
		super.printStr("\n");
	}
}