import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* A helper class to load a list of random numbers in a text file into an array,
 * and return the array.
*/
public class LoadData {

	public static int[] load(String file) throws IOException {
		FileInputStream fis = null;
		byte[] buffer = null;
		
		try {
			fis = new FileInputStream(file);
			buffer = new byte[fis.available()];
			fis.read(buffer);
		} catch (FileNotFoundException e) {
			System.out.println("The file is not available");
		} finally {
			fis.close();
		}
		String s = new String(buffer);
		String ss = s.trim().replaceAll(" ", "").replaceAll("\r", "");
		String[] str = ss.split("\n");
		int[] num = new int[str.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(str[i]);
		}
		return num;
	}
	
	public static void main(String[] args) throws IOException {
		String file = "Random_Num.txt";
		int[] num = load(file);
		for (int number : num) {
			System.out.println(number);
		}
	}
}
