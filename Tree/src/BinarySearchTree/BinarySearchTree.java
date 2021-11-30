package BinarySearchTree;

public class BinarySearchTree {

	class Node
	{
		int value;
		Node left, right;
		public Node(int value) {
			
			this.value = value;
			left = right = null;
		}
		
	}
	Node root;
	public BinarySearchTree() {
		root = null;
	}
	public void getInOrder(Node root)
	{
		if(root!=null)
		{
			getInOrder(root.left);
			System.out.println(root.value);
			getInOrder(root.right);
		}
	}
	// Insert
	public void insert(int value)
	{
		this.root = insertInBST(this.root, value);
	}
	private Node insertInBST(Node node, int value)
	{
		if(node==null)
		{
			return new Node(value); 
		}
		if(value<node.value)
		{
			node.left = insertInBST(node.left, value);
		}else if(value> node.value)
		{
			node.right = insertInBST(node.right, value);
		}
		return node;
	}
	// Search
	public Node search(int value)
	{
		return searchInBST(this.root, value);
	}
	private Node searchInBST(Node node, int value) {
		if(node == null|| node.value ==  value)
		{
			return node;
		}
		if(value < node.value)
		{
			return searchInBST(node.left, value);
		}
		
		return searchInBST(node.right, value);
	
	}
	//Delete
	public void delete(int value)
	{
		deleteFromBST(this.root, value);
	}
	private Node deleteFromBST(Node node, int value) {
		if(node == null )
		{
			return node;
		}
		if(value < node.value)
		{
			node.left = deleteFromBST(node.left, value);
		}
		else if (value > node.value)
		{
			node.right = deleteFromBST(node.right, value);
		}
		else
		{
			// case1 : the node has only one right child
			if(node.left==null)
			{
				return node.right;
			}
			// case 2: the node has only one left child
			if(node.right == null)
			{
				return node.left;
			}
			// case 3: the node has left child and right child
			// find the minimum of the right tree and return then delete or 
			// find the maximum of the left tree and return then delete
			node.value = minValue(node.right);
			deleteFromBST(node.right, node.value);
			
		}
		return node;
		
	}
	private int minValue(Node right) {
		int min = right.value;
		while(right.left!=null)
		{
			min = right.left.value;
			right= right.left;
		}
		return min;
	}

}
