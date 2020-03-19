public class BTree {
	private Node root;
	private int b;

	public BTree(int b) {
		this.root = new Node(b, None);
		this.b = b;
	}
}