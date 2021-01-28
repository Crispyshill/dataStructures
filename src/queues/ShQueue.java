package queues;

import java.util.NoSuchElementException;

public class ShQueue<E> implements QueueInt<E>{	
	

	private int front;
	private int rear;
	private int size;
	private int capacity;
	private static final int INITIAL_CAPACITY = 10;
	private E[] data;
	
	public ShQueue() {
		capacity = INITIAL_CAPACITY;
		data = (E[])new Object[capacity];
		front = 0;
		rear = capacity-1;
		size = 0;
	}
	
	
	@Override
	public E element() {
		if(size==0) {
			throw new NoSuchElementException();
		}
		else {
			return data[front];
		}
	}


	@Override
	public E peek() {
		if(size==0) {
			return null;
		}
		else {
			return data[front];
		}
	}

	@Override
	public E poll() {
		if(size==0) {
			return null;
		}
		else {
			E hand  = data[front];
			front = (front+1)%capacity;
			size--;
			return hand;
		}
	}

	@Override
	public E remove() {
		if(size==0) {
			throw new NoSuchElementException();
		}
		return null;
	}

	@Override
	public boolean add(E e) {
		if(size==capacity) {
			reallocate();
		}
		size++;
		rear = (rear+1)%capacity;	// as long as size is less than capacity
		data[rear] = e;
		return true;
	}

	private void reallocate() {
		// TODO increase array capacity
		int newCapacity = 2*capacity;
		E[] newData = (E[]) new Object[newCapacity];
		int i = front;
		for(int j = 0; j < size; j++) {
			newData[j] = data[i];
			i = (i+1%capacity);
		}
		front = 0;
		rear = size-1;
		capacity = newCapacity;
		data = newData;
	}


	@Override
	public boolean offer(E e) {
		if(size==capacity) {
			reallocate();
		}
		
		if(size == 0) {
			data[size++] = e;
		}
		
		else {
			for(int i = size-1; i >= 0; i--) {
				if((int)e > (int)data[i]) {
					data[i+1] = data[i];
					
				}
				else {
					data[i+1] = e;
					break;
				}
			}
		}
		
		size++;
		return true;
	}
	
	public int getSize() {
		return size;
	}
	
	
	
}
