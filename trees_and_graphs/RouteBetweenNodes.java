import java.util.*;

class RouteBetweenNodes {
    public static void main(String[] args) { 
		Node root = new Node();
		System.out.println(root.visiting);
		System.out.println(root.visited);

	}

    boolean bfs(Node start, Node end) {
	if (start == end) {
	    return true;
	}

	Queue<Node> queue = new LinkedList<Node>();
	start.visiting = true;
	queue.add(start);

	while (!queue.isEmpty()) {
	    Node r = queue.remove();
	    if (r == end) {
		return true;
	    }
	    for (int i = 0; i < r.children.length; i++) {
		if (!(r.children[i].visiting || r.children[i].visited)) {
		    r.children[i].visiting = true;
		    queue.add(r.children[i]);
		}
	    }
	    r.visited = true;
	}
	return false;
    }
}

class Node {
    public String name;
    public boolean visiting;
    public boolean visited;
    public Node[] children;
}

class Tree {
    public Node root;
}
