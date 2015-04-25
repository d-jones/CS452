class Main extends Lib{
	public void main(){
		if(null == null){
			super.printStr("null == null ==> PASS\n");
		}
		else{
			super.printStr("null == null ==> FAILED\n");
		}
		
		String a = null;
		
		if(a == null){
			super.printStr("a == null ==> PASS\n");
		}
		else{
			super.printStr("a == null ==> FAILED\n");
		}
	}
}