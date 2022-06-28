package adventDay8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class PartOne {

	// Problem: HOW MANY TIMES DO 1, 4, 7 or 8 APPEAR? 
	
	public static void main(String[] args) {
		// Read in the file
		Map<String, String> data = readData("inputs/DAY8.txt");
		
		// Kind of over complicated the structure of the data, but onward & upwards i suppose
		
		// Retrieve all of the values from the map and store in a array
		Object[] arr = data.values().toArray();
		String[] values = new String[arr.length];
		int k = 0;
		for(Object a : arr) {
			values[k] = String.valueOf(a);
			k++;
		}
		
		// The digits of 1,4,7,8 all have lengths of 2,4,3,7 respectivelly
		int count = 0;
		for(int i = 0; i < values.length; i++) {
			String[] breakup = values[i].split("\\W+");
			for(int j = 0; j < breakup.length; j++) {
				int len =  breakup[j].length();
				if(len == 2 || len == 4 || len == 3 || len == 7) {
					count++;
				}
			}
		}
		
		System.out.println("RESULT: " + count);
		
		
		
		
		
		
		
		
		
		
		
	}
	
	static void print(Map<String, String> data) {
		for (Map.Entry entry : data.entrySet()) {
		    System.out.println("key[" + entry.getKey() + "], value[" + entry.getValue() + "]");
		}
	}
	
	
	static Map<String, String> readData(String fileName) {
		// LinkedHashMap maintains order of insertion
		Map<String, String> map = new LinkedHashMap<>();
		try {
			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
				
				String line;
				while ((line = br.readLine()) != null) {
					boolean keyMade = false;
					String[] test = line.split(" ");
					String key  = "";
					String value = "";
					
					for(String n : test) {
						if(n.matches("\\w+") && keyMade == false) {
							key += n + " ";
						} else {
							keyMade = true;							
						}
						
						if(n.matches("\\w+") && keyMade == true) {
							value += n + " ";
						}
					}
					
					map.put(key, value);
				}
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
}
