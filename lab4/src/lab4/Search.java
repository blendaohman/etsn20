package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Search {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // System.in is a standard input stream.

		System.out.print("Enter search as search <pattern> <file>: ");

		String input = scan.nextLine();
		scan.close();

		String[] split = input.split(" ");
		String pattern = split[1];

		/* Detta är fult men pathen är fucked */
		File file = new File(System.getProperty("user.dir") + "/src/lab4/" + split[2]);

		try {

			Scanner fileScanner = new Scanner(file);
			boolean present = false;

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();

				for (String word : line.split(" ")) {

					if (word.equals(pattern)) {
						present = true;
					}
				}

				if (present) {
					System.out.println(line);
					present = false;
				}
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			throw new Error(e);
		}

		// search katt text.txt

	}
}
