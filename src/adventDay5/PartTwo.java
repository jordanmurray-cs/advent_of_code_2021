package adventDay5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PartTwo {
	
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
			
			/*
			 * horizontal line: y1 == y2
			 * vertical line: x1 == x2
			 * positive slope diagonal: y2 - y1 == x2 - x1
			 * negative slope diagonal: y2 - y1 == x1 - x2 
			 */
			
			// Temporary holder variables for x1 & y1
			int tempX1 = x1, tempY1 = y1;
			
			if((y2 - y1 == x2 - x1) || (y2 - y1 == x1 - x2)) {
				/*
				 * Mark the initial coordinate on the board
				 * ----------------------------------------
				 * Values change respectively once in while loop
				 */
				
				arr[tempY1][tempX1]++;
				
				/*
				 * Increasing only x1 and x2 values
				 * While runs until x1 matches x2 values, same with y1, y2
				 */
				
				while(tempX1 != x2 || tempY1 != y2) {
					// x1 gets decreased or increased in respect to conditional statement
					if(tempX1 > x2) {
						tempX1--;
					} else {
						tempX1++;
					}
					
					// Same process is repeated for y1
					if(tempY1 < y2 ) {
						tempY1++;
					} else {
						tempY1--;
					}
					
					// Mark the board with the new x1, y1 values
					arr[tempY1][tempX1]++;
				}


			} 
			
		}	
		
		// Print the result to console 
		System.out.println("RESULT: " + printResult(arr));

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
