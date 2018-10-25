package de.kvnsfr.university.tsuro;

public class Position {
	int x;
	int y;
	
	/**
	 * Another constructor for class Position
	 * @param x integer value that specifies the x value of the position
	 * @param y integer value that specifies the y value of the position
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Checks whether this position equals another given position
	 * @param posToCompare Object from class Position to compare with
	 * @return true if the given position equals this position
	 */
	public boolean equals(Position posToCompare) {
		if(this.x == posToCompare.x && this.y == posToCompare.y)
			return true;
		return false;
	}
}
