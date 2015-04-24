class Main extends Lib{
	public void main(){
		int[] array = new int[4];
		array[0] = 1;
		array[1] = 2;
		array[2] = 7;
		array[3] = 9;
		super.printStr("Array length: ");
		super.printInt(array.length);
		super.printStr("\n");
		
		int a = 0;
		a = array[2];
		super.printStr("array[2]: ");
		super.printInt(a);
		super.printStr("\n");
		
		String[] temp = new String[1];
		temp[0] = "test";
		super.printStr(temp[0]);
		super.printStr("\n\n\n");
		
		int i = 0;
		while(i < array.length){
			a = array[i];
			super.printStr("array[i] = ");
			super.printInt(a);
			super.printStr("\n");
			i++;
		}
	}
}