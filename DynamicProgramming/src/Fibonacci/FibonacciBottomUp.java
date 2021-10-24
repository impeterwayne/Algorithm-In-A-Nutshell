package Fibonacci;

import java.util.Scanner;

public class FibonacciBottomUp {

	//Bottom Up approach
	// Just iteration
	public static int fib(int n, int[] arr)
	{
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2; i<=n; i++)
		{
			arr[i] = arr[i-1]+ arr[i-2];
		}
		return arr[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		System.out.println(fib(n,arr));

	
	}
}
