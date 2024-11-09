import java.util.ArrayList;
public class Dealer {
	public Deck theDeck;
	public ArrayList<Card> dealersHand;
	
	public Dealer() {
		theDeck = new Deck();
	}


	public ArrayList<Card> dealHand() {
		ArrayList<Card> dealtCards = new ArrayList<>();
		for(int i = 0; i < 3; i++) {dealtCards.add(theDeck.takeCardFromDeck());}
		if(theDeck.size() <= 34) {theDeck.newDeck();}
		return dealtCards;
	}
}
