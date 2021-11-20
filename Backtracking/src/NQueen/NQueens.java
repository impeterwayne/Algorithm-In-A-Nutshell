package NQueen;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] board = {			{0,0,0,0,0},
				 			{0,0,0,0,0},
				 			{0,0,0,0,0},
				 			{0,0,0,0,0},
				 			{0,0,0,0,0}};
		 int n = board.length;
		 if(saveTheQueens(board, 0, n))
			 {
			 	for(int i=0; i<n;i++)
			 	{
			 		for(int j=0; j<n; j++)
			 		{
			 			System.out.print(board[i][j] + " ");
			 		}
			 		System.out.println();
			 	}
			 }
			 else
			 {
				 System.out.println("No solution");
			 }
	}

	private static boolean saveTheQueens(int[][] board, int col, int n) {
		
		//goal
		if(col>=n) return true;
		for(int row = 0; row<n; row++)
		{
			//constraint
			if(isSafe(board, row, col, n))
			{
				board[row][col] = 1;
				//recursion
				if(saveTheQueens(board, col+1, n))
				{
					return true;
				}
				//backtracking
				board[row][col] = 0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] board, int row, int col, int n) {
		int i, j;
		//Loop through left side column
		for(i=0; i<col;i++)
		{
			if(board[row][i]==1) return false;
		}
		//Loop through upper left row & column
		for(i=row, j=col;i>0&&j>=0; i--, j--)
		{
			if(board[i][j]==1) return false;
		}
		//Loop through lower left row & column
		for(i=row, j=col;i<n&&j<n; i++, j++)
		{
			if(board[i][j]==1) return false;
		}
		return true;
	}

}
