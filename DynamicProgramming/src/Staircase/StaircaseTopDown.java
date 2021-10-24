package Staircase;

public class StaircaseTopDown {
	public static void main(String[] args)
	{
		int n = 4;
		int k = 3;
		int[] arr = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = -1;
		}
		System.out.println(numOfWays(n,k, arr));
	}

	private static int numOfWays(int n, int k, int[] arr) {
		
		if(n==0) 
		{
			arr[n]= 1;
			return 1;
		}
		if(n<0)
		{
			return 0;
		}
		if(arr[n]!=-1) return arr[n];
		else
		{
			arr[n] = 0;
			for(int i=1; i<=k ;i++)
			{
				arr[n]+= numOfWays(n-i, k, arr);
			}
			return arr[n];
		}
		
	}
	
}
