public class Deck {
	String[] labels = { 
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
			"Queen", "King", "Ace"
	};
	public final static int LABEL_TWO = 0;
	public final static int LABEL_THREE = 1;
	public final static int LABEL_FOUR = 2;
	public final static int LABEL_FIVE = 3;
	public final static int LABEL_SIX = 4;
	public final static int LABEL_SEVEN = 5;
	public final static int LABEL_EIGHT = 6;
	public final static int LABEL_NINE = 7;
	public final static int LABEL_TEN = 8;
	public final static int LABEL_JACK = 9;
	public final static int LABEL_QUEEN = 10;
	public final static int LABEL_KING = 11;
	public final static int LABEL_ACE = 12;
	
	String[] suits = {
			"Club", "Diamond", "Heart", "Spade" 
	};
	
	public final static int SUIT_CLUB = 0;
	public final static int SUIT_DIAMOND = 1;
	public final static int SUIT_HEART = 2;
	public final static int SUIT_SPADE = 3;
	
	/*
	Card[] Clubs = new Card[13];
	Card[] Diamonds = new Card[13];
	Card[] Hearts = new Card[13];
	Card[] Spades = new Card[13];
	*/
	
	Card[][] deck = new Card[4][13];
	
	public Deck() {
		for(int z = 0; z < deck.length; z++){
			for(int i = 0; i < 9; i++){
				i[z][i] = new Card(i+2, labels[i], suits[z]);
			}
			for(int i  = 9; i < 12; i++){
				deck[z][i-2] = new Card(10, labels[i], suits[z]);
			}
			deck[z][12] = new Card(11, labels[12], suits[z]);
		}
		/*
		//Clubs
		for(int i = 2; i < 9; i++){
			Clubs[i-2] = new Card(i, labels[i-2], suits[SUIT_CLUB]);
		}
		for(int i  = 9; i < 13; i++){
			Clubs[i] = new Card(10, labels[i], suits[SUIT_CLUB]);
		}
		Clubs[13] = new Card(11, labels[13], suits[SUIT_CLUB]);
		
		//Diamonds
		for(int i = 2; i < 9; i++){
			Diamonds[i-2] = new Card(i, labels[i-2], suits[SUIT_DIAMOND]);
		}
		for(int i  = 9; i < 13; i++){
			Diamonds[i] = new Card(10, labels[i], suits[SUIT_DIAMOND]);
		}
		Diamonds[13] = new Card(11, labels[13], suits[SUIT_DIAMOND]);
		
		//Hearts
		for(int i = 2; i < 9; i++){
			Hearts[i-2] = new Card(i, labels[i-2], suits[SUIT_HEART]);
		}
		for(int i  = 9; i < 13; i++){
			Hearts[i] = new Card(10, labels[i], suits[SUIT_HEART]);
		}
		Hearts[13] = new Card(11, labels[13], suits[SUIT_HEART]);
		
		//Spades
		for(int i = 2; i < 9; i++){
			Spades[i-2] = new Card(i, labels[i-2], suits[SUIT_SPADE]);
		}
		for(int i  = 9; i < 13; i++){
			Spades[i] = new Card(10, labels[i], suits[SUIT_SPADE]);
		}
		Spades[13] = new Card(11, labels[13], suits[SUIT_SPADE]);
		*/
	}
	
	public Card getACard(){
		int randomSuit = (int) Math.random() * 4;
		int randomCard = (int) Math.random() * 13;
		return deck[randomSuit][randomCard];
	}
	
	public void printDeck(){
		for(int z = 0; z < 4; z++){
			for(int i = 0; i < 13; i++){
				deck[z][i].printCard();
			}	
		}
		/*
		//Clubs
		for(int i = 0; i < Clubs.length; i++){
			Clubs[i].printCard();
		}
		//Diamonds
		for(int i = 0; i < Diamonds.length; i++){
			Diamonds[i].printCard();
		}
		//Hearts
		for(int i = 0; i < Hearts.length; i++){
			Hearts[i].printCard();
		}
		//Spades
		for(int i = 0; i < Spades.length; i++){
			Spades[i].printCard();
		}
		*/
	}
	
}
