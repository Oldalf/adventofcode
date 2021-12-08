package day5;

import java.util.LinkedList;

public class Vent {
	public int x1;
	public int x2;

	public int y1;
	public int y2;

	public Vent(int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public boolean isStraight() {
		return x1 == x2 || y1 == y2;
	}

	public LinkedList<Coordinate> getStraightLineCoordinates() {
		LinkedList<Coordinate> retVal = new LinkedList<Coordinate>();

		if (x1 == x2) {
			int small = y1 > y2 ? y2 : y1;
			int large = y1 > y2 ? y1 : y2;

			for (int i = small; i <= large; i++) {
				retVal.add(new Coordinate(x1, i));
			}

			return retVal;
		} else if (y1 == y2) {
			int small = x1 > x2 ? x2 : x1;
			int large = x1 > x2 ? x1 : x2;

			for (int i = small; i <= large; i++) {
				retVal.add(new Coordinate(i, y1));
			}

			return retVal;
		} else {
			return null;
		}
	}

	public LinkedList<Coordinate> getLineCoordinates() {
		LinkedList<Coordinate> retVal = new LinkedList<Coordinate>();

		if (x1 == x2) {
			int small = y1 > y2 ? y2 : y1;
			int large = y1 > y2 ? y1 : y2;

			for (int i = small; i <= large; i++) {
				retVal.add(new Coordinate(x1, i));
			}

			return retVal;
		} else if (y1 == y2) {
			int small = x1 > x2 ? x2 : x1;
			int large = x1 > x2 ? x1 : x2;

			for (int i = small; i <= large; i++) {
				retVal.add(new Coordinate(i, y1));
			}

			return retVal;
		} else {
			int difference = Math.abs(y1 - y2);
			boolean xIncreasing = x1 < x2;
			boolean yIncreasing = y1 < y2;
			
			for(int i = 0; i <= difference; i++) {
				int x3 = xIncreasing ? x1 + i : x1 - i;
				int y3 = yIncreasing ? y1 + i : y1 - i;
				retVal.add(new Coordinate(x3, y3));

			}

			return retVal;
		}
	}
}
