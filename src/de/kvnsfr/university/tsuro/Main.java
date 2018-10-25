package de.kvnsfr.university.tsuro;

public class Main {

	/**
	 * Main method of the Tsuro java program in which the card generation process is being initialized
	 * @param args
	 */
	public static void main(String[] args) {
		CardGenerator gc = CardGenerator.getInstance();
		//gc.readGeneratedCardsFile("GeneratedCards.txt");
		gc.generateCards(4);
		System.out.println("No. unique cards: " + gc.calculateUniqueCards());
	}
}
