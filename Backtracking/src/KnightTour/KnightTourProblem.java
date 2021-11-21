package KnightTour;

public class KnightTourProblem {
	static int[][] path = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = { 			{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
							{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
							{ 0, 0, 0, 0, 0, 0, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
							{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
							{ 0, 0, 0, 0, 0, 0, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
							{ 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		if (knightTour(board,0, 0, 0)) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}else 
		{
			System.out.println("No solution");
		}
	}

	private static boolean knightTour(int[][] board, int row, int col, int step) {
		//goal
		if(step ==63) return true;
		//loop through all paths
		for (int i = 0; i < 8; i++) {
			//constraint
			if (moveIsValid(board, row+ path[i][0], col+path[i][1])) {
				step++;
				board[row+ path[i][0]][col+ path[i][1]] = step;
				//recursion
				if (knightTour(board,row+ path[i][0] , col+path[i][1], step))
					return true;
				step--;
				board[row+path[i][0]][col+path[i][1]] = 0;
			}
		}

		return false;

	}

	
	private static boolean moveIsValid(int[][] board, int row, int col) {
			return  row>=0&&row<8
					&&
					col>=0&&col<8
					&&
					board[row][col]==0;  
	}

}
