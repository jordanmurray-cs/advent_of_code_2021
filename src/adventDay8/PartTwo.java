package adventDay8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class PartTwo {
 	
	public static void main(String[] args) {
		// Read in the file
		Map<String, String> data = readData("inputs/DAY8.txt");
		
		// Kind of over complicated the structure of the data, but onward & upwards i suppose
		
		// Retrieve all of the values from the map and store in a array
		Object[] arr = data.values().toArray();
		String[] values = new String[arr.length];
		
		Object[] arr1 = data.keySet().toArray();
		String[] keys = new String[arr1.length];
	
		
		int k = 0;
		for(Object a : arr) {
			values[k] = String.valueOf(a);
			k++;
		}
		
		k = 0;
		for(Object a : arr1) {
			keys[k] = String.valueOf(a);
			k++;
		}
		
		String d0, d1, d2, d3, d4, d5, d6, d7, d8, d9;
		d0=d1=d2=d3=d4=d5=d6=d7=d8=d9="";
		
		for(int i = 0; i < keys.length; i++) {
			String[] splitKey = keys[i].split("\\W+");
			
			for(int j = 0; j < splitKey.length; j++) {
				String singleKey = splitKey[j];
				int size = singleKey.length();
				switch(singleKey.length()) {
					case 2: d1 = singleKey; break;
					case 3: d7 = singleKey; break;
					case 4: d4 = singleKey; break;
					case 7: d8 = singleKey; break;					
				}
			}
			System.out.println("d0: " + d0);
			System.out.println("d1: " + d1);
			System.out.println("d2: " + d2);
			System.out.println("d3: " + d3);
			System.out.println("d4: " + d4);
			System.out.println("d5: " + d5);
			System.out.println("d6: " + d6);
			System.out.println("d7: " + d7);
			System.out.println("d8: " + d8);
			System.out.println("d9: " + d9);
		}
		
	}
	
	static void somemess() {
//		char[] k5, k2, k3, k9, k6, k0;
//		k5="cdfbe".toCharArray();k2="gcdfa".toCharArray();
//		k3="fbcad".toCharArray();k9="cefabd".toCharArray();
//		k6="cdfgeb".toCharArray();k0="cagedb".toCharArray();
//		Arrays.sort(k5);Arrays.sort(k2);Arrays.sort(k3);
//		Arrays.sort(k9); Arrays.sort(k6);Arrays.sort(k0);
		
		
		
		// ----------------------------------		
		// Decipher the signals
		char[] one  = "cdfbe".toCharArray();
		char[] two  = "cdfeb".toCharArray();
		
		Arrays.sort(one);
		Arrays.sort(two);
		
		if(Arrays.equals(one, two)) {
			System.out.println(true);
		}
		// ----------------------------------
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
