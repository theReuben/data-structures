public class BTree {
	private Node root;
	private int b;

	public BTree(int b) {
		this.root = new Node(b, null);
		this.b = b;
	}

	// Search, Boolean
	public Boolean find(int number) {
		return find(this.root, number);
	}

	private Boolean find(Node node, int number) {
		int firstIndex = 0;
		int secondIndex = 0;
		int[] arr = node.getElements();

		for (int n : arr) {
			if (number == arr[secondIndex]) {
				return true;
			} else if (number < arr[secondIndex]) {
				break;
			} else {
				secondIndex++;
			}
		}

		if (node.isLeaf()) {
			return false;
		}

		// 0,1,2,3,4,5,6,7,8,9
		if (secondIndex == 0) {
			firstIndex = secondIndex;
		} else if (secondIndex == arr.length) {
			firstIndex = --secondIndex;
		} else {
			secondIndex = firstIndex--;
		}

		return find(node.childAt(firstIndex, secondIndex), number);
	}
}