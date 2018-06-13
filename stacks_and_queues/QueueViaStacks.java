import java.util.*;

class QueueViaStacks {
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		System.out.println(queue.isEmpty());
		queue.add(2);
		System.out.println(queue.isEmpty());
		System.out.println("Top: " + queue.peek());
		queue.add(3);
		System.out.println("Top: " + queue.peek());
		queue.add(1);
		System.out.println("Top: " + queue.peek());
		System.out.println(queue.isEmpty());
		System.out.println(queue.remove());
		System.out.println("Top: " + queue.peek());
		System.out.println(queue.remove());
		System.out.println("Top: " + queue.peek());
		System.out.println(queue.remove());

	}
}

class MyQueue<T> {
	private MyStack<T> myStackIn, myStackOut;

	public MyQueue() {
		myStackIn = new MyStack<T>();
		myStackOut = new MyStack<T>();
	}

	public void add(T item) {
		while (!myStackOut.isEmpty()) {
			myStackIn.push(myStackOut.pop());
		}
		myStackOut.push(item);
		while(!myStackIn.isEmpty()) {
			myStackOut.push(myStackIn.pop());
		}
	}

	public T remove() {
		return myStackOut.pop();
	}

	public T peek() {
		return myStackOut.peek();
	}

	public boolean isEmpty() {
		return myStackOut.isEmpty();
	}
}

class MyStack<T> {
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
}
