package SumTreeProblem;

public class SumTree {
	
	public static void main(String[] args) {
//						8
//				7        		-4
//	       3		 -6		7			9
		Node root = new Node(8);
		root.left = new Node(7);
		root.right = new Node(-4);
		root.left.left = new Node(3);
		root.left.right = new Node(-6);
		root.right.left = new Node(7);
		root.right.right = new Node(9);
		root.convertIntoSumTree(root);
		root.printInOrder(root);
	}

}
class Node
{
	int value;
	Node left;
	Node right;
	public Node(int value)
	{
		this.value = value;
	}
	public void printInOrder(Node node) {
		if(node == null)
		{
			return;
		}
		printInOrder(node.left);
		System.out.println(node.value+ " ");
		printInOrder(node.right);
		
		
	}
	public int convertIntoSumTree(Node node) {
		if(node == null) return 0;
		int oldValue = node.value;
		int leftTreeSum = convertIntoSumTree(node.left);
		int rightTreeSum = convertIntoSumTree(node.right);
		node.value = leftTreeSum + rightTreeSum;
		return node.value + oldValue;
		
	}
}
