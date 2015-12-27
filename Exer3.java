package tests;
import java.util.Scanner;

public class Exer3 {

    public int[] calcProduct(int [] in) {
    	boolean hasZero = false;
        int []out = new int[in.length];
        int total = 1;
        //cals product of all numbers and notice if there is 0
        for (int i=0; i<in.length; i++){
            if (in[i] == 0 ) {
            	hasZero = true;
            	continue;
            }
            total = total * in[i];
        }
        //calc product, take care of zero elems
        for (int i=0; i<in.length; i++){
            if (in[i] != 0){
            	if (hasZero) out[i] = 0;
            	else out[i] = total / in[i];
            } else out[i] = total;
        }
        return out;
    }

    //for testing only
    public static void main( String [] args ){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        Exer3 exer3 = new Exer3();
        int [] prod = exer3.calcProduct(arr);
        for (int i=0; i<prod.length; i++) {
            System.out.printf("%d ", prod[i]);
        }
        System.out.println();
    }
}
