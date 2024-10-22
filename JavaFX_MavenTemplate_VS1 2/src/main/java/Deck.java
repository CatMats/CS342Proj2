import java.util.ArrayList;
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
	}
	
	
	public void newDeck() {
		cardList.clear();
		this.createDeck();
		
	}
}
