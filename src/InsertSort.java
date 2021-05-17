import java.io.IOException;

/*
 * Insert element into its proper place among those already sorted
 * - efficient for small partially sorted array
 * O(n^2)
 */
public class InsertSort {
	
	public static void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
				int t = a[j];
				a[j] = a[j-1];
				a[j-1] = t;
			}
		}
	}

	// sort a part of the array from index lo to hi
	public static void sort(int[] a, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			for (int j = i; j > lo && a[j] < a[j-1]; j--) {
				int t = a[j];
				a[j] = a[j-1];
				a[j-1] = t;
			}
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
