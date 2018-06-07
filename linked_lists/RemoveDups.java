import java.util.*;


class RemoveDups {
	private static void removeDups(Node head) {
		Set<Integer> occ = new HashSet<>();
		occ.add(head.data);
		Node n = head;
		while (n.next != null) {
			if (occ.contains(n.next.data)) {
				n.next.deleteNode(n);	
			} else {
				occ.add(n.next.data);
				n = n.next;
			}
		}
	}

	private static void removeDupsNoBuffer(Node head) {
		Set<Integer> occ = new HashSet<>();
		occ.add(head.data);
		Node n = head;
		while (n.next != null) {
			Node m = head;
			while (m != n.next) {
				if (m.data == n.next.data) {
					n.next.deleteNode(n);	
					break;
				} else {
					m = m.next;
				}
			}
			if (m == n.next) {
				n = n.next;
			}
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
		Node head = new Node(0);
		Random rand = new Random();
		for (int i = 1; i < 20; i++) {
			head.appendToTail(rand.nextInt(10));
		}
		head.printTilTail();
		removeDupsNoBuffer(head);
		System.out.println("Removed Dups!");
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
