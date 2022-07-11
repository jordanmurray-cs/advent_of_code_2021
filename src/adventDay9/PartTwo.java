package adventDay9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PartTwo {
	
	static final int WIDTH = 100; 
	static final int HEIGHT = 100; 
	static int arr[] = new int[WIDTH * HEIGHT];

	public static void main(String[] args) throws IOException {
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
			
			ArrayList<Integer> sizes = new ArrayList<>();
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
						boolean elementsVisited[] = new boolean[WIDTH * HEIGHT];
						sizes.add(countingSizes(h, w, elementsVisited));
						
					}
					
				}	// End inner for
			}
			
			Collections.sort(sizes);
			System.out.println(
					sizes
						.subList(sizes.size() - 3, sizes.size())
						.stream()
						.reduce((x, y) -> x * y)
						.orElse(-1)
			);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	// End main
	
	private static int countingSizes(int h, int w, boolean[] elementsVisited) {
		int current = arr[(h * WIDTH + w)];
		elementsVisited[(h * WIDTH + w)] = true;
		
		if(current == 9) return 0;
		current = 1;
		
		int northValue = (h * WIDTH + w) - WIDTH;
		
		if(h > 0 && !elementsVisited[northValue]) {
			current += countingSizes(h - 1, w, elementsVisited);
		}
		
		int southValue = (h * WIDTH + w) + WIDTH;
		if(h != HEIGHT -1  && !elementsVisited[southValue]) {
			current += countingSizes(h+1, w, elementsVisited);
		}
		
		int eastValue = (h * WIDTH + w) + 1;
		if(w != WIDTH - 1 && !elementsVisited[eastValue]) {
			current += countingSizes(h, w+1, elementsVisited);
		}
		
		int westValue = (h * WIDTH + w) - 1;
		if(w > 0 && !elementsVisited[westValue]) {
			current += countingSizes(h, w - 1, elementsVisited);
		}
		
		return current;
	}

}	// End class