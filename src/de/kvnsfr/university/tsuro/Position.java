package de.kvnsfr.university.tsuro;

public class Position {
	int x;
	int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Position posToCompare) {
		if(this.x == posToCompare.x && this.y == posToCompare.y)
			return true;
		return false;
	}
}
