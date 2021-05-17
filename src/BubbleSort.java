import java.io.IOException;

/* Smaller value bubble up the array
 * compare all elements to the first one
 * swap them if the other element is greater than the first one
 * once reach the end of the array, proceed the target to the second one...
 * O(0.5n^2)-compares + O(n)-exchanges -> O(n^2)
 */
 
public class BubbleSort {

	public static void main(String[] args) throws IOException {
		String file = "Random_Num.txt";
		int[] num = LoadData.load(file);
		sort(num);
		for (int i : num) {
			System.out.println(i);
		}
	}
	
	public static void sort(int[] data) {
		if (data == null || data.length == 1) return;
		
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] > data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}
}
