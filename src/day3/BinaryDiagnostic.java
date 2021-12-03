package day3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Scanner;

import adventofcode2021.AdventDay;

public class BinaryDiagnostic implements AdventDay {
	final static private String path = "inputs/test.txt";
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
		
	}

	public void runB() {
		
	}

}
