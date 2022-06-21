package adventDay7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PartOne {

	public static void main(String[] args) {
		// Read in the file
		ArrayList<Integer> numbers = readData("inputs/DAY7.txt");
		
		// Store all of the calculations
		ArrayList<Integer> results = new ArrayList<>();
		
		int fuel;
		for (int i = 0; i < numbers.size(); i++) {
			fuel = 0;
			int subtractNum = numbers.get(i);
			for (int n : numbers) {
				fuel = (n < subtractNum || n == subtractNum) 
						? fuel + (subtractNum - n) 
						: fuel + (n - subtractNum);
			}
			results.add(fuel);
		}
		
		// Get the lowest values from the results stored in the list
		int lowest = Integer.MAX_VALUE;
		for(int n : results) {
			lowest = (n < lowest) ? n : lowest;
		}
		
		// Print the lowest value in the results list
		System.out.println("LOWEST AMOUNT OF FUEL: " + lowest);
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
