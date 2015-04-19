class Main extends Lib{
	public void main(){
		int a = 3 * 3; //9
		int b = a * 2; //18
		int c = 2 * a; //18
		int d = b * c; //324
		int e = c * b; //324
		
		int f = -5 * 5; //-25
		int g = 5 * -5; //-25
		int h = f * -5; //125
		int i = -5 * f; //125
		int j = -f * -5; //-125
		int k = -5 * -f; //-125
		int l = f * g; //125
		int m = -f * g; //-125
		int n = f * -g; //-125
		int o = -f * -g; //125
		
		super.printInt(a); //9
		super.printStr("\n");
		super.printInt(b); //18
		super.printStr("\n");
		super.printInt(c); //18
		super.printStr("\n");
		super.printInt(d); //324
		super.printStr("\n");
		super.printInt(e); //324
		super.printStr("\n");
		super.printInt(f); //-25
		super.printStr("\n");
		super.printInt(g); //-25
		super.printStr("\n");
		super.printInt(h); //125
		super.printStr("\n");
		super.printInt(i); //125
		super.printStr("\n");
		super.printInt(j); //-125
		super.printStr("\n");
		super.printInt(k); //-125
		super.printStr("\n");
		super.printInt(l); //625
		super.printStr("\n");
		super.printInt(m); //-625
		super.printStr("\n");
		super.printInt(n); //-625
		super.printStr("\n");
		super.printInt(o); //625
		super.printStr("\n");
		
	}
}