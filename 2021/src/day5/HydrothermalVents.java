package day5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

import adventofcode2021.AdventDay;

public class HydrothermalVents implements AdventDay {
	final static private String path = "inputs/5.txt";
	private LinkedList<Vent> input = new LinkedList<Vent>();

	public HydrothermalVents() {
		try {
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));

			String line;
			while ((line = inputStream.readLine()) != null) {
				String[] c = line.split("->");
				int[] firstPoint = Arrays.stream(c[0].split(",")).mapToInt(value -> Integer.parseInt(value.trim())).toArray();

				int[] secondPoint = Arrays.stream(c[1].split(",")).mapToInt(value -> Integer.parseInt(value.trim())).toArray();

				input.add(new Vent(firstPoint[0], secondPoint[0], firstPoint[1], secondPoint[1]));
			}

			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void runA() {
		LinkedList<Vent> clone = ((LinkedList<Vent>) input.clone()).stream().filter(value -> value.isStraight())
				.collect(Collectors.toCollection(LinkedList::new));

		LinkedList<LinkedList<Coordinate>> coordinates = (LinkedList<LinkedList<Coordinate>>) clone.stream()
				.map(value -> value.getStraightLineCoordinates()).collect(Collectors.toCollection(LinkedList::new));

		Map<Coordinate, Integer> grid = new HashMap<>();

		for (LinkedList<Coordinate> cords : coordinates) {
			for (Coordinate cord : cords) {
				Integer existing = grid.get(cord);

				if (existing == null) {
					grid.put(cord, 1);
				} else {
					grid.put(cord, ++existing);
				}
			}
		}

		Integer overlaps = 0;
		for (Integer value : grid.values()) {
			if (value > 1) {
				overlaps++;
			}
		}

		System.out.println("Day5 A: " + overlaps);
	}

	@SuppressWarnings("unchecked")
	public void runB() {
		LinkedList<Vent> clone = (LinkedList<Vent>) input.clone();

		LinkedList<LinkedList<Coordinate>> coordinates = (LinkedList<LinkedList<Coordinate>>) clone.stream()
				.map(value -> value.getLineCoordinates()).collect(Collectors.toCollection(LinkedList::new));

		Map<Coordinate, Integer> grid = new HashMap<>();

		for (LinkedList<Coordinate> cords : coordinates) {
			for (Coordinate cord : cords) {
				Integer existing = grid.get(cord);

				if (existing == null) {
					grid.put(cord, 1);
				} else {
					grid.put(cord, ++existing);
				}
			}
		}

		Integer overlaps = 0;
		for (Integer value : grid.values()) {
			if (value > 1) {
				overlaps++;
			}
		}

		System.out.println("Day5 B: " + overlaps);
	}

}
