package Staircase;

public class StaircaseBottomUp {
	public static void main(String[] args)
	{
		int n = 4;
		int k = 3;
		System.out.println(numOfWays(n,k));
	}

	private static int numOfWays(int n, int k) {
		int[] arr = new int[n+1];
		arr[0] = 1;
		for(int i=1; i<=n;i++)
		{
			arr[i] = 0;
			for(int j=1; j<=k; j++)
			{
				if(i-j>=0) arr[i] += arr[i-j];
				else break;
			}
		}
		return arr[n];
	}
}
