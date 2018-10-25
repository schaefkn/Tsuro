package de.kvnsfr.university.tsuro;

public class CheckCards {
	/**
	 * 
	 * @param connections A two dimensional array that contains all pairs of connections
	 * @param edges The total number of edges per card
	 * @param offset A specific offset integer value for the amount of edges to iterate on
	 * @param value A specific integer value to check for an existing connection with
	 * @return true if a connection specified by the given value is still available
	 */
	public static boolean getAvailability(int[][] connections, int edges, int offset, int value) {		
		for(int i = 0; i < edges - offset; i++) {
			for(int j = 0; j < 2; j++) {
				if(connections[i][j] == value) {
					return false;
				}
			}
		}
		
		if(offset == 1) {
			for(int j = 0; j < 1; j++) {
				if(connections[edges - 1][j] == value) {
					return false;
				}
			}
		}
		
		return true;
	}
}
