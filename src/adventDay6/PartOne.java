package adventDay6;

import java.util.ArrayList;
import java.util.Arrays;


public class PartOne {
	
	static int counter = 0;
	static int total = 0;
		
	
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		
		// Read in the file
		TestData.populate("inputs/DAY6.txt");
		
		// Store all of the data in a ArrayList
		numbers = TestData.testData;
		
		
		ArrayList<Long> fish = new ArrayList<Long>(Arrays.asList(0L,0L,0L,0L,0L,0L,0L,0L,0L));
		
		for(int num : numbers) {
			fish.set(num, (fish.get(num)+1));
		}
		
		
		int days = 256;
		for(int i = 0; i < days; i++) {
			boolean newFish = false;
			long newFishCount = 0;
			
			if(fish.get(0) > 0) {
				newFishCount = fish.get(0);
				newFish = true;
			}
			
			long temp = fish.get(0);
			fish.remove(0);
			fish.add(temp);
			
			if(newFish) {
				fish.set(6, fish.get(6) + newFishCount);
			}
		}
		
		long total = 0;
		for(long num : fish) {
			total += num;
		}
		
		System.out.println("ANSWER: " + total);
		
	}
}
