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
	final static private String path = "inputs/test.txt";

	private LinkedList<Integer> draws = new LinkedList<Integer>();
	private LinkedList<Integer[][]> boards = new LinkedList<Integer[][]>();

	public GiantSquidBingo() {
		try {
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));

			Arrays.stream(inputStream.readLine().split(",")).forEach(value -> draws.add(Integer.parseInt(value)));

			int rowCount = 0;
			Integer[][] board = new Integer[5][5];

			String line;
			while ((line = inputStream.readLine()) != null) {
				if (!(line.trim().length() == 0)) {
					board[rowCount] = (Integer[]) Arrays.stream(line.trim().split(" ")).filter(value -> value.length() > 0)
							.mapToInt(value -> Integer.parseInt(value)).boxed().toArray(Integer[]::new);

					rowCount++;
				} else {
					boards.add(board);
					rowCount = 0;
				}
			}

			/*
			 * boards.stream().forEach(value -> { Arrays.stream(value).forEach(val -> {
			 * Arrays.stream(val).forEach(v -> System.out.print(v + " "));
			 * System.out.println(""); }); System.out.println("****"); });
			 */

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
					break;
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
		
		System.out.print("board: ");
		flatBoard.stream().forEach(v -> System.out.print(v + " - "));
		System.out.println("");
		
		System.out.print("unmarked ");
		flatBoard.stream().filter(value -> !drawn.contains(value)).forEach(v -> System.out.print(v + " "));
		System.out.println("");

		Integer unmarkedSum = flatBoard.stream().filter(value -> !drawn.contains(value)).reduce(0, Integer::sum);

		Integer score = unmarkedSum * drawn.get(drawn.size() - 1);
		
		System.out.println("Day4 A: " + score);
	}

	public void runB() {
		System.out.println("Day4 B: Not implemented");
	}

	public void checkWinner(Integer[][] boards, LinkedList<Integer> drawn) {

	}

}
