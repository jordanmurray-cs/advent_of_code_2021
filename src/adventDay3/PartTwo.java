package adventDay3;

import java.util.ArrayList;

public class PartTwo {
	static int bitindex = 0;	
	public static void main(String[] args) {
		TestData.populateTestData("inputs/DAY3.txt");
		
		for(int i = 0; i < 12; i++) {
			filter(i, countBits(i, "common", TestData.testData), TestData.testData);
		}
		int commonResult = Integer.parseInt(TestData.testData.get(0), 2);
		TestData.testData.remove(0);
		TestData.populateTestData("inputs/DAY3.txt");
		
	
		for(int i = 0; i < 12; i++) {
			filter(i, countBits(i, "least", TestData.testData), TestData.testData);
		}
		
		int leastResult = Integer.parseInt(TestData.testData.get(0), 2);
		System.out.println("least: "+ leastResult + ", common: " + commonResult);
		System.out.println("ANSWER: " + leastResult*commonResult);
		
		
		
		
	}	// End main
	
	public static void filter(int index, int character, ArrayList<String> list) {
		if(list.size() == 1) {
			return;
		} else {
			String parseChar = String.valueOf(character);
			
			for(int i = 0; i < list.size(); i++) {
				String parseIndex = String.valueOf(list.get(i).charAt(index));
				if(parseIndex.matches(parseChar)) {
					list.remove(i);
					filter(index, character, list);
				}
			}
		}
		
	}
	
	public static int countBits(int bitIndex, String leastorcommon, ArrayList<String> list) {
		int zero = 0; 
		int one = 0;
		for(int i = 0; i < list.size(); i++) {
			char mytest = list.get(i).charAt(bitIndex);
			if(mytest == '0') {
				zero++;
			} else {
				one++;
			}
		}
		
		switch(leastorcommon) {
		case "common":
			if(zero > one) {
				return 0;
			}
			
			else if(zero == one) {
				return 1;
			} else {
				return 1;
			} 
			
			
		case "least":
			if(zero < one) {
				return 0;
			}
			
			else if(zero == one) {
				return 0;
			} else {
				return 1;
			}
		}
		
		return -1;

	}
	
	
}
