package adventDay10;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
public class PartOneTry3 {
	static int total = 0;

	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader("inputs/DAY10.txt"));
			String line;

			int points = 0;
			List<BigInteger> bigInts = new ArrayList<>();
			while((line = br.readLine()) != null) {
				boolean enable = true;
				char[] arr = line.toCharArray();
				Deque<Character> deque = new ArrayDeque<>();
				
				char head = ' ';
				thisfor: 
				for(char c : arr) {
					if(!deque.isEmpty()) {
						 head = deque.peek();
					} 
						 
					switch(c) {
					case '{':
						deque.push(c);
						break;
					case '(':
						deque.push(c);
						break;
					case '<':
						deque.push(c);
						break;
					case '[':
						deque.push(c);
						break;
						
					case '}':
						if(!(head == '{')) {
							points += 1197;
							enable = false;
							break thisfor;
						}
						deque.pop();
						break;
					case '>':
						if(!(head == '<')) {
							points += 25137;
							enable = false;
							break thisfor;
						}
						deque.pop();
						break;
					case ')':
						if(!(head == '(')) {
							points += 3;
							enable = false;
							break thisfor;
						}
						deque.pop();
						break;
					case ']':
						if(!(head == '[')) {
							points += 57;
							enable = false;
							break thisfor;
						}
						deque.pop();
						break;
						
					}
					
				}
				
				
				if (enable) {
					BigInteger score = BigInteger.ZERO;
					for (char character : deque) {
						score = score.multiply(new BigInteger("5"));
						switch (character) {
						case '(':
							score = score.add(new BigInteger("1"));
							break;
						case '[':
							score = score.add(new BigInteger("2"));
							break;
						case '{':
							score = score.add(new BigInteger("3"));
							break;
						case '<':
							score = score.add(new BigInteger("4"));
							break;

						}
					}
					bigInts.add(score);
				}
			
				
				
			}	// End while
			
			Collections.sort(bigInts);
			System.out.println("Part one answer: " + points);
			System.out.println("Part two answer: " + bigInts.get((int) Math.floor(bigInts.size() / 2)));
			
			
			

			
			
			
			

		} catch(Exception e) {
			System.out.println(e);
		}
			
				
	}	// End main
	
}	// End class