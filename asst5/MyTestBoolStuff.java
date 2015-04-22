class Main extends Lib{
	public void main(){
		int i1 = 1;
		int i2 = 2;
		
		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = 2 > 1; //true
		boolean b4 = 2 > i1; //true
		boolean b5 = i2 > 1; //true
		boolean b6 = i2 > i1;  //true
		boolean b7 = i2 > -i1; //true
		boolean b8 = 1 < 2; //true
		boolean b9 = i1 < 2; //true
		boolean b10 = 1 < i2; //true
		boolean b11 = i1 < i2; //true
		boolean b12 = -i1 < i2; //true
		boolean b13 = -i2 < -i1; //true


		if(1 == 1){ //true
			super.printStr("1 == 1 ==> PASS\n");
			
		}
		if(1 != 2){ //true
			super.printStr("1 != 2 ==> PASS\n");
		}
		if(b1 == true){ //true
			super.printStr("b1 == true ==> PASS\n");
		}
		if(b2 == false){ //true
			super.printStr("b2 == false ==> PASS\n");
		}
		if(b3 == true){ //true
			super.printStr("b3 == true ==> PASS\n");
		}
		if(b4 == true){ //true
			super.printStr("b4 == true ==> PASS\n");
		}
		if(b5 == true){ //
			super.printStr("b5 == true ==> PASS\n");
		}
		if(b6 == true){ //
			super.printStr("b6 == true ==> PASS\n");
		}
		if(b7 == true){
			super.printStr("b7 == true ==> PASS\n");
		}
		if(b8 == true){
			super.printStr("b8 == tru ==> PASS\n");
		}
		if(b9 == true){
			super.printStr("b9 == true ==> PASS\n");
		}
		if(b10 == true){
			super.printStr("b10 == true ==> PASS\n");
		}
		if(b11 == true){
			super.printStr("b11 == true ==> PASS\n");
		}
		if(b12 == true){
			super.printStr("b12 == true ==> PASS\n");
		}
		if(b13 == true){
			super.printStr("b13 == true ==> PASS\n");
		}
		
		/////////////////////////////////////////////////////////////
		super.printStr("****************************\n");
		/////////////////////////////////////////////////////////////
		
		if(b1 != false){ //true
			super.printStr("b1 != false ==> PASS\n");
		}
		if(b2 != true){ //true
			super.printStr("b2 != true ==> PASS\n");
		}
		if(b3 != false){ //true
			super.printStr("b3 != false ==> PASS\n");
		}
		if(b4 != false){ //true
			super.printStr("b4 != false ==> PASS\n");
		}
		if(b5 != false){ //
			super.printStr("b5 != false ==> PASS\n");
		}
		if(b6 != false){ //
			super.printStr("b6 != false ==> PASS\n");
		}
		if(b7 != false){
			super.printStr("b7 != false ==> PASS\n");
		}
		if(b8 != false){
			super.printStr("b8 != false ==> PASS\n");
		}
		if(b9 != false){
			super.printStr("b9 != false ==> PASS\n");
		}
		if(b10 != false){
			super.printStr("b10 != false ==> PASS\n");
		}
		if(b11 != false){
			super.printStr("b11 != false ==> PASS\n");
		}
		if(b12 != false){
			super.printStr("b12 != false ==> PASS\n");
		}
		if(b13 != false){
			super.printStr("b13 != false ==> PASS\n");
		}
		
		/////////////////////////////////////////////////////////////
		super.printStr("****************************\n");
		/////////////////////////////////////////////////////////////
		
		if(!(1 == 2)){ //true
			super.printStr("!(1 == 2) ==> PASS\n");
		}
		if(!(!(!(1 == 2)))){ //true
			super.printStr("!(!(!(1 == 2))) ==> PASS\n");
		}
		if(!(!(!(!(1 == 1))))){ //true
			super.printStr("!(!(!(!(1 == 1)))) ==> PASS\n");
		}
	}
}