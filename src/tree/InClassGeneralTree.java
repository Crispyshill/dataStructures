package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shill
 *
 * @param <E>
 */
public class InClassGeneralTree<E> {
	
	Node<E> root;
	int nodeCount = 0;
	
	/**
	 * @author shill
	 *
	 * @param <E>
	 */
	private static class Node<E>{
		
		private E data;
		private List<Node> children;
		private Node<E> parent;
		
		private Node(E item) {
			data = item;
			children = new ArrayList<>();
			parent = null;
		}
		
		
	}
	
	/**
	 * @param node
	 */
	public void addRoot(Node<E> node) {
		if(this.nodeCount == 0) {
			root = node;
			nodeCount++;
		}
	}
	
	/**
	 * @param parent
	 * @param child
	 */
	public void addChild(Node<E> parent, Node<E> child) {
		parent.children.add(child);
		child.parent = parent;
		nodeCount++;
	}
	
	/**
	 * @param node
	 * @return
	 */
	public E getParent(Node<E> node) {
		return node.parent.data;
	}
	
	/**
	 * @param node1
	 * @param node2
	 * @return
	 */
	public boolean areSiblings(Node<E> node1, Node<E> node2) {
		return (node1.parent.equals(node2.parent));
	}
	
	/**
	 * @param node
	 */
	public void printChildren(Node<E> node) {
		for(int i = 0; i < node.children.size(); i++) {
			System.out.println(node.children.get(i).data);
		}
	}
	
	/**
	 * @param node
	 */
	public void printNodesPreorder(Node<E> node) {
		if(node.children.size() == 0) {
			return;
		}
		else {
			if(node.equals(root)) {
				System.out.println(root.data);
			}
			for(int i = 0; i < node.children.size(); i++) {
				System.out.println(node.children.get(i).data);
				printNodesPreorder(node.children.get(i));
			}
		}
	}
	
	/**
	 * @param node
	 */
	public void printNodesPostorder(Node<E> node) {
		if(node.children.size() == 0) {
			return;
		}
		else {
			for(int i = 0; i < node.children.size(); i++) {
				printNodesPostorder(node.children.get(i));
				System.out.println(node.children.get(i).data);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Node<String> nodeA = new Node<>("A");
		Node<String> nodeB = new Node<>("B");
		Node<String> nodeC = new Node<>("C");
		Node<String> nodeD = new Node<>("D");
		Node<String> nodeE = new Node<>("E");
		Node<String> nodeF = new Node<>("F");
		
		InClassGeneralTree<String> tree = new InClassGeneralTree();
		
		tree.addRoot(nodeA);
		tree.addChild(nodeA, nodeB);
		tree.addChild(nodeA, nodeC);
		tree.addChild(nodeB, nodeD);
		tree.addChild(nodeB, nodeE);
		tree.addChild(nodeC, nodeF);

		System.out.println("Searching for parent");
		System.out.println(tree.getParent(nodeD));
		
		System.out.println("Checks if E and D are siblings:");
		System.out.println(tree.areSiblings(nodeE, nodeD));
		
		System.out.println("Checks if C and D are siblings:");
		System.out.println(tree.areSiblings(nodeC, nodeD));

		System.out.println("=================================");
		tree.printChildren(nodeB);
		
		System.out.println("=================================");
		tree.printNodesPreorder(nodeA);
		
		System.out.println("=================================");
		tree.printNodesPostorder(nodeA);
	}
}
