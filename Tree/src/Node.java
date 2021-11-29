
public class Node {
Node left;
Node right;
int data;
public Node(int data) {
	this.left = null;
	this.right=null;
	this.data =data;
}
public static Node insertNode(Node root, int data)
{
	if(root==null)
	{
		root = new Node(data);
	}else
	{
		Node cur = root;
		if(data<=root.data)
		{
			cur = insertNode(root.left, data);
			root.left = cur;
		}else
		{
			cur = insertNode(root.right, data);
			root.right = cur;
		}
	}
	return root;
}

}
