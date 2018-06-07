import java.util.*;

class ReturnKthToLast {
	private static Node returnKthToLast(Node head, int k) {
		if (head == null || k < 0) {
			return head;
		}
		Node n = head;
		for (int i = 0; i < (k - 1); i++) {
			if (n.next != null) {
				n = n.next;
			} else {
				return head;	
			}
		}
		Node m = head;
		while (n.next != null) {
			n = n.next;
			m = m.next;
		}
		return m;
	}

	public static void main(String[] args) {
		Node head = new Node(0);
		Random rand = new Random();
		for (int i = 1; i < 10; i++) {
			head.appendToTail(rand.nextInt(10));
		}
		head.printTilTail();
		int k = rand.nextInt(10);
		Node n = returnKthToLast(head, k);
		System.out.println("Return " + k + "th To Last: " + n.data);
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
}
