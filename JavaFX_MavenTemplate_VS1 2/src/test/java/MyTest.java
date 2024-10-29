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
class MyTest {
		Deck myDeck;
	@BeforeEach
	void setup() {
		myDeck = new Deck();
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

}
