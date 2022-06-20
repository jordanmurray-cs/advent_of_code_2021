package adventDay7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PartOne {
	
	public static void main(String[] args) {
		// Read in the file
		ArrayList<Integer> numbers = readData("inputs/DAY7.txt");
		
		int lowest = Integer.MAX_VALUE;
		
		int total = 0;
		for(int i = 0; i < numbers.size(); i++) {
			int element = numbers.get(i);
			total = 0;
			
			for(int j = 0; j < numbers.size(); j++) {
				int sum = element - numbers.get(j);
				total += sum;
			}
			
			
			lowest = (total < lowest && total != 0) ? total : lowest;
			System.out.println(total);
		}
		
		System.out.println(lowest);
		
		
				
		
	}
	
	
	
	static ArrayList<Integer> readData(String fileName) {
		ArrayList<Integer> arr = new ArrayList<>();
		try {
			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
				String line = br.readLine();
				
				String[] allNums = line.split("\\D+");
				
				for(String num : allNums) {
					arr.add(Integer.parseInt(num));
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arr;
	}

	
}
