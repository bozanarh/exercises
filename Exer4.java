package tests;

public class Exer4 {
	
	public static int[] closes( int [] a){
		int x = a[0];
		int y = a[1];
		int diff1 = abs(100 - (x + y));
		for (int i=2; i<a.length; i++){
			int diff2 = abs(100 - (a[i] + a[i-1]));
			
			if (diff2 < diff1) {
				diff1 = diff2;
				x = a[i-1];
				y = a[i];
			}
		}
		int [] ret = {x, y};
		return ret;
	}
	
	private static int abs( int i ) {
		return i > 0 ? i : -i;
	}
	
    //test
	public static void test1(){
		int [] arr = { 11, 15, 96, 37, 34, 66, 51, 55 };
		Exer4 exer = new Exer4();
		int [] ret = exer.closes(arr);
		for( int i=0; i<ret.length; i++) System.out.printf("%d ", ret[i]);
		System.out.println();
	}
	//for testing only
	public static void main(String []args){
		test1();
	}

}
