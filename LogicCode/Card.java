public class Card {
	int value;
	String label;
	String suit;
	boolean avail;
	
	public Card(int value, String label, String suit){
		if(!isLegal(value, label suit)) throw new IllegalArgumentsException();
		this.value = value;
		this.label = label;
		this.suit = suit;
		avail = true;
	}
	
	public Card(int x){
		if(x != -1) throw new IllegalArgumentsException();
		value = 0;
		label = Deck.labels[0];
		suit = Deck.suit[0];
		avail = false;
	}
	
	public boolean isLegal(int value, String label, String suit){
		boolean retval = false;
		//check value
		if(value < 0 || value > 11) return false;
		//check label
		for(int i = 0; i < Deck.labels.length; i++){
			if(Deck.labels[i].equals(label)) retval = true;
		}
		//check suit
		for(int i = 0; i < Deck.suits.length; i++){
			if(Deck.suits[i].equals(label)) retval = true;
		}
		return retval;
	}
	
	public boolean getAvail(){
		return avail;
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
