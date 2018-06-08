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
		while (m.next != null && n.next != null) {
			m = m.next;
			n = n.next;
		}
		
		m = findStart(head1, m);
		n = findStart(head2, n);

		Node base = (m == head1) ? n : m;
		Node adder = (m == head1) ? m : n;

		base.data += adder.data;

		while (base.next != null && adder.next != null) {
			base.next.data += adder.next.data;
			base = base.next;
			adder = adder.next;
		}
			
		Node baseHead = (m == head1) ? head2 : head1;
		boolean invalid = true;

		while (invalid) {
			base = baseHead;
			invalid = base.data > 10;
			if (invalid) {
				Node newHead = new Node(baseHead.data / 10);
				baseHead.data %= 10;
				newHead.next = baseHead;
				baseHead = newHead;
			}	

			while (base.next != null) {
				invalid |= base.next.data > 10;
				base.data += base.next.data / 10;
				base.next.data %= 10;
				base = base.next;
			}
		}

		return baseHead;
	}

	private static Node findStart(Node head, Node n) {
		if (n.next == null) {
			return head;
		}

		Node temp = head;
		while (n.next != null) {
			temp = temp.next;
			n = n.next;
		}
		return temp;
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
		Node head = sumListsR(head1, head2);
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
		head = sumListsR(head1, head2);
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
		head = sumListsR(head1, head2);
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
		head = sumListsR(head1, head2);
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
		head = sumListsR(head1, head2);
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
		head = sumListsR(head1, head2);
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
