package de.kvnsfr.university.tsuro;

import java.util.ArrayList;

public class CardGenerator {
	private static CardGenerator instance;
	
	ArrayList<Card> cards = new ArrayList<>();
	
	private CardGenerator() { }
	
	public static CardGenerator getInstance() {
		if(instance == null)
			instance = new CardGenerator();
		return instance;
	}
	
	protected static void testCardEqualityFunctions() {
		Card card = new Card();
		card.connectNodesByIndex(0, 5);
		card.connectNodesByIndex(1, 4);
		card.connectNodesByIndex(2, 6);
		card.connectNodesByIndex(3, 7);
		
		Card card2 = new Card();
		card2.connectNodesByIndex(0, 4);
		card2.connectNodesByIndex(1, 5);
		card2.connectNodesByIndex(2, 7);
		card2.connectNodesByIndex(3, 6);
		
		System.out.println("Card1 equals Card2 after rotation: " + card.equalsAfterRotation(card2));
	}
	
	public void generateCards() {
		for(int i = 1; i <= 7; i++) {
			Card tmp = new Card();
			tmp.connectNodesByIndex(0, i);
			tmp.printCard();
		}
	}
}
