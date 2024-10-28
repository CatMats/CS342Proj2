import java.util.ArrayList;
import java.io.*; 
import java.util.*; 
@SuppressWarnings("serial")
public class Deck extends ArrayList<Card>{
	public ArrayList<Card> cardList;
	public Deck() {
		this.createDeck();
	}
	
	// Creates a Deck and places it into the ArrayList
	public void createDeck() {
		for(int i = 0; i < 3; i++) {
			for(int j = 1; j < 15; j++) {
				char letter = ' ';
				switch (i) {
				case 0:letter = 'C';
				case 1:letter = 'D';
				case 2:letter = 'S';
				case 3:letter = 'H';
				}
				cardList.add(new Card(letter, j));
			}
		}
		Collections.shuffle(cardList); 
	}
	
	// Clears the deck and gets a new deck
	public void newDeck() {
		cardList.clear();
		this.createDeck();
		
	}
	// Gives the top card of the deck
	public Card takeCardFromDeck() {
		return cardList.remove(0);
	}
	// prints out the contents of a deck
	public void printOutDeck() {
		for (Card c: cardList) {
			System.out.println(c.getSuit() + ":" + c.getValue());
		}
	}
	// Returns the size of the deck
	public int getDeckSize() {
		return this.cardList.size();
	}
}
