package Dijktra;

public class Dijktra {

	public static void main(String[] args) {
		int[][] adjacencyMatrix = 
			{
					{0, 3, 5, 6, 0, 8, 0},
					{3, 0, 0, 4 ,2, 0, 5},
					{5, 0, 0, 0, 0, 4, 0},
					{6, 4, 0, 0, 0, 1, 6},
					{0, 2, 0, 0, 0, 0, 10},
					{8, 0, 6, 1, 0, 0, 8},
					{0, 8, 0, 6, 10, 6, 0}
			};
		dijktra(adjacencyMatrix);

	}

	private static void dijktra(int[][] adjacencyMatrix) {
		int numOfVertices = adjacencyMatrix.length;
		boolean[] visited = new boolean[numOfVertices];
		int[] distance = new int[numOfVertices];
		// start
		// distance of the source = 0
		// distance of the res is infinite
		distance[0] = 0;
		for(int i=1; i<numOfVertices; i++)
		{
			distance[i] = Integer.MAX_VALUE;
		}
		//traverse all the adjacent vertices to find minimum distance for each adjacent vertex
		for(int i=0; i< numOfVertices-1; i++)
		{
			int minVertex = findMinVertex(distance, visited);
			visited[minVertex] = true;
			for(int j=0; j<numOfVertices; j++)
			{
				//update new distance if the new distance is smaller than the old one
				if(adjacencyMatrix[minVertex][j]!=0&&!visited[j])
				{
					int newDistance = distance[minVertex] + adjacencyMatrix[minVertex][j];
					if(newDistance<distance[j]) distance[j] = newDistance;
				}
				
			}
		}
		for(int i = 0; i<numOfVertices; i++)
		{
			System.out.println(i + " " + distance[i]);
		}
	}

	private static int findMinVertex(int[] distance, boolean[] visited) {
		int minVertex = -1;
		for(int i=0; i<distance.length; i++)
		{
			//minVertex = -1 so the minVertex is the source
			//while the minVertex is not the source find the minVertex of the rest
			if(!visited[i]&&(minVertex==-1||distance[i]<distance[minVertex]))
			{
				minVertex = i;
			}
		}
		return minVertex;
		
	}

}
