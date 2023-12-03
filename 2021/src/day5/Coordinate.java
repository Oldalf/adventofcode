package day5;

import java.util.Objects;

public class Coordinate {
	public int X;
	public int Y;
	
	public Coordinate(int x, int y) {
		super();
		X = x;
		Y = y;
	}
	
	@Override
	public boolean equals(Object o) {
	  if(this == o) {
	    return true;
	  }
	  
	  if(o == null || getClass() != o.getClass()) {
	    return false;
	  }
	  Coordinate c = (Coordinate) o;

	  return c.X == this.X && c.Y == this.Y;
	}
	
	public int hashCode() {
	  return Objects.hash(X, Y);
	}

	@Override
	public String toString() {
		return "Coordinate [X=" + X + ", Y=" + Y + "]";
	}

}
