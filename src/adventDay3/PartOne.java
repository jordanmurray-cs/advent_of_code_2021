package adventDay3;

public class PartOne {
	
	public static void main(String[] args) {
		TestData.populateTestData("inputs/DAY3.txt");
		String gamma = "";
		String least = "";
		
		for(int i = 0; i < 12; i++) {
			String bit1 = countBits(i, "common");
			gamma += bit1;
			
			String bit2 = countBits(i, "least");
			least += bit2;
		}
		
		// Parse to binary
		int gammaParse = Integer.parseInt(gamma, 2);
		int leastParse = Integer.parseInt(least, 2);

		
		System.out.println("GAMMA: " + gamma + "\nLEAST: " + least);
		System.out.println("PARSED" + "\nGAMMA: " + gammaParse + "\nLEAST: " + leastParse);
		System.out.println("FINAL ANSWER: " + (gammaParse * leastParse) );

		
	}	// End main
	
	public static String countBits(int bitIndex, String leastorcommon) {
		int zero = 0;
		int one = 0;
		
		for(int i = 0; i < TestData.testData.size(); i++) {
			char mytest = TestData.testData.get(i).charAt(bitIndex);
			if(mytest == '0') {
				zero++;
			} else {
				one++;
			}
		}
		
		switch(leastorcommon) {
		case "common":
			if(zero > one) {
				return "0";
			} else {
				return "1";
			}
			
		case "least":
			if(zero < one) {
				return "0";
			} else {
				return "1";
			}
			
			
		default: 
			return "-1";
		}


	}
}
