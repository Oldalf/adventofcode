package adventofcode2021;

import java.io.FileNotFoundException;
import java.util.Arrays;

import day1.SonarSweep;

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
		
		
		SonarSweep sonarSweep = new SonarSweep();
		try {
			sonarSweep.runA();
			sonarSweep.runB();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
