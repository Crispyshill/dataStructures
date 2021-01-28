package arrayList;

public interface ArrayListInt<E> extends Iterable<E> {
	
	
	void add(E e);
	
	void add(int index, E e);
	
	E remove(int index);
	
	E remove(E e);
	
	void clear();
	
	E get(int index);
	
	int indexOf(E e);
	
	boolean isEmpty();
	
	int lastIndexOf(E e);
	
	E set(int index, E e);
	
	void trimToSize();
			
	
	
	
}
