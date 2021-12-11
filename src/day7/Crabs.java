package day7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import adventofcode2021.AdventDay;

public class Crabs implements AdventDay {
	final static private String path = "inputs/7.txt";
	private HashMap<Integer, Integer> inputs = new HashMap<Integer, Integer>();

	public Crabs() {
		try {
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));

			String line = inputStream.readLine();

			Arrays.stream(line.split(",")).forEach(value -> {
				Integer v = Integer.parseInt(value);
				Integer existing = inputs.get(v);
				if (existing == null) {
					inputs.put(v, 1);
				} else {
					inputs.put(v, existing + 1);
				}
			});

			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void runA() {
		Integer min = Collections.min(inputs.keySet());
		Integer max = Collections.max(inputs.keySet());

		List<CrabPosition> positions = inputs.keySet().stream()
				.map(v -> new CrabPosition(min, max, inputs.get(v), v))
				.collect(Collectors.toList());
		
		HashMap<Integer, Integer> costs = new HashMap<Integer, Integer>();
		
		for(CrabPosition pos: positions) {
			pos.movingCost.entrySet().forEach(v -> {
				Integer existing = costs.get(v.getKey());
				
				if(existing == null) {
				 costs.put(v.getKey(), v.getValue());
				} else {
					costs.put(v.getKey(), existing + v.getValue());					
				}
			});			
		}		
	    
	  Integer minCost = Collections.min(costs.values());
	  
	  System.out.println("Day7 A: " + minCost);
	}

	public void runB() {
		// Modify crab positions, make the map a function to return
		// based on calculations and use the added calc.

	}

}
