package tree;

public class recursionSearch {
	
	
	/**
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int linearSearch(int[] arr, Integer target) {
		return linearSearch(arr, target, 0);
	}
	
	
	/**
	 * @param arr
	 * @param target
	 * @param position
	 * @return
	 */
	public static int linearSearch(int[] arr, Integer target, int position) {
		if(position == arr.length) {
			return -1;
		}
		else {
			if(target.equals(arr[position])) {
				return arr[position];
			}
			else {
				return linearSearch(arr, target, position+1);
			}
		}
	}
	
	public static int binarySearch(int[] arr, Comparable target) {
		return binarySearch(arr, target, 0, arr.length-1);
	}
	
	/**
	 * @param arr
	 * @param target
	 * @param first
	 * @param last
	 * @return
	 */
	public static int binarySearch(int[] arr, Comparable target, int first, int last) {
		if(first > last) {
			return -1;
		}
		else {
			int middle = (first+last)/2;
			int res = target.compareTo(arr[middle]);
			if(res == 0) {
				return middle;
			}
			else if(res > 0) {
				return binarySearch(arr, target, middle+1, last);
			}
			else{
				return binarySearch(arr, target, first, middle-1);
			}
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] nums = {1,2,3,4,5,5,6,9};
		System.out.println(linearSearch(nums, 5, 0));
		System.out.println(binarySearch(nums, 4));

	}
	
}
