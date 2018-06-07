import java.util.*;

class DeleteMiddleNode {
	private static void deleteMiddleNode(Node toDelete) {
		toDelete.data = toDelete.next.data;
		toDelete.deleteNext();
	}

	private static Node deleteAllNodes(Node head, int d) {
		Node n = head;

		if (n.data == d) {
			return head.next;
		}

		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Node head = new Node(0);
		for (int i = 1; i < 5; i++) {
			head.appendToTail(i);
		}
		head.printTilTail();
		Node toDelete = head.next.next;
		System.out.println("Removed Node: " + toDelete.data + "!");
		deleteMiddleNode(toDelete);
		head.printTilTail();
	}
}

class Node {
	Node next = null;
	int data;

	public Node (int d) {
		data = d;
	}

	void printTilTail() {
		Node n = this;
		System.out.println(n.data);
		while (n.next != null) {
			n = n.next;
			System.out.println(n.data);
		}
	}
	
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	void deleteNext() {
		this.next = this.next.next;
	}
}
