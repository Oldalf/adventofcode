package day3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

import adventofcode2021.AdventDay;

public class BinaryDiagnostic implements AdventDay {
	final static private String path = "inputs/3.txt";
	private LinkedList<String> input = new LinkedList<String>();

	public BinaryDiagnostic() {
		try {
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));

			String line;
			while ((line = inputStream.readLine()) != null) {
				input.add(line);
			}

			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void runA() {
		Integer[] bitCounts = new Integer[input.get(0).length()];
		Arrays.fill(bitCounts, 0);

		for (String value : input) {
			String[] bits = value.split("");

			for (int i = 0; i < bits.length; i++) {
				Integer bit = bitCounts[i];
				bitCounts[i] = bit += Integer.parseInt(bits[i]);
			}
		}

		String[] gamma = new String[bitCounts.length];

		for (int i = 0; i < bitCounts.length; i++) {
			gamma[i] = bitCounts[i] > input.size() / 2 ? "1" : "0";

		}

		String gammaStr = "";
		String epsilonStr = "";

		gammaStr = String.join("", gamma);
		epsilonStr = gammaStr.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");

		Integer powerConsumption = Integer.parseInt(gammaStr, 2) * Integer.parseInt(epsilonStr, 2);
		System.out.println("Day3 A: " + powerConsumption);
	}

	@SuppressWarnings("unchecked")
	public void runB() {
		LinkedList<int[]> bits = new LinkedList<int[]>();

		for (String value : input) {
			int[] binary = Arrays.stream(value.split("")).mapToInt(Integer::parseInt).toArray();

			bits.add(binary);
		}

		LinkedList<int[]> oxygenRating = (LinkedList<int[]>) bits.clone();
		LinkedList<int[]> co2ScrubberRating = (LinkedList<int[]>) bits.clone();

		int counter = 0;
		while (oxygenRating.size() > 1) {
			int commonBit = mostCommonBitAt(counter, oxygenRating);

			final int currentCounter = counter;

			oxygenRating.removeIf(value -> value[currentCounter] != commonBit);

			counter++;
		}

		counter = 0;
		while (co2ScrubberRating.size() > 1) {
			int leastCommonBit = leastCommonBitAt(counter, co2ScrubberRating);

			final int currentCounter = counter;

			co2ScrubberRating.removeIf(value -> value[currentCounter] != leastCommonBit);

			counter++;
		}
		
		int oxygen = Integer.parseInt(Arrays.stream(oxygenRating.get(0))
		 .mapToObj(String::valueOf)
		 .collect(Collectors.joining("")), 2);
		
		int co2Scrubber = Integer.parseInt(Arrays.stream(co2ScrubberRating.get(0))
				 .mapToObj(String::valueOf)
				 .collect(Collectors.joining("")), 2);

		int lifeSupportRating = co2Scrubber * oxygen;
		
		System.out.println("Day3 B: " + lifeSupportRating);

	}

	private int mostCommonBitAt(int counter, LinkedList<int[]> bits) {
		int bitCounter = 0;

		for (int[] bit : bits) {
			bitCounter += bit[counter];
		}
		return bitCounter * 2 >= bits.size() ? 1 : 0;
	}

	private int leastCommonBitAt(int counter, LinkedList<int[]> bits) {
		int bitCounter = 0;

		for (int[] bit : bits) {
			bitCounter += bit[counter];
		}

		return bitCounter * 2 >= bits.size() ? 0 : 1;
	}
}
