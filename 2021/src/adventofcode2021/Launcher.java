package adventofcode2021;

import java.util.Arrays;
import java.util.HashMap;

import day1.SonarSweep;
import day14.Polymer;
import day15.Chiton;
import day2.Dive;
import day3.BinaryDiagnostic;
import day5.HydrothermalVents;
import day6.LanternFish;
import day7.Crabs;
import day4.GiantSquidBingo;

public class Launcher {

	public static void main(String[] args) {
	  int iterations;
	  int[] days;
	  
		if(args.length > 2) {
			iterations = Integer.parseInt(args[0]);
			days = Arrays.stream(Arrays.copyOfRange(args, 1, args.length-1)).mapToInt(Integer::parseInt).toArray();
		} else {
			iterations = 1;
			days = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 ,15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
		}
		
		// day 1
		SonarSweep sonarSweep = new SonarSweep();
		
		// day 2.
		Dive dive = new Dive();
		
		// day 3.
		BinaryDiagnostic binaryDiagnostic = new BinaryDiagnostic();
		
    // day 4.
    GiantSquidBingo squidBingo = new GiantSquidBingo();
		
		// day 5
		HydrothermalVents hydrothermalVent = new HydrothermalVents();
		
		// day 6
		LanternFish lanternFish = new LanternFish();	
		
		// day 7
		Crabs crabs = new Crabs();

		HashMap<Integer, AdventDay> solutions = new HashMap<Integer, AdventDay>();
		solutions.put(1, sonarSweep);
		solutions.put(2, dive);
		solutions.put(3, binaryDiagnostic);
		solutions.put(4, squidBingo);
		solutions.put(5, hydrothermalVent);
		solutions.put(6, lanternFish);
		solutions.put(7, crabs);
		
		solutions.put(14, new Polymer());
		solutions.put(15, new Chiton());
    
    
    // Run iterations.
    for(int i = 0; i < iterations; i++) {
      for(int day: days) {
        AdventDay solution = solutions.get(day);
        if(solution != null) {
          // TODO: add a read file to interface (otherwise its cheating). 
          solution.runA();
          solution.runB();
        }
      }
    }
	}
}
