import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

class MyTest {
		Deck myDeck;
		Dealer theDealer;
		ArrayList<Card> myHand;
	@BeforeEach
	void setup() {
		myDeck = new Deck();
		theDealer = new Dealer();
		myHand = new ArrayList<>();
	}
	
	//new test
	@Test
	void deck_exists(){
		assertNotNull(myDeck);
	}


	@Test
	void deck_test() {
		//myDeck.printOutDeck();
		assertEquals(myDeck.get(0).getValue(), myDeck.takeCardFromDeck().getValue(), "Values of the head and removed card aren't equal");
		assertEquals(myDeck.get(0).getValue(), myDeck.takeCardFromDeck().getValue(), "Values of the head and removed card aren't equal");
		assertEquals(myDeck.get(0).getValue(), myDeck.takeCardFromDeck().getValue(), "Values of the head and removed card aren't equal");
	}
	
	@Test
	void new_deck_test() {
		Card topCard = myDeck.get(0);
		myDeck.newDeck();
		// This could hypothetically fail if we somehow shuffle and have the same exact card on top twice in a row, we simply won't.
		assertNotEquals(topCard.value, myDeck.takeCardFromDeck().value, "The cards on the top are equal!");
		assertNotEquals(topCard.suit, myDeck.takeCardFromDeck().suit, "The cards on the top are equal!");
		assertNotEquals(topCard, myDeck.takeCardFromDeck(), "The cards on the top are equal!");
	}

	@Test
	void dealer_exists(){
		assertNotNull(theDealer, "Dealer object must be initialized");
	}

	@Test
	void dealer_deck_exists(){
		assertNotNull(theDealer.theDeck, "Dealer must have a deck.");
		assertEquals(theDealer.theDeck.size(), 52, "Deck must have  size 52 at initialization");
	}

	@Test
	void dealer_Deals(){
		theDealer.dealersHand = theDealer.dealHand();

		assertEquals(theDealer.dealersHand.size(), 3);
		assertEquals(theDealer.theDeck.size(), 49);
	}

	@Test
	void dealer_deals_deckRefresh(){
		theDealer.dealersHand = theDealer.dealHand();
		Player thePlayer = new Player();
		for(int i = 0; i < 6; i++){
			thePlayer.hand = theDealer.dealHand();
			thePlayer.hand.clear();
		}
		assertEquals(theDealer.theDeck.size(), 49);
	}
}
