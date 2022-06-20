package adventDay2;

public class StartApp {
	
	public static void main(String[] args) {
		TestData.populateTestData("inputs/DAY2.txt");
		int horz = 0;
		int dept = 0;
		int aim = 0;
		
		for(int i = 0; i < TestData.testData.size(); i++) {
			String test[] = TestData.testData.get(i).split("\\W+");
			int num = Integer.parseInt(test[1]);
			switch(test[0]) {
			case "up":
				aim -= num;
				break;
				
			case "down":
				aim += num;
				break;
				
			case "forward":
				horz += num;
				
				if(aim != 0) {
					dept += (aim * num);
				}
				break;
			}
		}
		
		System.out.println("ANSWER: " + (horz * dept));
	}
}
