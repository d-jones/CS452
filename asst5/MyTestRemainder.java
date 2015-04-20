class Main extends Lib{
	public void main(){
		int a = 10 % 5; //0
		int b = 10 % 3; //1
		int c = 10 %-3; //-2
		int d = 5 % 10; //5
		int e = -5 % 10; //5
		
		
		super.printInt(a); //0
		super.printInt(b); //1
		super.printInt(c); //-2
		super.printInt(d); //5
		super.printInt(e); //5
	}
}