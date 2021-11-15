import java.util.*;

public class LinkedStack<E> implements Stack<E> {
	private List<E> stackk = new LinkedList<E>();

	@Override
	public void push(E elem) {
		stack.addFirst(elem);
	}

	@Override
	public E pop() {
		return stack.removeFirst();
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


	
	

}
