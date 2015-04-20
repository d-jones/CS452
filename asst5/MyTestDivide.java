class Main extends Lib{
	public void main(){
		int a = 20/ 2; //10
		int b = 20 / -2; //-10
		int c = -40 / 2; //-20
		int d = -40 / -2; //20
		
		int e = a / 5; //2
		int f = 20 / a; //2
		int g = -a / 5; //-2
		int h = 20 / -a; //-2
		int i = c / a; //-2
		int j = d / a; //2
		int k = -c / a; //2
		int l = c / -a; //2
		int m = -d / -a; //2
		
		super.printInt(a); //10
		super.printStr("\n");
		super.printInt(b); //-10
		super.printStr("\n");
		super.printInt(c); //-20
		super.printStr("\n");
		super.printInt(d); //20
		super.printStr("\n");
		super.printInt(e); //2
		super.printStr("\n");
		super.printInt(f); //2
		super.printStr("\n");
		super.printInt(g); //-2
		super.printStr("\n");
		super.printInt(h); //-2
		super.printStr("\n");
		super.printInt(i); //-2
		super.printStr("\n");
		super.printInt(j); //2
		super.printStr("\n");
		super.printInt(k); //2
		super.printStr("\n");
		super.printInt(l); //2
		super.printStr("\n");
		super.printInt(m); //2
		super.printStr("\n");
	}
}