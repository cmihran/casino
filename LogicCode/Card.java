
public class Card {
	int value;
	String label;
	String suit;
	
	public Card(int value, String label, String suit){
		this.value = value;
		this.label = label;
		this.suit = suit;
	}
	
	public int getValue(){
		return value;
	}
	
	public String getLabel(){
		return label;
	}
	
	public String getSuit(){
		return suit;
	}
	
	public void printCard(){
		System.out.println(this.toString());
	}
	
	public String toString(){
		return label + " of " + suit;
	}
}
