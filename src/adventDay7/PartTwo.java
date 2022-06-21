package adventDay7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PartTwo {

	public static void main(String[] args) {
		// Read in the file
		ArrayList<Integer> numbers = readData("inputs/DAY7.txt");
		
		// Store all of the calculations
		ArrayList<Integer> results = new ArrayList<>();
		
		// Get the total num of all of the numbers in the data set
		double total = numbers.stream().mapToDouble(a -> a).sum();
		
		// Get the size of the list
		double size = (double) numbers.size();
		
		double subtractNum = Math.ceil(total / size);
		
		int addFuel = 0;
		int element;
		int count = 0;
		
		for (int n = 0; n < numbers.size(); n++) {
			element = numbers.get(n);
			while((element+1) != subtractNum) {
				count++;
				if(element < subtractNum) {
					addFuel += count;
					element++;
				} 

				else {
					addFuel += count;
					element--;
				} 
			}
			results.add(addFuel);
			addFuel = 0;
			count = 0;
		}
		
		// Print the lowest value in the results list
		System.out.println("LOWEST AMOUNT OF FUEL: " + results.stream().mapToInt(a -> a).sum());
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
