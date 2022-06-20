package adventDay4;

import java.util.ArrayList;

public class PartOne {
	
	static ArrayList<ArrayList<String>> Boards = TestData.testData;
	static ArrayList<Integer> callNumber = new ArrayList<>();
	static ArrayList<String> winningBoard = new ArrayList<>();
	static int lastNumCalled = 0;
	static String mark = "XX";
	
	public static void main(String[] args) {
		TestData.populateBingoBoard("inputs/DAY4.txt");

		// Add the call number elements 
		String[] getCallNumbers = TestData.callNumber();
		
		// Parse the call numbers to Integers and store in ArrayList
		for(int i = 0; i < getCallNumbers.length; i++) {
			callNumber.add(Integer.parseInt(getCallNumbers[i]));
		}		
		
	
		if(runBingo()) {
			System.out.println("WINNING BOARD: \n" + winningBoard + "\n");
			calculate(winningBoard, lastNumCalled);			
		} else {
			System.out.println("No bingo found");
		}					
		
	}
	
	static boolean runBingo(){
		for (int k = 0; k < callNumber.size(); k++) { 
			int callNum = callNumber.get(k);
			
			// Marks the board with the given call number
			markNumbers(callNum);
			
			// Check for a bingo
			if(checkBingo()) {
				lastNumCalled = callNum;
				return true;
			}
			
		}	// End for
		
		return false;
	}
	
	static boolean checkBingo() {
		for (int j = 0; j < Boards.size(); j++) {
			// Each single board on every iteration
			ArrayList<String> board = Boards.get(j);
			
			if(checkColumn(board) || checkRow(board)) {
				winningBoard = board;
				return true;
			} 
		} 
		
		return false;
		
	}
	
	static void markNumbers(int callNum) {
		for (int i = 0; i < Boards.size(); i++) {
			for (int j = 0; j < Boards.get(i).size(); j++) {
				String singleElement = Boards.get(i).get(j);
				if (singleElement.equals(String.valueOf(callNum))) {
					String append = singleElement + mark ;
					Boards.get(i).set(j, append);
				}
			}
		}
	}	
	
	static boolean checkRow(ArrayList<String> arr) {
		// Check row
		for(int i = 0; i < arr.size(); i+= 5) {
			int bingoCounter = 0;
			
			 // Parse each single elements
			 String singleElement = arr.get(i);
			 
			// Check if the element is marked
			if (singleElement.endsWith(mark)) {
				for(int j = i; j < arr.size(); j++) {
					singleElement = arr.get(j);
					
					if(singleElement.endsWith(mark)) {
						bingoCounter++;
					} else {
						break;
					}
					
					if(bingoCounter == 5) {
						return true;
					}
					
				}
			}			
		}
		
		return false;
	}
	
	static boolean checkColumn(ArrayList<String> arr) {
		// Check column
		for(int i = 0; i < 5; i++) {
			int bingoCounter = 0;
			
			 // Parse each single elements
			 String singleElement = String.valueOf(arr.get(i));
			 
			// Check if the element is marked
			if (singleElement.endsWith(mark)) {
				for(int j = i ; j < arr.size(); j+=5) {
					singleElement = String.valueOf(arr.get(j));
					
					if(singleElement.endsWith(mark)) {
						bingoCounter++;
					} else {
						break;
					} 
					
					if(bingoCounter == 5) {
						return true;
					}
				}
			}			
		}
		return false;		
	}
	
	static int calculate(ArrayList<String> arr, int lastNum) {
		int total = 0;
		for(String element : arr) {
			if(!element.endsWith(mark)) {
				total += Integer.parseInt(element);
			}
		}
		
		System.out.println("\nFINAL RESULT: \n" + total * lastNum);
		
		return total * lastNum;
		
	}
	
	
	static void print() {
		for(int i = 0; i < Boards.size(); i++) {
			System.out.println(Boards.get(i));
		}
	}

}	// End class
