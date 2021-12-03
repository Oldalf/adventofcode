package day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

import adventofcode2021.AdventDay;

public class SonarSweep implements AdventDay {
	final static private String path = "inputs/1.txt";
	
	private LinkedList<Integer> input = new LinkedList<Integer>();
	
	public SonarSweep() {
		try {
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
			
			String line;
			while((line = inputStream.readLine()) != null) {
				input.add(Integer.parseInt(line));				
			}
			
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void runA() {
		int result = 0;
		for (int i = 1; i < input.size(); i++) {
			if(input.get(i) > input.get(i-1)) {
				result++;
			}
		}
		System.out.println("Day1 A: " + result);
	}
	
	public void runB() {
		int result = 0;
		for (int i = 0; i + 3 < input.size(); i++) {
			int firstWindow = input.subList(i, i+3)
					.stream()
					.reduce(0, Integer::sum);
			
			int secondWindow = input.subList(i+1, i+4)
					.stream()
					.reduce(0, Integer::sum);

			if(firstWindow < secondWindow) {
				result++;
			}
		}
		System.out.println("Day1 B: " + result);
	}

}
