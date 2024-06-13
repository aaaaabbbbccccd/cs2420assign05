package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ListSorterTimer {

	public static void main(String[] args) {
		long startTime, midpointTime, stopTime;
		Random rand = new Random(1357578589);
		
		//creates a new object(s) to be tested.
		ArrayList<Integer> testList;	
		
		//number of times to repeat each individual test
		double timesToLoop = 100;
		
		//preloop setup
		ListSorter.insertionSortThreshold = 1000;
		
		for(int n = 10000; n <= 200000; n+= 10000) {
						
			//clears and then populates the array that will be used for testing.
			testList = (ArrayList<Integer>) ListSorter.generateAscending(n);
			Collections.shuffle(testList, rand);
			

			startTime = System.nanoTime();
			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}
			
			startTime = System.nanoTime();
	
			//the code being tested
			for(int i = 0; i < timesToLoop; i++) {
				ListSorter.mergesort(testList);

			}
			midpointTime = System.nanoTime();
	
			// Run an empty loop to capture the cost of running the loop.
	
			for(long i = 0; i < timesToLoop; i++) { // empty block
			}
	
			stopTime = System.nanoTime();
	
			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and computing square roots.
			// Average it over the number of runs.
	
			double averageTime = (double) ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;
	
			System.out.println(n + "\t" + averageTime);
		}
	}

}
