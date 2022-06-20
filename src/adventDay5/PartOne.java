package adventDay5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PartOne {
	
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		
		// Read in the file
		TestData.populate("inputs/DAY5.txt");
		
		// Store all of the data in a ArrayList
		data = TestData.testData;
		
		// 2-D Matrix Grid
		int[][]arr = new int[1000][1000];

		for(int i = 0; i < data.size(); i++) {
			ArrayList<String> coordinates = data.get(i);
			String[] splitxy = coordinates.get(0).split(",");
			String[] splitxy2 = coordinates.get(1).split(",");
			
			int x1 = Integer.parseInt(splitxy[0]);
			int y1 = Integer.parseInt(splitxy[1]);
			
			int x2 = Integer.parseInt(splitxy2[0]);
			int y2 = Integer.parseInt(splitxy2[1]);
			
			/*
			 * horizontal line: y1 == y2
			 * vertical line: x1 == x2
			 * positive slope diagonal: y2 - y1 == x2 - x1
			 * negative slope diagonal: y2 - y1 == x1 - x2 
			 */
			
			// Initially, diagonal lines are not taken into consideration 
			if(!(y2 - y1 == x2 - x1) && !(y2 - y1 == x1 - x2)) {
				int min;
				int max;
				int constant;
				
				// Check for horizontal line
				if(y1 == y2) {
					constant = y1;
					min = (x1 < x2) ? x1 : x2;
					max = (x2 > x1) ? x2 : x1;
					for(int r = min; r < max+1 ; r++) {
						arr[constant][r]++;
					}
					
				}
				
				// Check for vertical line
				else if(x1 == x2) {
					min = (y1 > y2) ? y2 : y1;
					max = (y2 > y1) ? y2 : y1;
					constant = x1;
					for(int v = min; v < max+1 ; v++) {
						arr[v][constant]++;
					}
					
				}
				
			}
			
		}	// End for
		
//		print(arr);
		
		System.out.println("FINAL RESULT: " + printResult(arr));
		
	}
	
	static int printResult(int[][] arr) {
		int count = 0;
		for(int[] a : arr) {
			for(int b : a) {
				if(b >= 2) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	static void print(int[][] arr) {
		for(int[] a : arr) {
			for(int b : a) {
				System.out.print(b);
			}
			System.out.println("");
		}
		
	}
}
