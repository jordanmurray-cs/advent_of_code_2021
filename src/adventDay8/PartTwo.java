package adventDay8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PartTwo {

 	
	public static void main(String[] args) {
		// Read in the file
		Map<String, String> data = readData("inputs/DAY8.txt");
		
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
		
		String d1, d4;
		d1=d4="";
		ArrayList<Integer> finalValues = new ArrayList<>();
		
		for(int i = 0; i < keys.length; i++) {
			Map<String, String> mappedValues = new HashMap<>();
			String[] splitKey = keys[i].split("\\W+");
			String[] splitValues = values[i].split("\\W+");
			
			// Sorting the arrays by length of characters
			Arrays.sort(splitKey, (a, b)->Integer.compare(a.length(), b.length()));
			
			for(int j = 0; j < splitKey.length; j++) {
				String singleKey = splitKey[j];
				int size = singleKey.length();
				switch(singleKey.length()) {
					case 2: 
						d1 = singleKey;
						mappedValues.put("1", singleKey);
						break;
					case 3: 
						mappedValues.put("7", singleKey);
						break;
					case 4: 
						d4 = singleKey; 
						mappedValues.put("4", singleKey);
						break;
					case 7:  
						mappedValues.put("8", singleKey);
						break;					
				}

				// Three numbers of size 5 need evaluating
				if(size == 5) {
					// If element does not have the first letter of 1
					String tempFour = d4.replaceAll(String.valueOf(d1.charAt(0)), "").replaceAll(String.valueOf(d1.charAt(1)), "");
					
					// The letter three has all the letters of 1
					if(singleKey.contains(String.valueOf(d1.charAt(0))) && singleKey.contains(String.valueOf(d1.charAt(1)))) {
						// The element is three
						mappedValues.put("3", singleKey);
					}
					
					else if(singleKey.contains(tempFour.substring(0,1)) && singleKey.contains(tempFour.substring(1,2))) {
						// The element is five
						mappedValues.put("5", singleKey);
					} 
					
					else {
						mappedValues.put("2", singleKey);
					}
				}
				
				// Three numbers of size 6 need evaluating
				else if(size == 6) {
					char[] remove4 = d4.toCharArray();
					for(int r = 0; r < remove4.length; r++) {
						if(remove4[r] == d1.charAt(0) || remove4[r] == d1.charAt(1)) {
							remove4[r] = ' ';
						}
					}
					String d4Change = new String(remove4).replaceAll(" ", ""); 
					
					if(singleKey.contains(String.valueOf(d1.charAt(0))) && singleKey.contains(String.valueOf(d1.charAt(1)))) {
						if(singleKey.contains(String.valueOf(d4Change.charAt(0))) && singleKey.contains(String.valueOf(d4Change.charAt(1)))) {
							// The element is nine
							mappedValues.put("9", singleKey);
						} else {
							// This element is zero
							mappedValues.put("0", singleKey);
						}
					} else {
						// The element is six
						mappedValues.put("6", singleKey);	
					}
					
				}
			
			}
			
			String addNum = "";
			for(int v = 0; v < splitValues.length; v++) {
				char[] singleValue  = splitValues[v].toCharArray();
				Arrays.sort(singleValue);
				checkvalues:
				for(int p = 0; p < mappedValues.size(); p++) {
					String iterateValue = mappedValues.get(String.valueOf(p));
					char[] compare = iterateValue.toCharArray();
					Arrays.sort(compare);
					
					if(new String(compare).equals(new String(singleValue))) {
						addNum += String.valueOf(p);
						break checkvalues;
					}
				}
			}
			finalValues.add(Integer.parseInt(addNum));
		}
		
		System.out.println("RESULT: " + getTotal(finalValues));

	}
	
	static int getTotal(ArrayList<Integer> finalValues) {
		int total = 0;
		for(int n : finalValues) {
			total += n;
		}
		return total;
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
