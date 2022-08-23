package adventDay10;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class PartOneTry2 {
	static int total = 0;

	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader("inputs/DAY10EX2.txt"));
			String line;

			int points = 0;
			while((line = br.readLine()) != null) {
				List<Character> characters = new ArrayList<>();
				char[] arr = line.toCharArray();				
				
				for(char c : arr) {
					characters.add((Character) c);
				}
		
//				System.out.println("before: ");
//				System.out.println(characters);
				
				for(int i = 0; i < characters.size() - 2; i++) {
					Character current = characters.get(i);
					Character after = characters.get(i + 1);
					boolean remove = false;
					
					if(current == '{' && after == '}') {
						remove = true;
					}
					
					if(current == '[' && after == ']') {
						remove = true;						
					}
					
					if(current == '<' && after == '>') {
						remove = true;
					}
					
					if(current == '(' && after == ')') {
						remove = true;
					}
					
					if(remove) {
//						characters.remove(i + 1);
//						characters.remove(i);
						removeElements(characters);
						
					}
					
				}
				
//				System.out.println("after: ");
				System.out.println(characters);
				
				
				thisfor: 
				for(Character a : characters) {
					switch(a) {
					case '}':
						points += 1197;
//						System.out.println("1197");
						break thisfor;
					case ')':
						points += 3;
//						System.out.println("3");
						break thisfor;
					case '>':
						points += 25137;
//						System.out.println("25137");
						break thisfor;
					case ']':
						points += 57;
//						System.out.println("57");
						break thisfor;
						
					}
				}

				
//				System.out.println(characters);
				
			
				
			}	// End while
			
			System.out.println(points);
			
			
			

		} catch(Exception e) {
			System.out.println(e);
		}
			
				
	}	// End main
	
	public static void removeElements(List<Character> characters ) {
		all:
		for(int i = 0; i < characters.size() - 1; i++) {
			boolean found = false;
			char opening = characters.get(i);
			for(int j = i; j < characters.size(); j++) {
				char closing = characters.get(j);
				if(opening== '{' && closing == '}') {
					found = true;
				}
				
				if(opening== '[' && closing == ']') {
					found = true;
				}
				
				if(opening== '<' && closing == '>') {
					found = true;
				}
				
				if(opening== '(' && closing == ')') {
					found = true;
				}
				
				if(found) {
					characters.remove(i);
					characters.remove(i);
					
					removeElements(characters);
					break all;
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
}	// End class