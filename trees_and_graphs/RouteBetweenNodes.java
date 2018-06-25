import java.util.*;

class RouteBetweenNodes {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	class Node {
		public String name;
		public boolean marked;
		public Node[] children;
	}

	class Tree {
		public Node root;
	}

	boolean bfs(Node start, Node end) {
		Queue queue = new LinkedList<Node>();
		start.marked = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			Node r = queue.remove();
			if (r == end) {
				return true;
			}
			for (int i = 0; i < r.children.length; i++) {
				if (r.children[i].marked == false) {
					r.children[i].marked = true;
					queue.add(r.children[i]);
				}
			}
		}
		return false;
	}
}
