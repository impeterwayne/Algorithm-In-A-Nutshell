package Fibonacci;

import java.util.Scanner;

public class FibonacciTopDown {
	//Top Down approach
	//Recursion + Memoization
	public static int fib(int n, int[] arr)
	{
		//store calculated value
		if(arr[n]>0) return arr[n];
		//base case n =0, n=1
		if(n==0) arr[n] = 0;
		else if(n==1) arr[n] = 1;
		// recursion
		else arr[n] = fib(n-1, arr) +fib(n-2,arr);
		return arr[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i=0 ; i<n+1 ;i++)
		{
			arr[i] = -1;
		}
		System.out.println(fib(n,arr));

	}
}
