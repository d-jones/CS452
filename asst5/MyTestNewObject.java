class Main extends Lib{
	public void main(){
		Test test = new Test();
		test.test();
		super.printStr("test.a: ");
		super.printInt(test.a);

		super.printStr("\n");
	}
}

class Test{
	int a;
	public void test(){
		a = 9;
	}
}