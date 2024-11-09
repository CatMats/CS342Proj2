import java.util.ArrayList;
import java.util.Collections;
@SuppressWarnings("serial")
public class Deck extends ArrayList<Card>{
	public Deck() {
		this.createDeck();
	}
	
	// Creates a Deck and places it into the ArrayList
	public void createDeck() {
		for(int i = 0; i < 4; i++) {
			for(int j = 2; j < 15; j++) {
				char letter = ' ';
				switch (i) {
				case 0: letter = 'C'; break;
				case 1: letter = 'D'; break;
				case 2: letter = 'S'; break;
				case 3: letter = 'H'; break;
				}
				//System.out.println(letter);
				add(new Card(letter, j));
			}
		}
		Collections.shuffle(this); 
	}
	
	// Clears the deck and gets a new deck
	public void newDeck() {
		clear();
		this.createDeck();
		
	}
	// Gives the top card of the deck
	public Card takeCardFromDeck() {
		return remove(0);
	}
	// prints out the contents of a deck
	// Mostly for testing
	public void printOutDeck() {
		for (Card c: this) {
			System.out.println(c.getSuit() + ":" + c.getValue());
		}
	}
	// Returns the size of the deck
	public int getDeckSize() {
		return this.size();
	}
}
