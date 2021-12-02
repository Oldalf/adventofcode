package adventofcode2021;

import java.io.FileNotFoundException;
import java.util.Arrays;

import day1.SonarSweep;
import day2.Dive;

public class Launcher {
	private static int iterations;
	private static int[] days;

	public static void main(String[] args) {
		if(args.length > 2) {
			iterations = Integer.parseInt(args[0]);
			days = Arrays.stream(Arrays.copyOfRange(args, 1, args.length-1)).mapToInt(Integer::parseInt).toArray();
		} else {
			iterations = 1;
			days = new int[] { 1 };
		}
		
		// day 1
		SonarSweep sonarSweep = new SonarSweep();
		try {
			sonarSweep.runA();
			sonarSweep.runB();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// day 2.
		Dive dive = new Dive();
		try {
      dive.runA();
      dive.runB();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

	}
}
