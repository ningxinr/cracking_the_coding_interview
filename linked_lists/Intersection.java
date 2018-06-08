import java.util.*;

class Intersection {
	private static Node intersection(Node head1, Node head2) {
		if (head1 == head2) {
			return head1;
		}

		Node m = head1;
		Node n = head2;
		while (m.next != null && n.next != null) {
			m = m.next;
			n = n.next;
		}

		if (m.next == null && n.next == null) {
			return null;
		}

		Node longer = (m.next != null) ? m : n;
	    Node shorterHead = (m.next != null) ? head2 : head1;

		Node longerHead = (m.next != null) ? head1 : head2;
		while (longer.next != null) {
			longerHead = longerHead.next;
			longer = longer.next;
		}

		while (longerHead.next != shorterHead.next) {
			longerHead = longerHead.next;
			shorterHead = shorterHead.next;
		}
		
		return longerHead.next;
	}

	private static Node appendToHead(Node head, int x) {
		Node newHead = new Node(x);
		newHead.next = head;
		return newHead;
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
		Node head = new Node(1);
		head.appendToTail(2);
		head.appendToTail(3);
		Node head1 = appendToHead(head, 0);
		Node head0 = appendToHead(head, -1);
		Node head2 = appendToHead(head0, -2);
		head1.printTilTail();
		head2.printTilTail();
		Node intersect = intersection(head1, head2);
		System.out.println(intersect.data);
		intersect.printTilTail();

		head1 = new Node(-2);
		head1.appendToTail(-1);
		head1.appendToTail(1);
		head2 = new Node(0);
		head2.appendToTail(1);
		head1.printTilTail();
		head2.printTilTail();
		intersect = intersection(head1, head2);
		if (intersect == null) {
			System.out.println("Found no intersection!");
		} else {
			System.out.println(intersect.data);
			intersect.printTilTail();
		}

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
