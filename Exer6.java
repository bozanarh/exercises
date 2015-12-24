
package tests;

import java.util.Scanner;

public class Exer6 {
   
	private static boolean numExist(int [] arr, int head, int tail, int elem) {
		int N = (tail - head) / 2 ;
		//System.out.println(" N=" + N);
		if (arr[N] == elem){
			return true; 
		}else if( head + 1 == tail) {
			if (arr[head] == elem ) return true;
			else if (arr[tail] == elem ) return true;
		}else if (arr[N] < elem && head != tail){
			head = N+1;
			return numExist(arr, head, tail, elem);
		} else if(arr[N] > elem && head != tail) {
			tail = N-1;
			return numExist(arr, head, tail, elem);
		} 
		
		return false;
	}

    public static boolean numExists( int array[], int N, int elem ){
        int head = 0;
        int tail = N;
        return numExist(array, head, tail, elem);
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        //read elem
        int elem = sc.nextInt();

        //read array elems
        int N = sc.nextInt();
        int []arr = new int[N];

        for (int i=0; i<N; i++) arr[i] = sc.nextInt();

        boolean exist = numExists( arr, N, elem);
        System.out.println(exist);
    }
}
