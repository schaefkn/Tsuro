package de.kvnsfr.university.tsuro;

import java.util.ArrayList;

public class Card {
	ArrayList<Node> nodes = new ArrayList<>();
	ArrayList<Edge> edges = new ArrayList<>();
	
	/**
	 * Another constructor for class Card
	 * Calls the generateNodes method
	 */
	public Card() {
		this.generateNodes();
	}
	
	/**
	 * Creates 2 new objects from class Node for every 4 sides of the card and inserts them to the given list nodes
	 */
	private void generateNodes() {
		for(int x = 1; x <= 4; x++) {
			for(int y = 1; y <= 2; y++) {
				nodes.add(new Node(x, y));
			}
		}
	}
	
	/**
	 * Connects two nodes and creates a new edge and adds it to the given list edges if the origin node is not the same as the destination node
	 * @param origin The origin node to connect with the destination node
	 * @param dest The destination node to connect the origin node to
	 */
	public void connectNodes(Node origin, Node dest) {
		if(origin.connectNode(dest) && !origin.equals(dest))
			edges.add(origin.edge);
	}
	
	/**
	 * Finds two nodes by their indexes and connects them via the connectNodes(Node origin, Node dest) method
	 * @param origin The index of the origin node
	 * @param dest The index of the destination node
	 */
	public void connectNodesByIndex(int origin, int dest) {
		Node originNode = getNode(origin);
		Node destNode = getNode(dest);
		this.connectNodes(originNode, destNode);
	}
	
	/**
	 * 
	 * @param index Index of an object from class Node in given list nodes
	 * @return Object from class Node that matches the given index
	 */
	public Node getNode(int index) {
		return nodes.get(index);
	}

	/**
	 * Prints the formatted layout or stats of the card to the console
	 */
	public void printCard() {
		for(int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			System.out.println("===============");
			System.out.println("Edge: " + i);
			System.out.println("Origin: " + edge.origin.pos.x + " " + edge.origin.pos.y);
			System.out.println("Dest: " + edge.dest.pos.x + " " + edge.dest.pos.y);
		}
		System.out.println("=====  =====");
	}
	
	/**
	 * Rotates the card by 90 degrees by resetting all of the nodes
	 */
	public void rotateCard() {
		ArrayList<Node> tmpNodes = new ArrayList<>();
		
		for(int i = 0; i < nodes.size(); i++) {
			Node tmpNode = nodes.get((i + 2) % nodes.size());
			tmpNode.pos.x = tmpNode.pos.x % (nodes.size()/2) + 1;
			tmpNodes.add(tmpNode);
		}
		
		this.nodes = tmpNodes;
	}
	
	/**
	 * 
	 * @param e An object from class Edge to check for
	 * @return true if one of the edges of the card equals the given edge
	 */
	public boolean containsEdge(Edge e) {
		for(Edge edge: edges) {
			if(edge.equals(e)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param c An object from class Card to check for
	 * @return true if this card equals (has same layout as) the given card
	 */
	public boolean equals(Card c) {
		if(this.edges.size() != c.edges.size())
			return false;
					
		for(Edge edge: edges) {
			if(!c.containsEdge(edge)) {
				return false;
			}
		}

		return true;
	}
	
	/**
	 * 
	 * @param c An object from class Card to check for
	 * @return true if this card equals (has same layout as) the given card after rotation
	 */
	public boolean equalsAfterRotation(Card c) {
		for(int i = 0; i < 4; i++) {
			this.rotateCard();
			if(this.equals(c))
				return true;
		}
		return false;
	}
}
