import java.io.IOException;

/*
 * Divide the array recursively into two parts and
 * merge the sorted sub arrays back into one recursively.
 * Further improve the efficiency by using Insertion Sort
 * for small array, length = 10. O(nlogn)
 */
public class TimSort {
	private static int[] aux;

	public static void sort(int[] a) {
		aux = new int[a.length];
		sort(a, 0, a.length-1);
	}
	
	private static void sort(int[] a, int lo, int hi) {
		// Use effective insertion sort for short sub-array
		int cutOff = 10;
		if (hi <= lo + cutOff -1) {
			InsertSort.sort(a, lo, hi);
			return;
		}
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);		// Sort left half
		sort(a, mid+1, hi);		// Sort right half
		if (a[mid+1] >= a[mid]) return;  // Skip the merge for ordered arrays
		merge(a, lo, mid, hi);
	}
	
	private static void merge(int[] a, int lo, int mid, int hi) {
		int i = lo;			// pointer to the 1st available element of left half
		int j = mid+1;			// pointer to the 2nd available element of right half
		
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) a[k] = aux[j++];		// left part exhausted
			else if (j > hi) a[k] = aux[i++];	// right part exhausted
			else if (aux[j] < aux[i]) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		String file = "Random_Num.txt";
		int[] num = LoadData.load(file);
		sort(num);
		for (int i : num) {
			System.out.println(i);
		}
	}

}
