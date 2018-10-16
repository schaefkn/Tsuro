package de.kvnsfr.university.tsuro;

public class CheckCards {
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
