import java.util.ArrayList;
public class Dealer {
	public Deck theDeck;
	public ArrayList<Card> dealersHand;
	
	public Dealer() {
		theDeck = new Deck();
	}
	
	public ArrayList<Card> dealHand() {
		if(theDeck.size() <= 34) {theDeck.newDeck();}
		ArrayList<Card> dealtCards = new ArrayList<>();
		for(int i = 0; i < 3; i++) {dealtCards.add(theDeck.takeCardFromDeck());}
		return dealtCards;
	}
}
