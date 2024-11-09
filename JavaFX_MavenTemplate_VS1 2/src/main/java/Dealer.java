import java.util.ArrayList;
public class Dealer {
	public Deck theDeck;
	public ArrayList<Card> dealersHand;
	
	public Dealer() {
		theDeck = new Deck();
	}

	//takes 3 cards from theDeck and gives them to players and dealer.
	public ArrayList<Card> dealHand() {
		ArrayList<Card> dealtCards = new ArrayList<>();
		for(int i = 0; i < 3; i++) {dealtCards.add(theDeck.takeCardFromDeck());}
		if(theDeck.size() <= 34) {theDeck.newDeck();}
		return dealtCards;
	}
}
