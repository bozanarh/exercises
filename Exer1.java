package tests;

public class Exer1 {
	private void steps(String prefix, int n){
		if( n == 0 ) System.out.println(prefix);
		
		if (n >= 2) steps(prefix + "2", n-2);
		if (n >= 1) steps(prefix + "1", n-1);
	}
	
	public void steps(int n){
		steps("", n);
	}
	
	public static void test1(int n){
		Exer1 e = new Exer1();
		e.steps(n);

	}
	public static void main(String [] args) {
		test1(7);
	}

}
