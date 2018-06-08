import java.util.*;

class Palindrome {
	private static boolean palindrome(Node head) {
		Node n = head;
		Node rev = new Node(n.data);	
		while (n.next != null) {
			rev = appendToHead(rev, n.next.data);
			n = n.next;
		}

		n = head;
		Node m = rev;
		while (n.next != null && m.next != null && n.next.data == m.next.data) {
			n = n.next;
			m = m.next;
		}

		return head.data == rev.data && n.next == null && m.next == null;
	}

	private static Node appendToHead(Node head, int d) {
		Node newHead = new Node(d);
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
		Node head = new Node(0);
		head.printTilTail();
		if (palindrome(head)) {
			System.out.println("Palindrome!");
		} else {
			System.out.println("Not Palindrome!");
		}

		head.appendToTail(1);
		head.printTilTail();
		if (palindrome(head)) {
			System.out.println("Palindrome!");
		} else {
			System.out.println("Not Palindrome!");
		}

		head.appendToTail(0);
		head.printTilTail();
		if (palindrome(head)) {
			System.out.println("Palindrome!");
		} else {
			System.out.println("Not Palindrome!");
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
