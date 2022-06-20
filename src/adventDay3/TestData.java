package adventDay3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestData {
	static ArrayList<String> testData = new ArrayList<>(); 

	public static void populateTestData(String fileName) {
	    try {
	        File myObj = new File(fileName);
	        Scanner myReader = new Scanner(myObj);
	        
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
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
	
}
