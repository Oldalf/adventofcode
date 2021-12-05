package day3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import adventofcode2021.AdventDay;

public class BinaryDiagnostic implements AdventDay {
	final static private String path = "inputs/3.txt";
	private LinkedList<String> input = new LinkedList<String>();
	
	public BinaryDiagnostic() {
		try {
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
			
			String line;
			while((line = inputStream.readLine()) != null) {
				input.add(line);				
			}
			
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void runA() {
		@SuppressWarnings("unchecked")
		LinkedList<String> clone = (LinkedList<String>) input.clone();
		
		Integer[] bitCounts = new Integer[clone.get(0).length()];
		Arrays.fill(bitCounts, 0);		

		for(String value: clone) {
			String[] bits = value.split("");
			
			for (int i = 0; i < bits.length; i++) {
				Integer bit = bitCounts[i];
				bitCounts[i] = bit += Integer.parseInt(bits[i]);
			}
		}		

		String[] gamma = new String[bitCounts.length];
		
		for(int i = 0; i < bitCounts.length; i++) {
			gamma[i] = bitCounts[i] > clone.size() / 2 ? "1" : "0";

		}

		String gammaStr = "";
		String epsilonStr = "";
				
		gammaStr = String.join("", gamma);
		epsilonStr = gammaStr.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");
		
		Integer powerConsumption = Integer.parseInt(gammaStr, 2) *Integer.parseInt(epsilonStr, 2);
		System.out.println("Day3 A: " + powerConsumption);
	}

	public void runB() {
		
	}

}
