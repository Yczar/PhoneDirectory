import java.io.IOException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author TILDA
 *
 */
public class MainClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		PhoneDirectory direc = new PhoneDirectory();
		try (Scanner sc = new Scanner(System.in)) {
			while(true) {
				if(!direc.getUserInput()) return;
			}
		}
	}
}
