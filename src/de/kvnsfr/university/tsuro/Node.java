package de.kvnsfr.university.tsuro;

public class Node {
	Position pos;
	Edge edge;
	boolean connected = false;
	
	public Node(Position pos) {
		this.pos = pos;
		this.edge = null;
	}
	
	public Node(int x, int y) {
		this.pos = new Position(x, y);
		this.edge = null;
	}
	
	public boolean connectNode(Node nodeToConnect) {
		if(!this.connected && !nodeToConnect.connected) {
			this.edge = new Edge(this, nodeToConnect);
			this.connected = true;
			nodeToConnect.edge = this.edge;
			nodeToConnect.connected = true;
			
			return true;
		}
		return false;
	}
	
	public boolean equals(Node nodeToCompare) {
		if(this.pos.equals(nodeToCompare.pos))
			return true;
		return false;
	}
}
