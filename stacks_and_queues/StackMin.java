import java.util.*;

class StackMin {
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<Integer>();
		System.out.println(stack.isEmpty());
		stack.push(2);
		System.out.println(stack.isEmpty());
		System.out.println("Top: " + stack.peek());
		System.out.println("Min: " + stack.min());
		stack.push(3);
		System.out.println("Top: " + stack.peek());
		System.out.println("Min: " + stack.min());
		stack.push(1);
		System.out.println("Top: " + stack.peek());
		System.out.println("Min: " + stack.min());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println("Top: " + stack.peek());
		System.out.println("Min: " + stack.min());
		System.out.println(stack.pop());
		System.out.println("Top: " + stack.peek());
		System.out.println("Min: " + stack.min());
		System.out.println(stack.pop());

	}
}

class MyStack<T extends Comparable<T>> {
	private static class StackNode<T> {
		private T data;
		private T min;
		private StackNode<T> next;
		
		public StackNode(T data, T min) {
			this.data = data;
			this.min = min;
		}
	}
	
	private StackNode<T> top;

	public T pop() {
		if (top == null) throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}

	public void push(T item) {
		StackNode<T> t = new StackNode<T>(item, top == null ? item : min(item, top.min));
		t.next = top;
		top = t;
	}

	public T peek() {
		if (top == null) throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public T min() {
		return top.min;
	}

	private T min(T a, T b) {
		return a.compareTo(b) > 0 ? b : a;
	}
	
}
