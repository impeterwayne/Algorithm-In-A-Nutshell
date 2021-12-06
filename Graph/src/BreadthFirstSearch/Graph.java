package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Graph {
	private ArrayList<Integer>[] graph;
	private int V;
	private boolean visited[];
	
	@SuppressWarnings("unchecked")
	//Graph creation
	Graph(int numOfVertices)
	{
		V = numOfVertices;
		graph = new ArrayList[V];
		visited = new boolean[V];
		for(int i=0; i<V;i++)
		{
			graph[i] = new ArrayList<Integer>();
		}
	}
	// adding edge
	void addEdge(int src , int dest)
	{
		graph[src].add(dest);
	}
	void bfsTraversal(int s)
	{
		LinkedList<Integer> queue = new LinkedList<>();
		// adding first node
		queue.add(s);
		visited[s] = true;
		while(queue.size()!=0)
		{
			int current = queue.poll();
			Iterator<Integer> itr = graph[current].listIterator();
			while(itr.hasNext())
			{
				int next = itr.next();
				if(!visited[next])
				{
					//adding adjacent nodes for the current node
					visited[next] = true;
					queue.add(next);
				}
			}
			System.out.print(current+ " ");
		}
	}
	public static void main(String[] args) {
		Graph g = new Graph(13);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 5);
		g.addEdge(2, 4);
		g.addEdge(2, 10);
		g.addEdge(2, 5);
		g.addEdge(2, 7);
		g.addEdge(3, 6);
		g.addEdge(4, 7);
		g.addEdge(5, 2);
		g.addEdge(5, 8);
		g.addEdge(6, 9);
		g.addEdge(8, 11);
		g.addEdge(11,12);
		System.out.println("BFS - Traversal: ");
		g.bfsTraversal(1);

	}

}
