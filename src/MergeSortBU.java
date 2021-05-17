import java.io.IOException;

/*
 * Merge Sort Bottom Up
 * Start sorting with 2 elements and merge back into one recursively
 * O(nlogn)
 */
public class MergeSortBU {
	private static int[] aux;

	public static void sort(int[] a) {
		aux = new int[a.length];
		int n = a.length;
		
    		for (int len = 1; len < n; len *=2) {
			for (int i = 0; i < n - len; i += len*2) {
				merge(a, i, i + len - 1, Math.min(i + len + len - 1, n-1));
			}
		}		
	}
	
	public static void merge(int[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid+1;
		
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
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
