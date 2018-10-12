package de.kvnsfr.university.tsuro;

public class Main {

	public static void main(String[] args) {
		CardGenerator gc = CardGenerator.getInstance();
		gc.readGeneratedCardsFile("GeneratedCards.txt");
		System.out.println("No. unique cards: " + gc.calculateUniqueCards());
	}
}
