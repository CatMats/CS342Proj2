import java.util.ArrayList;
import java.io.*; 
import java.util.*;
public class ThreeCardLogic {
	
	// Evaluates the hand of a player object and determines the score for it..
	public static int evalHand(ArrayList<Card> hand) {
		ArrayList<Card> tempHand = hand;
		Collections.sort(tempHand, Comparator.comparingInt(Card::getValue));

			
		// Straight Flush
		if ((tempHand.get(0).value + 1 == tempHand.get(1).value && tempHand.get(1).value == tempHand.get(2).value - 1) && (hand.get(0).suit == hand.get(1).suit && hand.get(1).suit == hand.get(2).suit )) {
			return 1;
		}
		// 3 of a kind
		if (tempHand.get(0).value == tempHand.get(1).value && tempHand.get(1).value == tempHand.get(2).value) {
			return 2;
		}
		// Straight
		if (tempHand.get(0).value + 1 == tempHand.get(1).value && tempHand.get(1).value == tempHand.get(2 ).value - 1) {
			return 3;
		}
		// Flush
		if (hand.get(0).suit == hand.get(1).suit && hand.get(1).suit == hand.get(2).suit) {
			return 4;
		}
		// Pair
		if (hand.get(0).value == hand.get(1).value || hand.get(1).value == hand.get(2).value || hand.get(0).value == hand.get(2).value) {
			return 5;
		}
		
		return 0;
		
	}

	private static int evalWinner(ArrayList<Card> hand) {
		ArrayList<Card> tempHand = hand;
		Collections.sort(tempHand, Comparator.comparingInt(Card::getValue));


		// Straight Flush
		if ((tempHand.get(0).value + 1 == tempHand.get(1).value && tempHand.get(1).value == tempHand.get(2).value - 1) && (hand.get(0).suit == hand.get(1).suit && hand.get(1).suit == hand.get(2).suit )) {
			return 1;
		}
		// 3 of a kind
		if (tempHand.get(0).value == tempHand.get(1).value && tempHand.get(1).value == tempHand.get(2).value) {
			return 2;
		}
		// Straight
		if (tempHand.get(0).value + 1 == tempHand.get(1).value && tempHand.get(1).value == tempHand.get(2 ).value - 1) {
			return 3;
		}
		// Flush
		if (hand.get(0).suit == hand.get(1).suit && hand.get(1).suit == hand.get(2).suit) {
			return 4;
		}
		// Pair
		if (hand.get(0).value == hand.get(1).value || hand.get(1).value == hand.get(2).value || hand.get(0).value == hand.get(2).value) {
			return 5;
		}

		return 6;

	}
	
	// Evaluates the bet won for PairPlus Bet
	public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
		switch(evalHand(hand)) {
		case 0:return 0;
		case 1:return bet * 40;
		case 2:return bet * 30;
		case 3:return bet * 6;
		case 4:return bet * 3;
		case 5:return bet;
		}
		// shouldn't get here
		return 0;
	}
	// Compares the Dealer's hand to the player's hand
	public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) {
		int dInt = evalWinner(dealer);
		int pInt = evalWinner(player);
		if (dInt == pInt) {return 0;}
		if (dInt < pInt) {return 1;}
		return 2;
	}
}
