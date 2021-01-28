package queues;

public interface QueueInt<E> {
	
	
	boolean add(E e);
	
	boolean offer(E e);
		
	E element();
		
	E peek();
	
	E poll();
	
	E remove();
	
}
