package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.*;

public class Search {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // System.in is a standard input stream.

		System.out.print("Enter search as search <pattern> <file>: ");

		String input = scan.nextLine();
		scan.close();

		String[] split = input.split(" ");
		String pattern = split[1];


		Path path = Path.of("lab4/src/lab4/");
		File file = new File(path + "/" + split[2]);
		//File text = new File("C:/Users/marie/Skola/ProgTest/etsn20/lab4/src/lab4/text.txt");
		scan.close();	
			try {
				Scanner fileScanner = new Scanner(file);
				boolean present = false;
				
				while(fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					//System.out.println(line);
					
					for(String word : line.split(" ")) {
						
						if(word.equals(pattern)) {
							present = true;
						}
					}
					if(present) {
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
