class Main extends Lib{
	public void main(){
		method1();
	}
	
	public void method1(){
		super.printStr("Executed method1() ==> PASS\n");

		method2("BALLZ", 100);
	}
	
	public int method2(String s, int n){
		super.printStr("s: ");
		super.printStr(s);
		super.printStr("\nn: ");
		super.printInt(n);
		super.printStr("\n");
		return 9;
	}
}