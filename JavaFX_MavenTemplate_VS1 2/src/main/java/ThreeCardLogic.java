import java.util.ArrayList;
import java.io.*; 
import java.util.*;
public class ThreeCardLogic {
	
	// Evaluates the hand of a player object and determines the score for it
	public static int evalHand(ArrayList<Card> hand) {
		ArrayList<Card> tempHand = sortHand(hand);
			
		// Straight Flush
		if ((tempHand.get(0).value++ == tempHand.get(1).value && tempHand.get(1).value == tempHand.get(1).value--) && (hand.get(0).suit == hand.get(1).suit || hand.get(1).suit == hand.get(2).suit || hand.get(0).suit == hand.get(2).suit)) {
			return 1;
		}
		// 3 of a kind
		if (tempHand.get(0).suit == tempHand.get(1).suit && tempHand.get(1).suit == tempHand.get(1).suit) {
			return 2;
		}
		if (tempHand.get(0).value++ == tempHand.get(1).value && tempHand.get(1).value == tempHand.get(1).value--) {
			return 3;
		}
		// Flush
		if (hand.get(0).suit == hand.get(1).suit || hand.get(1).suit == hand.get(2).suit || hand.get(0).suit == hand.get(2).suit) {
			return 4;
		}
		// Pair
		if (hand.get(0).value == hand.get(1).value || hand.get(1).value == hand.get(2).value || hand.get(0).value == hand.get(2).value) {
			return 5;
		}
		
		return 0;
		
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
		int dInt = evalHand(dealer);
		int pInt = evalHand(player);
		if (dInt == pInt) {return 0;}
		if (dInt > pInt) {return 1;}
		if (dInt < pInt) {return 2;}
		// shouldn't get here...
		return 0;
	}
	
	// Sorts the hand from smallest to biggest
	public static ArrayList<Card> sortHand(ArrayList<Card> hand) {
		ArrayList<Card> sortedHand = new ArrayList<Card>(3);
		Card min = hand.get(0);

		for (int j = 0; j < hand.size(); j++) {
			for (int i = 0; i < hand.size(); i++) {
				if (min.value > hand.get(i).value) {
					min = hand.get(i);
				}
			}
			sortedHand.add(min);
		
		}
		return sortedHand;
	}
}
