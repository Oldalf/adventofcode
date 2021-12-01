package day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class SonarSweep {
	final static private String path = "inputs/1.txt";
	private LinkedList<Integer> measurements = new LinkedList<Integer>();
	
	public void runA() throws FileNotFoundException {
		FileInputStream inputStream = new FileInputStream(path);
		Scanner scan = new Scanner(inputStream);
		
		while(scan.hasNextLine()){
			measurements.add(scan.nextInt());
		}
		
		scan.close();
		
		int result = 0;
		for (int i = 1; i < measurements.size(); i++) {
			if(measurements.get(i) > measurements.get(i-1)) {
				result++;
			}
		}
		System.out.println("Day1 A: " + result);
	}
	
	public void runB() throws FileNotFoundException {
		FileInputStream inputStream = new FileInputStream(path);
		Scanner scan = new Scanner(inputStream);
		
		while(scan.hasNextLine()){
			measurements.add(scan.nextInt());
		}
		
		scan.close();
		
		int result = 0;
		for (int i = 0; i + 3 < measurements.size(); i++) {
			int firstWindow = measurements.subList(i, i+3)
					.stream()
					.reduce(0, Integer::sum);
			
			int secondWindow = measurements.subList(i+1, i+4)
					.stream()
					.reduce(0, Integer::sum);

			if(firstWindow < secondWindow) {
				result++;
			}
		}
		System.out.println("Day1 B: " + result);
	}

}
