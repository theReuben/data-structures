import java.util.Map;
import java.util.HashMap;

import exceptions.FullNodeException;

public class Node {
	private int[] elements;
	private int nodeSize;
	private int numberOfElements;
	private Map<Integer, Map<Integer, Node>> children;
	private Node parent;

	public Node(int nodeSize, Node parent) {
		this.elements = new int[nodeSize];
		this.nodeSize = nodeSize;
		this.numberOfElements = 0;
		this.children = new HashMap<Integer, Map<Integer, Node>>();
		this.parent = parent;
	}

	// Accessors and Mutators
	public int[] getElements() {
		return this.elements;
	}

	public void setElements(int[] elements) {
		this.elements = elements;
	}

	public int getNodeSize() {
		return this.nodeSize;
	}

	public int getNumberOfElements() {
		return this.numberOfElements;
	}

	public Node getParent() {
		return this.parent;
	}

	// Adding element
	private void incrementNumberOfElements() throws FullNodeException {
		try {
			if (this.numberOfElements + 1 > this.nodeSize) {
				throw new FullNodeException("Node already full.");
			} else {
				this.numberOfElements++;
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	public Node addElement(int element) throws FullNodeException {
		incrementNumberOfElements();
		int index = this.numberOfElements-1;
		while (element < this.elements[index-1] && index > 0) {
			this.elements[index] = this.elements[index-1];
			index--;
		}
		elements[index] = element;
		return this;
	}

	// Removing element
	// private void decrementNumberOfElements() throws {}

	public Node childAt(int x, int y) {
		return this.children.get(x).get(y);
	}

	public Node leftChild() {
		return this.children.get(0).get(0);
	}

	public Node rightChild() {
		return this.children.get(this.numberOfElements-1)
							.get(this.numberOfElements-1);
	}

	// Useful functions
	public Boolean isLeaf() {
		return children.isEmpty();
	}


}				