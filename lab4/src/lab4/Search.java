package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Search {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //System.in is a standard input stream.
		System.out.print("Enter a string: ");
		String input = scan.nextLine();
		
		// search <pattern> <file>
		String[] split = input.split(" ");
		
		String pattern = split[1];
		File file = new File(split[2]);
		
			Scanner fileScanner;
			try {
				fileScanner = new Scanner(file);
				boolean present = false;
				
				while(fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					System.out.println(line);
					
					for(String word : line.split(" ")) {
						
						if(word.equals(pattern)) {
							present = true;
						}
						
						if(present) {
							System.out.println(line);
						}
						
						present = false;
						
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				throw new Error(e);
			}
			 
			
		//search katt text.txt
		
	}
}
