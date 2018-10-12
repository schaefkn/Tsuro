package de.kvnsfr.university.tsuro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	public void isEqual(int index1, int index2) {
		if(cards.get(index1).equalsAfterRotation(cards.get(index2))) {
			cards.get(index1).printCard();
			cards.get(index2).printCard();
		}
	}
	
	public void generateCards() {
		for(int i = 1; i <= 7; i++) {
			Card tmp = new Card();
			tmp.connectNodesByIndex(0, i);
			cards.add(tmp);
			cards.add(tmp);
		}
	}
	
	public int calculateUniqueCards() {
		ArrayList<Card> cardsToRemoved = new ArrayList<>();
		
		for(int i = 0; i < cards.size(); i++) {
			for(int y = 0; y < cards.size(); y++) {
				Card card1 = cards.get(i);
				Card card2 = cards.get(y);
				
				if(card1.equalsAfterRotation(card2) && i != y) {
					System.out.println(i + "-" + y);
				}
			}
		}
		
		for(Card remove: cardsToRemoved)
			cards.remove(remove);
		
		System.out.println("Found same cards: " +  cardsToRemoved.size());
		return cards.size();
	}
	
	public void readGeneratedCardsFile(String path) {
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";
		
		try {
			br = new BufferedReader(new FileReader(path));
			
			while((line = br.readLine()) != null) {
				String[] input = line.split(splitBy);
				ArrayList<Integer> nodes = new ArrayList<>();
				
				for(String singleInput: input) {
					nodes.add(Integer.parseInt(singleInput));
				}
				
				Card tmp = new Card();
				tmp.connectNodesByIndex(nodes.get(0), nodes.get(1));
				tmp.connectNodesByIndex(nodes.get(2), nodes.get(3));
				tmp.connectNodesByIndex(nodes.get(4), nodes.get(5));
				tmp.connectNodesByIndex(nodes.get(6), nodes.get(7));
				cards.add(tmp);
			}
			
			System.out.println("Import No. of Cards: " + cards.size());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
