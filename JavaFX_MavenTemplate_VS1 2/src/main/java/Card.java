
public class Card {

	public char suit;
	public int value;
	
	public Card(char s, int v) {
		this.suit = s;
		this.value = v;
	}
	
	//Getters/Setters for Card params
	public char getSuit() {return this.suit;}
	public void setSuit(char s) {this.suit = s;}
	public int getValue() {return this.value;}
	public void setValue(int v) {this.value = v;}
}
