package de.kvnsfr.university.tsuro;

public class Node {
	Position pos;
	Edge edge;
	boolean connected;
	
	/**
	 * Another constructor for class Node
	 * @param pos Object from class Position that specifies the position of this node
	 */
	public Node(Position pos) {
		this.pos = pos;
		this.edge = null;
		this.connected = false;
	}
	
	/**
	 *  Another constructor for class Node
	 * @param x integer value that specifies the x position of this node
	 * @param y integer value that specifies the y position of this node
	 */
	public Node(int x, int y) {
		this.pos = new Position(x, y);
		this.edge = null;
	}
	
	/**
	 * Connects this node with another given node if connection doesn't already exist by creating a new edge
	 * @param nodeToConnect Object from class Node to connect this node with
	 * @return true if the connection was successfully created
	 */
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
	
	/**
	 * Checks whether this node equals a given node by comparing their position values
	 * @param nodeToCompare Object from class Node to compare with
	 * @return true if the given node matches this node
	 */
	public boolean equals(Node nodeToCompare) {
		if(this.pos.equals(nodeToCompare.pos))
			return true;
		return false;
	}
}
