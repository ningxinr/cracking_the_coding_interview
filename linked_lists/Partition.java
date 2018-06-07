import java.util.*;
import java.util.concurrent.*;

class Partition {
	private static void partition(Node head, int x) {
		Node m = head;
		Node n = head.next;
		if (m.data >= x && n.data < x) {
			exchange(m, n);
		}

		while (m.next != null && n.next != null) {
			if (m.next.data >= x && n.next.data < x) {
				exchange(m.next, n.next);
				m = m.next;
			} else if (m.next.data < x) {
				m = m.next;
			}
			n = n.next;
		}
	}

	private static Node findNextSmaller(Node head, int x) {
		Node n = head;
		while (n.next != null) {
			if (n.data < x) {
				break;
			}
			n = n.next;
		}
		return n;
	}

	private static void exchange(Node m, Node n) {
		if (m != null && n != null) {
			int temp = m.data;
			m.data = n.data;
			n.data = temp;
		}
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
		Node head = new Node(3);
		int[] array = {5, 8, 5, 10, 2, 1};
		for (int i = 0; i < array.length; i++) {
			head.appendToTail(array[i]);
		}
		head.printTilTail();
		partition(head, 5);
		System.out.println("Partitioned!");
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

	void deleteNode(Node prev) {
		prev.next = this.next;
	}
}
