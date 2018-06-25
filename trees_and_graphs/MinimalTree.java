import java.util.*;

class MinimalTree {
	public static Node fillMinimalTree(Integer[] array) {
		if (array.length == 0) {
			return null;
		}
		if (array.length == 1) {
			return new Node(array[0]);
		}
		Node root = new Node(array[array.length/2]);
		root.leftChild = fillMinimalTree(Arrays.copyOfRange(array, 0, array.length/2));
		root.rightChild = fillMinimalTree(Arrays.copyOfRange(array, array.length/2 + 1, array.length));
		return root;
	}

	public static void main(String[] args) {
		int size = 8;
		Random rand = new Random();
		Integer[] array = new Integer[size];

		int base = 0;
		for (int i = 0; i < size; i++) {
			base += (rand.nextInt(5) + 1);
			array[i] = base;
		}

		for (int i = 0; i < size; i++) {
			System.out.println(array[i]);
		}

		Node root = fillMinimalTree(array);
		root.printTree();
	}
}

class Node {
	private int number;
	public Node leftChild;
	public Node rightChild;

	public Node(int number) {
		this.number = number;
	}

	public void printTree() {
		System.out.println(number);
		if (leftChild != null) {
			System.out.println(number + " Left Child");
			leftChild.printTree();
		}
		if (rightChild != null) {
			System.out.println(number + " Right Child");
			rightChild.printTree();
		}
	}
}
