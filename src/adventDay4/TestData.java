package adventDay4;

import java.io.*;
import java.util.ArrayList;


public class TestData {

	static ArrayList<ArrayList<String>> testData = new ArrayList<>();
	
	public static void populateBingoBoard(String fileName) {
	    try {
	    	int counter = 0;
	        BufferedReader br = new BufferedReader(new FileReader(fileName));
	        
	        ArrayList <String> addIntArr = new ArrayList<>();
	        String line;
			try {
				while ((line = br.readLine()) != null) {
					if (counter % 25 == 0) {
						testData.add(addIntArr);
						counter = 0;
						addIntArr = new ArrayList<>();
					}

					if (!line.isBlank()) {
						ArrayList<String> arr = new ArrayList<>();
						String allNums[] = line.split(" ");
						
						for(String n : allNums) {
							try {
								Integer.parseInt(n);
								arr.add(n);
							} catch(Exception e) {}
						}

						for (int i = 0; i < arr.size(); i++) {
							addIntArr.add(arr.get(i));
							counter++;
						}
					}
				}
				testData.add(addIntArr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	// End while
			
			for(int i = 1; i < testData.size(); i++) {
				if(testData.get(i).isEmpty()) {
					testData.remove(i);
				}
			}
			
			// The first board that is populated is an empty board
			testData.remove(0);
			
	        
	        
	        
	        System.out.println("*data entered*");
	        
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }

	}
	
	public static String[] callNumber() {
		try {
			try (BufferedReader reader = new BufferedReader(new FileReader("inputs/DAY4.1.txt"))) {
				return reader.readLine().split("\\D+");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static void testPrintOut() {
		for(int i = 0; i < testData.size(); i++) {
			System.out.println(testData.get(i));
		}
		System.out.println("array size: " + testData.size());
	}
	
}
