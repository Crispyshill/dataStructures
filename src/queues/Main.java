package queues;

public class Main {
	public static void main(String[] args) {
		ShLinkedListQueue<Integer> q = new ShLinkedListQueue<>();
		for(int i = 0; i < 10; i++) {
			q.offer(i);
		}
		
		for(int i = 0; i < 9; i++) {
			System.out.println(q.poll());
		}
		System.out.println(q.getSize());
	}
}
