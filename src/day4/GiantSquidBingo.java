package day4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

import adventofcode2021.AdventDay;

public class GiantSquidBingo implements AdventDay {
	final static private String path = "inputs/4.txt";

	private LinkedList<Integer> draws = new LinkedList<Integer>();
	private LinkedList<Integer[][]> boards = new LinkedList<Integer[][]>();

	public GiantSquidBingo() {
		try {
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));

			Arrays.stream(inputStream.readLine().split(",")).forEach(value -> draws.add(Integer.parseInt(value)));

			LinkedList<Integer> boardParts = new LinkedList<Integer>();
			String line;
			while ((line = inputStream.readLine()) != null) {
				if (line.trim().length() == 0) {
					if (boardParts.size() == 25) {
						// make/add board and clear parts.
						Integer[][] b = getBoard(boardParts);
						boards.add(b);
						boardParts.clear();
					}
				} else {
					String[] segments = Arrays.stream(line.trim().split(" ")).filter(value -> value.trim().length() > 0)
							.toArray(size -> new String[size]);

					// System.out.println("array: " + Arrays.toString(segments));
					for (String s : segments) {
						// System.out.print(s + " - ");
						boardParts.add(Integer.parseInt(s));
					}
					// System.out.println("");
				}
			}
			
			if(boardParts.size() == 25) {
				boards.add(getBoard(boardParts));
				boardParts.clear();				
			}
			
			System.out.println("part size: " + boardParts.size());

			System.out.println("size: " + boards.size());

			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void runA() {
		LinkedList<Integer> drawn = new LinkedList<Integer>();

		Integer[][] winnerBoard = null;
		LinkedList<Integer> winningLine = new LinkedList<Integer>();

		int counter = 0;
		while (drawn.size() < draws.size() && winnerBoard == null) {
			drawn.add(draws.get(counter++));

			if (drawn.size() > 5) {
				// row
				for (Integer[][] board : boards) {
					for (int row = 0; row < 5 && winnerBoard == null; row++) {
						for (int col = 0; col < 5; col++) {
							if (drawn.size() == 12) {
							}			
							if (!drawn.contains(board[row][col])) {
								break;
							}
							if (col == 4) {
								winningLine.add(board[row][0]);
								winningLine.add(board[row][1]);
								winningLine.add(board[row][2]);
								winningLine.add(board[row][3]);
								winningLine.add(board[row][4]);
								System.out.println("win found, row");
								winnerBoard = board;
								break;
							}
						}
					}
				}

				// col
				for (Integer[][] board : boards) {
					for (int col = 0; col < 5 && winnerBoard == null; col++) {
						for (int row = 0; row < 5; row++) {
							if (!drawn.contains(board[row][col])) {
								break;
							}
							if (row == 4) {
								winningLine.add(board[0][col]);
								winningLine.add(board[1][col]);
								winningLine.add(board[2][col]);
								winningLine.add(board[3][col]);
								winningLine.add(board[4][col]);
								System.out.println("win found, col");
								winnerBoard = board;
								break;
							}
						}
					}
					break;
				}
			}
		}

		System.out.println("got to the end after: " + drawn.size() + " draws");
		System.out.print("drawn: ");
		drawn.stream().forEach(value -> System.out.print(value + " "));
		System.out.println("");

		System.out.print("winningLine: ");
		winningLine.stream().forEach(value -> System.out.print(value + " "));
		System.out.println("");

		LinkedList<Integer> flatBoard = Arrays.stream(winnerBoard).flatMap(o -> Arrays.stream(o))
				.collect(Collectors.toCollection(LinkedList::new));

		System.out.println("board: ");
		Arrays.stream(winnerBoard).forEach(v -> {
			System.out.println(Arrays.toString(v));
		});
		System.out.println("***");
		System.out.println("");

		System.out.print("unmarked ");
		flatBoard.stream().filter(value -> !drawn.contains(value)).forEach(v -> System.out.print(v + " "));
		System.out.println("");

		Integer unmarkedSum = flatBoard.stream().filter(value -> !drawn.contains(value)).reduce(0, Integer::sum);

		Integer score = unmarkedSum * drawn.get(drawn.size() - 1);

		System.out.println("Day4 A: " + score);
	}

	public void runB() {

	}

	public Integer[][] getBoard(LinkedList<Integer> boardParts) {
		return new Integer[][] { boardParts.subList(0, 5).stream().toArray(size -> new Integer[size]),
			boardParts.subList(5, 10).stream().toArray(size -> new Integer[size]),
			boardParts.subList(10, 15).stream().toArray(size -> new Integer[size]),
			boardParts.subList(15, 20).stream().toArray(size -> new Integer[size]),
			boardParts.subList(20, 25).stream().toArray(size -> new Integer[size]), };

	}

}
