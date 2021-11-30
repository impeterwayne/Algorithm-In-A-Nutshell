package BinarySearchTree;

public class TestDrive {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = tree.new Node(13);
		System.out.println("Insert");
		tree.insert(15);
		tree.insert(7);
		tree.insert(30);
		tree.insert(32);
		tree.insert(12);
		tree.insert(8);
		tree.insert(5);
		tree.insert(123);
		tree.insert(134);
		tree.getInOrder(tree.root);
		System.out.println("Search value 7");
		System.out.println(tree.search(7).value);
		System.out.println("Delete value 13");
		tree.delete(13);
		tree.getInOrder(tree.root);
	}

}
