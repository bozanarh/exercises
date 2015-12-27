package tests;


public class Exer2{
	
	public static double calc(int n ){
		if (n == 0 || n == 1) return n;
		
		int retval = n /2;
		int p = retval * retval;
		if (p == n) return retval;
		
		int hi = retval, lo = retval;
		
		//find two closest ints
		if (p > n){
			while( p > n){
				retval -=1;
				p = retval * retval;
			}
			lo = retval;
			hi = retval + 1;
		}else if( p < n ){
			while( p < n){
				retval += 1;
				p = retval * retval;
			}
			hi = retval;
			lo = retval -1;
		}
		//result is somewhere in between lo and hi, find it
		double ret = findClosest(lo, hi, n);
		return ret;
	}
	
	private static double findClosest( double lo, double hi, double n){
		double diff = 0.5;
		final double precision = 0.01;

		//interpolate
		while( abs(n - (lo + diff) * (lo + diff)) > precision ){
			lo = lo + diff / 2;
			hi = hi - diff / 2;
			if ( abs(n - lo * lo) < abs(n - hi * hi) ){
				lo = lo - diff / 2;
			} else {
				hi = hi + diff / 2;
			}
			diff = (hi - lo ) / 2;
		}
		return lo+diff;
	}
	
	private static double abs(double val){
		return val > 0 ? val : -val;
	}
	
	public static void test(int val){
		double ret = calc(val);
		System.out.println("sqrt(" + val + ")=" + ret);
	}
	
	public static void main(String [] arr) {
		test(56);
		test(356);
	}
}
