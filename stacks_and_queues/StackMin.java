import java.util.*;

class StackMin {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}

class MyStack<T> {
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
		StackNode<T> t = new StackNode<T>(item, min(item, top.min));
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

	private T min(T a, T b) {
		return a > b ? b : a;
	}
	
}
