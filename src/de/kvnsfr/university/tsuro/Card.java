package de.kvnsfr.university.tsuro;

import java.util.ArrayList;

public class Card {
	ArrayList<Node> nodes = new ArrayList<>();
	ArrayList<Edge> edges = new ArrayList<>();
	
	public Card() {
		this.generateNodes();
	}
	
	private void generateNodes() {
		for(int x = 1; x <= 4; x++) {
			for(int y = 1; y <= 2; y++) {
				nodes.add(new Node(x, y));
			}
		}
	}
	
	public void connectNodes(Node origin, Node dest) {
		if(origin.connectNode(dest) && !origin.equals(dest))
			edges.add(origin.edge);
		
//		origin.connectNode(dest);
//		
//		if(!edges.contains(origin.edge))
//			edges.add(origin.edge);
	}
	
	public void connectNodesByIndex(int origin, int dest) {
		Node originNode = getNode(origin);
		Node destNode = getNode(dest);
		this.connectNodes(originNode, destNode);
	}
	
	public Node getNode(int index) {
		return nodes.get(index);
	}

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
	
	public void rotateCard() {
		ArrayList<Node> tmpNodes = new ArrayList<>();
		
		for(int i = 0; i < nodes.size(); i++) {
			Node tmpNode = nodes.get((i + 2) % nodes.size());
			tmpNode.pos.x = tmpNode.pos.x % (nodes.size()/2) + 1;
			tmpNodes.add(tmpNode);
		}
		
		this.nodes = tmpNodes;
	}
	
	public boolean containsEdge(Edge e) {
		for(Edge edge: edges)
			if(edge.equals(e))
				return true;
		return false;
	}
	
	public boolean equals(Card c) {
		if(this.edges.size() != c.edges.size())
			return false;
					
		for(Edge edge: edges)
			if(!c.containsEdge(edge))
				return false;

		return true;
	}
	
	public boolean equalsAfterRotation(Card c) {
		for(int i = 0; i < 4; i++) {
			this.rotateCard();
			if(this.equals(c))
				return true;
		}
		return false;
	}
}
