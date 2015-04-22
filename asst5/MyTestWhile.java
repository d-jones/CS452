class Main extends Lib{
	public void main(){
		int i = 0;
		boolean b1 = true;
		boolean b2 = false;

		
		while(i < 10){ //true
			super.printStr("while(i < 3): ");
			super.printInt(i);
			super.printStr("\n");
			if(i != 0 && i % 5 == 0){
				break;
			}
			i++;
		}
		
		while(b1){
			super.printStr("while(b1): \n");
			b1 = !b1;
		}
		b1 = !b1;
		
		while(b1 != false){ //true
			super.printStr("while(b1 != false): \n");
			b1 = !b1;
		}
		b1 = !b1;
		
		while(!b2){ //true
			super.printStr("while(!b2): \n");
			b2 = !b2;
		}
		b2 = !b2;
		
		while(b2 == false){ //true
			super.printStr("while(b2 == false): \n");
			b2 = !b2;
		}
		b2 = !b2;
	}
}