package adventDay6;

import java.io.*;
import java.util.ArrayList;


public class TestData {

	static ArrayList<Integer> testData = new ArrayList<>();
	
	public static void populate(String fileName) {
	        BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(fileName));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        String line;
			try {
				line = br.readLine(); 
				String[] allNums = line.split("\\D+");
				for(String num : allNums) {
					testData.add(Integer.parseInt(num));
				}
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      System.out.println("*data entered*");

	}	
}
