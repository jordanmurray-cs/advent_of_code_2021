package adventDay5;

import java.io.*;
import java.util.ArrayList;


public class TestData {

	static ArrayList<ArrayList<String>> testData = new ArrayList<>();
	
	public static void populate(String fileName) {
	        BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(fileName));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        ArrayList <String> nums = new ArrayList<>();
	        String line;
			try {
				while ((line = br.readLine()) != null) {
					String[] test = line.split(" -> ");
					ArrayList<String> addThis = new ArrayList<>();
					
					for(String word : test) {
						addThis.add(word);
					}
					testData.add(addThis);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      System.out.println("*data entered*");

	}
	
	
	public static void testPrintOut() {
		for(int i = 0; i < testData.size(); i++) {
			System.out.println(testData.get(i));
		}
		System.out.println("array size: " + testData.size());
	}
	
}
