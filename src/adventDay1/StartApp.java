package adventDay1;

public class StartApp {
	static int sample[] = {199, 200, 208, 210, 200, 207, 240, 269, 260, 263};
	
	public static void main(String[] args) {
		TestData.populateTestData("inputs/DAY1.txt");
		int increased = 0;
		int decreased = 0;
		int compare1 = 0;
		int compare2 = 0;
		
		
		for(int i = 0; i < TestData.testData.size(); i++) {
			try {
				if(nextComparsion(i)) {
					if(compare1 == 0) {
						compare1 += threeWindow(i);
					}
					
					if(compare2 == 0) {
						compare2 += threeWindow(i+1);
					}
					
					if(isSecondGreater(compare1, compare2)) {
						increased++;
					} else {
						decreased++;
					}
					
					System.out.println("Compare 1: " + compare1 + "\ncompare 2: " + compare2);
					compare1 = 0;
					compare2 = 0;
				}
				
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		
		System.out.println("INCREASED AMOUNT: " + increased);
		System.out.println("DECREASED AMOUNT: " + decreased);
		
	}
	
	public static int threeWindow(int index) {
		int amount = 0;
		for(int i = index; i < index+3; i++) {
			amount += TestData.testData.get(i);
		}
		return amount;
	}
	
	public static boolean isSecondGreater(int first, int second) {
		if(second > first) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean nextComparsion(int i) {
		if((3 + i) < TestData.testData.size()) {
			return true;
		} else {
			return false;
		}
			 
			
			
	}
	
	
	
	
	
	
	
	
	


}
