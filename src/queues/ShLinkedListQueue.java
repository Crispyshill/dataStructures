package queues;

import java.util.NoSuchElementException;

public class ShLinkedListQueue<E> implements QueueInt<E> {
	
	Node<E> front = null;
	Node<E> rear = null;
	private int size = 0;
	
	private class Node<E>{
		E data;
		Node<E> next;
		public Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}

	@Override
	public boolean add(E e) {
		if(size == 0) {
			front = new Node(e, null);
			rear = front;
		}
		else {
			Node<E> temp = new Node(e, null);
			rear.next = temp;
			rear = temp;
		}
		size++;
		return true;
	}

	@Override
	public boolean offer(Object e) {
		if(size == 0) {
			front = new Node(e, null);
			rear = front;
		}
		else {
			Node<E> temp = new Node(e, null);
			rear.next = temp;
			rear = temp;
		}
		size++;
		return true;
	}

	@Override
	public E element() {
		if(size==0) {
			return null;
		}
		else {
			return front.data;
		}
	}

	@Override
	public E peek() {
		if(size==0) {
			return null;
		}
		else {
			return front.data;
		}
	}

	@Override
	public E poll() {
		if(size == 0) {
			throw new NoSuchElementException();
		}
		else {
		E temp = front.data;
		front = front.next;
		size--;
		return temp;
		}
		
	}

	@Override
	public E remove() {
		if(size == 0) {
			throw new NoSuchElementException();
		}
		else {
		E temp = front.data;
		front = front.next;
		size--;
		return temp;
		}
	}
	public int getSize() {
		return size;
	}
	
}
