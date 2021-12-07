package adventofcode2021;

import java.util.Arrays;

import day1.SonarSweep;
import day2.Dive;
import day3.BinaryDiagnostic;
import day5.HydrothermalVents;

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
		sonarSweep.runA();
		sonarSweep.runB();
		
		// day 2.
		Dive dive = new Dive();
		dive.runA();
		dive.runB();
		
		// day 3.
		BinaryDiagnostic binaryDiagnostic = new BinaryDiagnostic();
		binaryDiagnostic.runA();
		binaryDiagnostic.runB();
		
		
		
		
		
		// day 5
		HydrothermalVents hydrothermalVent = new HydrothermalVents();
		hydrothermalVent.runA();
		hydrothermalVent.runB();
		

	}
}
