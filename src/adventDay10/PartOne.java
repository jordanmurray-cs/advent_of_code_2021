package adventDay10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PartOne {

	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader("inputs/DAY10EX2.txt"));
			String line;
			ArrayList<String> resultingCharacter = new ArrayList<>();
			
			while((line = br.readLine()) != null) {
				String[] arr = isLineCorrupted(line).trim().split("");
				String subLine = "";
//				System.out.println(isLineCorrupted(line));
				
				outterfor:
				for(int i = 0; i < arr.length - 1; i++) {
					String opening = arr[i];
					
					for(int k = i; k < arr.length - 1; k++) {
						boolean foundMatch = false;
						String next = arr[k + 1];
						
						checkopening:
						switch(opening) {
						case "(":
							if(next.equals(")")) {
								foundMatch = true;
								break checkopening;
							}
						case "{":
							if(next.equals("}")) {
								foundMatch = true;
								break checkopening;
							}
						case "<":
							if(next.equals(">")) {
								foundMatch = true;
								break checkopening;
							}
						case "[":
							if(next.equals("]")) {
								foundMatch = true;
								break checkopening;
							}
						}
						
						if(foundMatch) {
//							System.out.println(opening + ", " +  next);
//							System.out.println(i + ", " + k);
							for(int q = i; q <= k; q++) {
								subLine += arr[q];
							}
							break outterfor;

						}
					}
				}	// End for
				System.out.println(subLine);
			}						
		} catch(Exception e) {
			System.out.println(e);
		}
			
				
	}	// End main
	
	
	private static String isLineCorrupted(String line) {
		String[] arr = line.trim().split("");
		
		for (int i = 0; i < line.length() - 2; i++) {
			String opening = arr[i];
			String next = arr[i + 1];
		
			boolean foundMatch = false;

			switch (opening) {
			case "(":
				if (next.equals(")")) {
					foundMatch = true;
				}
			case "{":
				if (next.equals("}")) {
					foundMatch = true;
				}
			case "<":
				if (next.equals(">")) {
					foundMatch = true;
				}
			case "[":
				if (next.equals("]")) {
					foundMatch = true;
				}
			}

			if (foundMatch) {
				arr[i] = "";
				arr[i + 1] = "";
			}
		} 
		return String.join("", arr);
	}
	
	private static boolean checkMatch(int opening, int nextElement, String[] arr) {
		String next = arr[nextElement];
		switch(arr[opening]) {
		case "(":
			if(next.equals(")") && !arr[nextElement - 1].equals("(")) {
				return true;
			}
		case "{":
			if(next.equals("}") && !arr[nextElement - 1].equals("{")) {
				return true;
			}
		case "<":
			if(next.equals(">") && !arr[nextElement - 1].equals("<")) {
				return true;
			}
		case "[":
			if(next.equals("]") && !arr[nextElement - 1].equals("[")) {
				return true;
			}
		}
		
		return false;
	}
	

}	// End class