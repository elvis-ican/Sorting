import java.io.IOException;

/*
 * Simple extension of insertion sort that gains speed by allowing exchanges
 * of array entries that are far apart
 */
public class ShellSort {

	public static void sort(int[] a) {
		int n = a.length;
		int h = 1;
		while (h < n/3) h = h*3 +1; // 1, 4, 13, 40, 121, 364, 1093, ...
		while (h >= 1) {
			for (int i = h; i < n; i++) {
				// Insert a[j] among a[i-h], a[i-2*h], a[i-3*h]...
				for (int j = i; j >= h && a[j] < a[j-h]; j -= h) {
					int t = a[j];
					a[j] = a[j-h];
					a[j-h] = t;
				}
			}
			h = h/3;
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
