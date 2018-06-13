import java.util.*;
import java.util.Random.*;

class SortStack {
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<Integer>();
		System.out.println(stack.isEmpty());
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			stack.push(rand.nextInt(20));
			System.out.println("Top: " + stack.peek());
		}
		System.out.println(stack.isEmpty());
		stack.sort();
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		System.out.println(stack.isEmpty());
	}
}

class MyStack<T extends Comparable<T>> {
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
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
		StackNode<T> t = new StackNode<T>(item);
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

	public void sort() {
		if (top != null && top.next != null) {
			MyStack<T> tempStack = new MyStack<T>();
			T temp;

			while (!this.isEmpty()) {
				temp = this.pop();
				while (!tempStack.isEmpty() && temp.compareTo(tempStack.peek()) < 0) {
					this.push(tempStack.pop());
				}
				tempStack.push(temp);
			}
		
			while (!tempStack.isEmpty()) {
				this.push(tempStack.pop());
			}
		}



	}
}
