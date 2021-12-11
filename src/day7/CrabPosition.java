package day7;

import java.util.HashMap;

public class CrabPosition {
	public Integer min;
	public Integer max;
	public Integer position;

	public Integer noCrabsAtPosition;

	public HashMap<Integer, Integer> movingCost = new HashMap<Integer, Integer>();

	public CrabPosition(Integer min, Integer max, Integer noCrabsAtPosition, Integer position) {
		this.min = min;
		this.max = max;
		this.noCrabsAtPosition = noCrabsAtPosition;
		this.position = position;

		this.calculateMovingCosts();
	}

	private void calculateMovingCosts() {
		for (int i = min; i <= max; i++) {
			Integer cost = Math.abs(i - position) * noCrabsAtPosition;
			
			movingCost.put(i, cost);
		}
	}
}
