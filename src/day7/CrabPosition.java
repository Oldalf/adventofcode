package day7;

import java.util.HashMap;
import java.util.LinkedList;

public class CrabPosition {
	public Integer min;
	public Integer max;
	public Integer position;

	public Integer noCrabsAtPosition;

	public CrabPosition(Integer min, Integer max, Integer noCrabsAtPosition, Integer position) {
		this.min = min;
		this.max = max;
		this.noCrabsAtPosition = noCrabsAtPosition;
		this.position = position;
	}
	
	public HashMap<Integer, Integer> calculateLinearMovingCosts() {
	  HashMap<Integer, Integer> movingCost = new HashMap<Integer, Integer>();
	  
	  for (int i = min; i <= max; i++) {
      Integer cost = Math.abs(i - position) * noCrabsAtPosition;
      
      movingCost.put(i, cost);
    }
	  
	  return movingCost;	  
	}
	
	public HashMap<Integer, Integer> calculateIncreasingMovingCosts() {
   HashMap<Integer, Integer> movingCost = new HashMap<Integer, Integer>();
    
    for (int i = min; i <= max; i++) {
      Integer moveCost = 0;

      for (int j = 0; j <= Math.abs(i - position); j++) {
        moveCost += j;        
      }

      Integer cost = moveCost * noCrabsAtPosition;
      
      movingCost.put(i, cost);
    }
    
    return movingCost;  
	}
}
