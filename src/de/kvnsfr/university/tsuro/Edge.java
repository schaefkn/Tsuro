package de.kvnsfr.university.tsuro;

public class Edge {
	Node origin;
	Node dest;
	
	/**
	 * Another constructor for class Edge
	 * @param origin The origin node connected with the destination node
	 * @param dest The destination node that is connected to by the origin node
	 */
	public Edge(Node origin, Node dest) {
		this.origin = origin;
		this.dest = dest;
	}
	
	/**
	 * Reverses this edge by flipping origin and dest node of the edge
	 * @return new object from class Edge that equals this edge reversed
	 */
	public Edge reversedEdge() {
		return new Edge(this.dest, this.origin);
	}
	
	/**
	 * Checks whether the given edge equals this edge by checking the containing nodes normally and reversed
	 * @param e An object from class Edge to check for
	 * @return true if the given edge equals this edge normally or reversed
	 */
	public boolean equals(Edge e) {
		Edge reversed = this.reversedEdge();
		
		if(this.origin.equals(e.origin) && this.dest.equals(e.dest))
			return true;
		else if (reversed.origin.equals(e.origin) && reversed.dest.equals(e.dest))
			return true;
		
		return false;
	}
}
