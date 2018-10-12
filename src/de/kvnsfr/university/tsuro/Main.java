package de.kvnsfr.university.tsuro;

public class Main {
	
	public static void main(String[] args) {
		CardGenerator gc = CardGenerator.getInstance();
		gc.readGeneratedCardsFile("C:\\Users\\KevinSchaefer\\University\\Java-Vorkurs\\Tsuro\\src\\GeneratedCards.txt");
		System.out.println("No. unique cards: " + gc.calculateUniqueCards());
	}
}
