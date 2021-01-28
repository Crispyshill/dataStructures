package arrayList;

import java.util.Arrays;
import java.util.Iterator;

public class ShArrayList<E> implements ArrayListInt<E> {
	
	private final int INITIAL_CAPACITY = 10;
	private int capacity = INITIAL_CAPACITY;
	private int size = 0;
	private E[] data = (E[]) new Object[INITIAL_CAPACITY];
	

	@Override
	public Iterator<E> iterator() {
		
		return new Iterator<E>() {

			private int index = 0;

			
			@Override
			public boolean hasNext() {
				return (index < size);
			}

			@Override
			public E next() {
				return data[index++];
			}
			
		};
	}

	@Override
	public void add(E e) {
		if(size == capacity) {
			refactor();
		}
			data[size] = e;
			size++;
	}

	private void refactor() {
		data = Arrays.copyOf(data, capacity*2);
		capacity = capacity*2;
		
	}

	@Override
	public void add(int index, E e) {
		if(size == capacity) {
			refactor();
		}
		if(index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		E temp = data[index];
		for(int i = index+1; i < size; i++) {
			data[i] = data[i-1];
		}
		data[index] = e;
		size++;
	}

	@Override
	public E remove(int index) {
		if(index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		E temp = data[index];
		for(int i = index; i < size-1; i++) {
			data[i] = data[i+1];
		}
		size--;
		return temp;
	}

	@Override
	public E remove(E e) {
		return remove(indexOf(e));
	}

	@Override
	public void clear() {
		data = (E[]) new Object[capacity]; 
		size = 0;
	}

	@Override
	public E get(int index) {
		if(index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return data[index];
	}

	@Override
	public int indexOf(E e) {
		int index = 0;
		for(E item : data) {
			if(item.equals(e)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int lastIndexOf(E e) {
		int index = 0;
		int indexOfItem = -1;
		for(E item : data) {
			if(item.equals(e)) {
				indexOfItem = index;
			}
			index++;
		}
		return indexOfItem;
	}

	@Override
	public E set(int index, E e) {
		if(index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E temp = data[index];
		data[index] = e;
		return temp;
	}

	@Override
	public void trimToSize() {
		data = Arrays.copyOf(data, size);
		capacity = size;
	}
	
	public int size() {
		return size;
	}

}
