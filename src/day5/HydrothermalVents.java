package day5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;

import adventofcode2021.AdventDay;

public class HydrothermalVents implements AdventDay {
	final static private String path = "inputs/test.txt";
	private LinkedList<Vent> input = new LinkedList<Vent>();
	
	public HydrothermalVents() {
		try {
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));

			String line;
			while ((line = inputStream.readLine()) != null) {
				String[] c = line.split("->");
				int[] firstPoint = Arrays.stream(c[0].split(","))
						.mapToInt(value -> Integer.parseInt(value.trim()))
						.toArray();
				
				int[] secondPoint = Arrays.stream(c[1].split(","))
						.mapToInt(value -> Integer.parseInt(value.trim()))
						.toArray();
				
				input.add(new Vent(firstPoint[0], secondPoint[0], firstPoint[1], secondPoint[1]));
			}

			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@SuppressWarnings("unchecked")
	public void runA() {
		LinkedList<Vent> clone = (LinkedList<Vent>) ((LinkedList<Vent>) input.clone()).stream().filter(value -> value.isStraight());
		
		LinkedList<LinkedList<Coordinate>> coordinates = (LinkedList<LinkedList<Coordinate>>) clone.stream()
			.map(value -> value.getStraightLineCoordinates());
		
		
				

	}

	public void runB() {

	}

}
