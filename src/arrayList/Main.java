package arrayList;

public class Main {
	public static void main(String[] args) {
		ShArrayList<Integer> arr = new ShArrayList<Integer>();
		arr.add(5);
		arr.add(8);
		arr.add(36);
		for(int i : arr) {
			System.out.println(i);
		}
		System.out.println(arr.size());
		arr.remove(8);
		
	}
}
