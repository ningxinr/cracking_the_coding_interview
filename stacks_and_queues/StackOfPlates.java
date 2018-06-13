import java.util.*;

class StackOfPlates {
	public static void main(String[] args) {
		SetOfStacks<Integer> setOfStacks = new SetOfStacks<Integer>(3);
		setOfStacks.push(1);
		setOfStacks.push(2);
		setOfStacks.push(3);
		setOfStacks.push(4);
		System.out.println(setOfStacks.popAt(0));
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
	}
}

class SetOfStacks<T> {
	private List<MyStack<T>> stacks;
	private MyStack<T> stack;
	private int maxSize, curSize;

	public SetOfStacks(int size) {
		maxSize = size;
		curSize = 0;
		stack = new MyStack<T>();
		stacks = new ArrayList<MyStack<T>>();
	}

	public T pop() {
		if (stack.isEmpty() && stacks.isEmpty()) throw new EmptyStackException();
	   	if (stack.isEmpty() || curSize == 0) {
			stack = stacks.remove(stacks.size() - 1);
			curSize = maxSize;
		}
		curSize--;
		return stack.pop();
	}

	public void push(T item) {
		if (curSize == maxSize) {
			stacks.add(stack);
			curSize = 0;
			stack = new MyStack<T>();
		}
		curSize++;
		stack.push(item);
	}

	public T popAt(int index) {
		if (index > (stacks.size() - 1)) throw new EmptyStackException();
		return stacks.get(index).pop();
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
