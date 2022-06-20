package adventDay1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestData {
	static ArrayList<Integer> testData = new ArrayList<>(); 

	public static void populateTestData(String fileName) {
	    try {
	        File myObj = new File(fileName);
	        Scanner myReader = new Scanner(myObj);
	        
	        while (myReader.hasNextLine()) {
	          int data = Integer.parseInt(myReader.nextLine());
	          testData.add(data);
	        }
	        
	        System.out.println("*data entered*");
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}
	
	public static void testPrintOut() {
		for(int i = 0; i < testData.size(); i++) {
			System.out.println(testData.get(i));
		}
	}
	
	public static void challege1() {
		int increased = 0;
		for(int i = 1; i < TestData.testData.size(); i++) {
			if(TestData.testData.get(i) > TestData.testData.get(i - 1)) {
				increased++;
			}
		}
		
		System.out.println("INCREASED AMOUNT: " + increased);
	}
}
