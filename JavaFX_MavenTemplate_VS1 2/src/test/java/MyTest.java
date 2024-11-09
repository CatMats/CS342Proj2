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
		// This could hypothetically fail if we somehow shuffle and have the same exact card on top twice in a row, we simply won't...
		//assertNotEquals(topCard.value, myDeck.takeCardFromDeck().value, "The cards on the top are equal!");
		//assertNotEquals(topCard.suit, myDeck.takeCardFromDeck().suit, "The cards on the top are equal!");
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
	void dealer_deck_resets() {
		theDealer.dealersHand = theDealer.dealHand(); // 49
		theDealer.dealersHand = theDealer.dealHand(); // 46
		theDealer.dealersHand = theDealer.dealHand(); // 43
		theDealer.dealersHand = theDealer.dealHand(); // 40
		theDealer.dealersHand = theDealer.dealHand(); // 37
		assertEquals(theDealer.theDeck.size(), 37);
		theDealer.dealersHand = theDealer.dealHand(); // 34
		theDealer.dealersHand = theDealer.dealHand(); // Resets to 52 then -3
		assertEquals(theDealer.theDeck.size(), 49);
	}
	@Test
	void dealer_new_deck_check() {
		Card a = theDealer.theDeck.takeCardFromDeck();
		theDealer.theDeck.newDeck();
		Card b = theDealer.theDeck.takeCardFromDeck();
		assertNotEquals(a,b, "The Cards are equal");
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






	// 3Card Logic Tests
	@Test
	void threecardlogicStraightFlush1() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('H', 7);
		Card b = new Card('H', 8);
		Card c = new Card('H', 9);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalHand(myHand), 1, "Hand is not a straight flush!");
	}
	@Test
	void threecardlogicStraightFlush2() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('C', 14); //If the cards are placed out of order
		Card b = new Card('C', 12);
		Card c = new Card('C', 13);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalHand(myHand), 1, "Hand is not a straight flush!");
	}
	@Test
	void threecardlogicStraightFlush3() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('C', 7);
		Card b = new Card('H', 8);
		Card c = new Card('S', 9);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertNotEquals(ThreeCardLogic.evalHand(myHand), 1, "Hand is a straight flush!");
	}
	@Test
	void threecardlogic3Row1() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('H', 8);
		Card b = new Card('H', 8);
		Card c = new Card('H', 8);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalHand(myHand), 2, "Hand is not a Three-of-a-kind!");
	}
	@Test
	void threecardlogic3Row2() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('C', 8);
		Card b = new Card('H', 8);
		Card c = new Card('S', 8);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalHand(myHand), 2, "Hand is not a Three-of-a-kind!");
	}
	@Test
	void threecardlogic3Row3() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('H', 4);
		Card b = new Card('H', 5);
		Card c = new Card('H', 6);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertNotEquals(ThreeCardLogic.evalHand(myHand), 2, "Hand is a Three-of-a-kind!");
	}
	@Test
	void threecardlogicStraight1() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('H', 4);
		Card b = new Card('S', 5);
		Card c = new Card('H', 6);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalHand(myHand), 3, "Hand is not a Straight!");
	}
	@Test
	void threecardlogicStraight2() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('H', 7); //Order check
		Card b = new Card('S', 5);
		Card c = new Card('H', 6);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalHand(myHand), 3, "Hand is not a Straight!");
	}
	@Test
	void threecardlogicStraight3() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('H', 4);
		Card b = new Card('H', 5);
		Card c = new Card('H', 6);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertNotEquals(ThreeCardLogic.evalHand(myHand), 3, "Hand is not a Straight!  Check if Straight Flush has priority!");
	}
	@Test
	void threecardlogicFlush1() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('H', 4);
		Card b = new Card('H', 9);
		Card c = new Card('H', 6);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalHand(myHand), 4, "Hand is not a flush!");
	}
	@Test
	void threecardlogicFlush2() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('H', 4);
		Card b = new Card('S', 9);
		Card c = new Card('H', 6);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertNotEquals(ThreeCardLogic.evalHand(myHand), 4, "Hand is a flush!");
	}
	@Test
	void threecardlogicPair1() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('H', 4);
		Card b = new Card('H', 4);
		Card c = new Card('D', 14);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalHand(myHand), 5, "Hand is not a pair!");
	}
	@Test
	void threecardlogicPair2() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('H', 4);
		Card b = new Card('S', 4);
		Card c = new Card('D', 14);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalHand(myHand), 5, "Hand is not a pair!");
	}
	// Tests straight flush
	@Test
	void threecardlogicEvalPPWinnings1() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('H', 4);
		Card b = new Card('H', 5);
		Card c = new Card('H', 6);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 100), 4000, "Bet returned is not 4000");
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 50), 2000, "Bet returned is not 2000");
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 25), 1000, "Bet returned is not 1000");
	}
	// Tests Three-of-a-Kind
	@Test
	void threecardlogicEvalPPWinnings2() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('H', 4);
		Card b = new Card('S', 4);
		Card c = new Card('H', 4);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 100), 3000, "Bet returned is not 3000");
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 50), 1500, "Bet returned is not 1500");
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 25), 750, "Bet returned is not 750");
	}
	// Tests Straight
	@Test
	void threecardlogicEvalPPWinnings3() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('D', 4);
		Card b = new Card('S', 5);
		Card c = new Card('H', 6);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 100), 600, "Bet returned is not 600");
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 50), 300, "Bet returned is not 300");
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 25), 150, "Bet returned is not 150");
	}
	//Tests flush
	@Test
	void threecardlogicEvalPPWinnings4() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('S', 4);
		Card b = new Card('S', 14);
		Card c = new Card('S', 9);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 100), 300, "Bet returned is not 300");
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 50), 150, "Bet returned is not 150");
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 25), 75, "Bet returned is not 75");
	}
	//tests pair
	@Test
	void threecardlogicEvalPPWinnings5() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('D', 4);
		Card b = new Card('S', 4);
		Card c = new Card('S', 9);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 100), 100, "Bet returned is not 100");
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 50), 50, "Bet returned is not 50");
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 25), 25, "Bet returned is not 25");
	}
	//tests losing
	@Test
	void threecardlogicEvalPPWinnings6() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('D', 4);
		Card b = new Card('S', 5);
		Card c = new Card('H', 9);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 100), 0, "Player actually won!");
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 50), 0, "Player actually won!");
		assertEquals(ThreeCardLogic.evalPPWinnings(myHand, 25), 0, "Player actually won!");
	}
	// Test dealer win
	@Test
	void threecardlogicCompareHands1() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('D', 4);
		Card b = new Card('S', 5);
		Card c = new Card('H', 9);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);

		ArrayList<Card> dealer = new ArrayList<>(3);
		Card d = new Card('D', 4);
		Card e = new Card('D', 5);
		Card f = new Card('D', 6);
		dealer.add(d);
		dealer.add(e);
		dealer.add(f);
		assertEquals(ThreeCardLogic.compareHands(dealer, myHand), 1, "The player actually won when dealer has a better hand");
	}
	// test player win
	@Test
	void threecardlogicCompareHands2() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('D', 4);
		Card b = new Card('D', 5);
		Card c = new Card('D', 6);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);

		ArrayList<Card> dealer = new ArrayList<>(3);
		Card d = new Card('H', 4);
		Card e = new Card('C', 7);
		Card f = new Card('D', 6);
		dealer.add(d);
		dealer.add(e);
		dealer.add(f);
		assertEquals(ThreeCardLogic.compareHands(dealer, myHand), 2, "Dealer won when player should have won");
	}
	// Tests ties
	@Test
	void threecardlogicCompareHands3() {
		ArrayList<Card> myHand = new ArrayList<>(3);
		Card a = new Card('D', 4);
		Card b = new Card('D', 5);
		Card c = new Card('D', 6);
		myHand.add(a);
		myHand.add(b);
		myHand.add(c);

		ArrayList<Card> dealer = new ArrayList<>(3);
		Card d = new Card('H', 4);
		Card e = new Card('H', 6);
		Card f = new Card('H', 5);
		dealer.add(d);
		dealer.add(e);
		dealer.add(f);
		assertEquals(ThreeCardLogic.compareHands(dealer, myHand), 0, "A Tie should have happened but didnt");
	}

	//MC test cases 
	@Test
	void dealer_deals_deckRefresh(){
		theDealer.dealersHand = theDealer.dealHand();
		Player thePlayer = new Player();
		for(int i = 0; i < 5; i++){
			thePlayer.hand = theDealer.dealHand();
			thePlayer.hand.clear();
		}
		assertEquals(52, theDealer.theDeck.size());
	}

	@Test
	void straight_flush_test(){
		myHand.add(new Card('H',11));
		myHand.add(new Card( 'H', 13));
		myHand.add(new Card( 'H', 12));
		assertEquals(1, ThreeCardLogic.evalHand(myHand));
	}

	@Test
	void not_straight_flush_test(){
		myHand.add(new Card('H', 13));
		myHand.add(new Card('H', 1));
		myHand.add(new Card('H', 12));
		assertNotEquals(1, ThreeCardLogic.evalHand(myHand));
	}

	@Test
	void threeofkind_test(){
		myHand.add(new Card('H',11));
		myHand.add(new Card( 'C', 11));
		myHand.add(new Card( 'S', 11));
		assertEquals(2, ThreeCardLogic.evalHand(myHand));
	}

	@Test
	void not_threeofkind_test(){
		myHand.add(new Card( 'H', 11));
		myHand.add(new Card( 'C', 10));
		myHand.add(new Card( 'S', 11));
		assertNotEquals(2, ThreeCardLogic.evalHand(myHand));
	}

	@Test
	void straight_test(){
		myHand.add(new Card( 'H', 1));
		myHand.add(new Card( 'C', 3));
		myHand.add(new Card( 'S', 2));
		assertEquals(3, ThreeCardLogic.evalHand(myHand));

	}

	@Test
	void not_straight_test(){
		myHand.add(new Card( 'S', 1));
		myHand.add(new Card( 'S', 3));
		myHand.add(new Card( 'S', 2));
		assertNotEquals(3, ThreeCardLogic.evalHand(myHand));
	}

	@Test
	void flush_test(){
		myHand.add(new Card( 'H', 1));
		myHand.add(new Card( 'H', 13));
		myHand.add(new Card( 'H', 5));
		assertEquals(4, ThreeCardLogic.evalHand(myHand));
	}

	@Test
	void not_flush_test(){
		myHand.add(new Card( 'H', 3));
		myHand.add(new Card( 'H', 2));
		myHand.add(new Card( 'H', 4));
		assertNotEquals(4, ThreeCardLogic.evalHand(myHand));
	}

	@Test
	void pair_test(){
		myHand.add(new Card( 'S', 13));
		myHand.add(new Card( 'H', 13));
		myHand.add(new Card( 'H', 5));
		assertEquals(5, ThreeCardLogic.evalHand(myHand));
	}

	@Test
	void not_pair_test(){
		myHand.add(new Card( 'S', 3));
		myHand.add(new Card( 'H', 2));
		myHand.add(new Card( 'C', 4));
		assertNotEquals(5, ThreeCardLogic.evalHand(myHand));
	}

	@Test
	void high_card_test(){
		myHand.add(new Card( 'H', 3));
		myHand.add(new Card( 'S', 13));
		myHand.add(new Card( 'D', 4));
		assertEquals(0, ThreeCardLogic.evalHand(myHand));
	}

	@Test
	void not_high_card_test(){
		myHand.add(new Card( 'H', 13));
		myHand.add(new Card( 'S', 13));
		myHand.add(new Card( 'D', 4));
		assertNotEquals(0, ThreeCardLogic.evalHand(myHand));
	}

	@Test
	void straight_flush_eval_ppl_test(){
		myHand.add(new Card('H',11));
		myHand.add(new Card( 'H', 13));
		myHand.add(new Card( 'H', 12));
		assertEquals(400, ThreeCardLogic.evalPPWinnings(myHand, 10));


	}

	@Test
	void threeofkind_eval_ppl_test(){
		myHand.add(new Card('H',11));
		myHand.add(new Card( 'C', 11));
		myHand.add(new Card( 'S', 11));
		assertEquals(300, ThreeCardLogic.evalPPWinnings(myHand, 10));
	}

	@Test
	void straight_eval_ppl_test(){
		myHand.add(new Card( 'H', 1));
		myHand.add(new Card( 'C', 3));
		myHand.add(new Card( 'S', 2));
		assertEquals(60, ThreeCardLogic.evalPPWinnings(myHand, 10));
	}

	@Test
	void flush_eval_ppl_test(){
		myHand.add(new Card( 'H', 1));
		myHand.add(new Card( 'H', 13));
		myHand.add(new Card( 'H', 5));
		assertEquals(30, ThreeCardLogic.evalPPWinnings(myHand, 10));
	}

	@Test
	void pair_eval_ppl_test(){
		myHand.add(new Card( 'S', 13));
		myHand.add(new Card( 'H', 13));
		myHand.add(new Card( 'H', 5));
		assertEquals(10, ThreeCardLogic.evalPPWinnings(myHand, 10));
	}

	@Test
	void high_card_eval_ppl_test(){
		myHand.add(new Card( 'H', 3));
		myHand.add(new Card( 'S', 13));
		myHand.add(new Card( 'D', 4));
		assertEquals(0, ThreeCardLogic.evalPPWinnings(myHand, 10));
	}

	@Test
	void compareHands_draw(){
		theDealer.dealersHand = new ArrayList<>();
		theDealer.dealersHand.add(new Card('H', 11));
		theDealer.dealersHand.add(new Card( 'H', 13));
		theDealer.dealersHand.add(new Card( 'H', 12));
		myHand.add(new Card('C',11));
		myHand.add(new Card( 'C', 13));
		myHand.add(new Card( 'C', 12));
		assertEquals(0, ThreeCardLogic.compareHands(theDealer.dealersHand, myHand));
	}

	@Test
	void compareHands_dealerWin(){
		theDealer.dealersHand = new ArrayList<>();
		theDealer.dealersHand.add(new Card('H', 11));
		theDealer.dealersHand.add(new Card( 'H', 13));
		theDealer.dealersHand.add(new Card( 'H', 12));
		myHand.add(new Card('C',11));
		myHand.add(new Card( 'H', 11));
		myHand.add(new Card( 'C', 12));
		assertEquals(1, ThreeCardLogic.compareHands(theDealer.dealersHand, myHand));
		myHand.clear();
		myHand.add(new Card( 'H', 3));
		myHand.add(new Card( 'S', 13));
		myHand.add(new Card( 'D', 4));
		assertEquals(1, ThreeCardLogic.compareHands(theDealer.dealersHand, myHand));
	}

	@Test
	void compareHands_playerWin(){
		theDealer.dealersHand = new ArrayList<>();
		theDealer.dealersHand.add(new Card('C', 11));
		theDealer.dealersHand.add(new Card( 'H', 11));
		theDealer.dealersHand.add(new Card( 'C', 12));
		myHand.add(new Card('H',11));
		myHand.add(new Card( 'H', 13));
		myHand.add(new Card( 'H', 12));
		assertEquals(2, ThreeCardLogic.compareHands(theDealer.dealersHand, myHand));
		theDealer.dealersHand.clear();
		theDealer.dealersHand.add(new Card( 'H', 3));
		theDealer.dealersHand.add(new Card( 'S', 13));
		theDealer.dealersHand.add(new Card( 'D', 4));
		assertEquals(2, ThreeCardLogic.compareHands(theDealer.dealersHand, myHand));
	}

}




}
