package Staircase;

public class StaircaseRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4; 
		int k = 3; // step : 1, 2, 3
		int ways = numOfWays(n,k);
		System.out.println(ways);
	}

	private static int numOfWays(int n, int k) {
		int ways = 0;
		if(n==0) return 1;
		if(n<0) return 0;
		for(int i=1; i<=k; i++)
		{
			ways+=numOfWays(n-i, k);
		}
		return ways;
	}

}
