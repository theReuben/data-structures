import java.util.Map;
import java.util.HashMap;

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
}