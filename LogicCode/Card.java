public class Card {
	int value;
	String label;
	String suit;
	
	public Card(int value, String label, String suit){
		if(!isLegal(value, label suit)) throw new IllegalArgumentsException();
		this.value = value;
		this.label = label;
		this.suit = suit;
	}
	
	public boolean isLegal(int value, String label, String suit){
		boolean retval = false;
		//check value
		if(value < 0 || value > 11) retval = false;
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
