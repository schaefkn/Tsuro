package de.kvnsfr.university.tsuro;

public class Edge {
	Node origin;
	Node dest;
	
	public Edge(Node origin, Node dest) {
		this.origin = origin;
		this.dest = dest;
	}
	
	public Edge reversedEdge() {
		return new Edge(this.dest, this.origin);
	}
	
	public boolean equals(Edge e) {
		Edge reversed = this.reversedEdge();
		
		if(this.origin.equals(e.origin) && this.dest.equals(e.dest))
			return true;
		else if (reversed.origin.equals(e.origin) && reversed.dest.equals(e.dest))
			return true;
		
		return false;
	}
}
