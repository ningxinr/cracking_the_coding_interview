import java.util.*;

class SumLists {
	private static Node sumLists(Node head1, Node head2) {
		Node m = head1;
		Node n = head2;
		int add = (m.data + n.data) / 10;
		m.data = (m.data + n.data) % 10;
		while (n.next != null && m.next != null) {
			m.next.data += n.next.data + add;
			add = m.next.data / 10;
			m.next.data %= 10;
			m = m.next;
			n = n.next;
		}

		while (n.next != null) {
			m.next = n.next;
			m.next.data += add;
			add = m.next.data / 10;
			m.next.data %= 10;
			m = m.next;
			n = n.next;
		}

		while (m.next != null) {
			m.next.data += add;
			add = m.next.data / 10;
			m.next.data %= 10;
			m = m.next;
		}

		if (add != 0) {
			m.next = new Node(add);
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
		System.out.println("New Lists!");
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

		System.out.println("New Lists!");
		head1 = new Node(7);
		head1.appendToTail(1);
		head1.appendToTail(6);
		head2 = new Node(5);
		head2.appendToTail(9);
		head2.appendToTail(4);
		head1.printTilTail();
		head2.printTilTail();
		head = sumLists(head1, head2);
		System.out.println("Sumed Lists!");
		head.printTilTail();

		System.out.println("New Lists!");
		head1 = new Node(7);
		head1.appendToTail(1);
		head1.appendToTail(6);
		head1.appendToTail(1);
		head2 = new Node(5);
		head2.appendToTail(9);
		head2.appendToTail(2);
		head1.printTilTail();
		head2.printTilTail();
		head = sumLists(head1, head2);
		System.out.println("Sumed Lists!");
		head.printTilTail();

		System.out.println("New Lists!");
		head1 = new Node(7);
		head1.appendToTail(1);
		head1.appendToTail(6);
		head2 = new Node(5);
		head2.appendToTail(9);
		head2.appendToTail(2);
		head2.appendToTail(1);
		head1.printTilTail();
		head2.printTilTail();
		head = sumLists(head1, head2);
		System.out.println("Sumed Lists!");
		head.printTilTail();

		System.out.println("New Lists!");
		head1 = new Node(7);
		head1.appendToTail(1);
		head1.appendToTail(6);
		head1.appendToTail(1);
		head2 = new Node(5);
		head2.appendToTail(9);
		head2.appendToTail(4);
		head1.printTilTail();
		head2.printTilTail();
		head = sumLists(head1, head2);
		System.out.println("Sumed Lists!");
		head.printTilTail();

		System.out.println("New Lists!");
		head1 = new Node(7);
		head1.appendToTail(1);
		head1.appendToTail(6);
		head2 = new Node(5);
		head2.appendToTail(9);
		head2.appendToTail(4);
		head2.appendToTail(1);
		head1.printTilTail();
		head2.printTilTail();
		head = sumLists(head1, head2);
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
