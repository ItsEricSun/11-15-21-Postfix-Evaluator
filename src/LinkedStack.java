import java.util.*;

public class LinkedStack<E> implements Stack<E> {
	private LinkedList<E> stack = new LinkedList<E>();

	public void push(E elem) {
		stack.addFirst(elem);
	}

	public E pop() {
		return stack.removeFirst();
	}

	public E peek() {
		return stack.peek();
	}

	public boolean isEmpty() {
		return stack.size() == 0;
	}

	public int size() {
		return stack.size();
	}
}
