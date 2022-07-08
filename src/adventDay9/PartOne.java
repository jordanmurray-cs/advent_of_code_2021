package adventDay9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PartOne {

	public static void main(String[] args) throws IOException {
		final int WIDTH = 100;
		final int HEIGHT = 100;
		int arr[] = new int[WIDTH * HEIGHT];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("inputs/DAY9.txt"));
			String line;
			int i = 0;
			while((line = br.readLine()) != null) {
                for(String num : line.trim().split("")) {
                    arr[i] = Integer.parseInt(num);
                    i++;
                }
			}
			
			ArrayList<Integer> results = new ArrayList<>();
			for(int h = 0; h < HEIGHT; h++) {
				int lowest = Integer.MAX_VALUE;
				for(int w = 0; w < WIDTH; w++) {
					int value = arr[(h * WIDTH) + w];
					int north, south, east, west; north=10;south=10;east=10;west=10;
					
					if(h > 0) {
						north = arr[(h * WIDTH + w) - WIDTH];
					}
					
					if(h != HEIGHT - 1) {
						south = arr[(h * WIDTH + w) + WIDTH];
					}
					
					if(w > 0) {
						west = arr[(h * WIDTH + w) - 1];
					}
					
					if(w != WIDTH - 1) {
						east = arr[(h * WIDTH + w) + 1];
					}
					
					if(
					value < north
					&& value < south
					&& value < east
					&& value < west
					) 
					{
						lowest = value;
						results.add(lowest + 1);
					}
					
				}	// End inner for
			
			}
			
			System.out.println("RESULT: " + results.stream().reduce(0, Integer::sum));
	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	// End main

}	// End class