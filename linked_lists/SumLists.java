import java.util.*;

class SumLists {
	private static Node sumLists(Node head1, Node head2) {
		Node m = head1;
		Node n = head2;
		while (n.next != null) {
				n = n.next;
		}
		return head1;
	}

	private static Node sumListsR(Node head1, Node head2) {
		Node m = head1;
		Node n = head2;
		while (n.next != null) {
				n = n.next;
		}
		return head1;
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
		Node head1 = new Node(7);
		head1.appendToTail(1);
		head1.appendToTail(6);
		Node head2 = new Node(5);
		head2.appendToTail(9);
		head2.appendToTail(2);
		head1.printTilTail();
		head2.printTilTail();
		Node head = sumLists(head1, head2);
		System.out.println("Sumed Lists!");
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
		System.out.print(n.data);
		System.out.print(' ');
		while (n.next != null) {
			n = n.next;
			System.out.print(n.data);
			System.out.print(' ');
		}
		System.out.println();
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
