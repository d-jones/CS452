class Main extends Lib{
	public void main(){
		int a = 9;
		String s = "ashdf;lkjadf";
		if(s instanceof String){
			super.printStr("s instanceof String ==> PASS\n");
		}
		
		Test test = new Test();
		if(test instanceof Test){
			super.printStr("test instanceof Test ==> PASS\n");
		}
	}
}

class Test{
	public void test(){
		
	}
}