public class Deck {
	String[] labels = { 
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
			"Queen", "King", "Ace"
	};
	int LABEL_TWO = 0;
	int LABEL_THREE = 1;
	int LABEL_FOUR = 2;
	int LABEL_FIVE = 3;
	int LABEL_SIX = 4;
	int LABEL_SEVEN = 5;
	int LABEL_EIGHT = 6;
	int LABEL_NINE = 7;
	int LABEL_TEN = 8;
	int LABEL_JACK = 9;
	int LABEL_QUEEN = 10;
	int LABEL_KING = 11;
	int LABEL_ACE = 12;
	
	String[] suits = {
			"Club", "Diamond", "Heart", "Spade" 
	};
	
	int SUIT_CLUB = 0;
	int SUIT_DIAMOND = 1;
	int SUIT_HEART = 2;
	int SUIT_SPADE = 3;
	
	Card[] Clubs = new Card[13];
	Card[] Diamonds = new Card[13];
	Card[] Hearts = new Card[13];
	Card[] Spades = new Card[13];
	
	public Deck() {
		//Clubs
		for(int i = 2; i < 9; i++){
			Clubs[i-2] = new Card(i, labels[i-2], suits[SUIT_CLUB]);
		}
		for(int i  = 9; i < 13; i++){
			Clubs[i] = new Card(10, labels[i], suits[SUIT_CLUB]);
		}
		Clubs[13] = new Card(10, labels[13], suits[SUIT_CLUB]);
		
		//Diamonds
		for(int i = 2; i < 9; i++){
			Diamonds[i-2] = new Card(i, labels[i-2], suits[SUIT_DIAMOND]);
		}
		for(int i  = 9; i < 13; i++){
			Diamonds[i] = new Card(10, labels[i], suits[SUIT_DIAMOND]);
		}
		Diamonds[13] = new Card(10, labels[13], suits[SUIT_DIAMOND]);
		
		//Hearts
		for(int i = 2; i < 9; i++){
			Hearts[i-2] = new Card(i, labels[i-2], suits[SUIT_HEART]);
		}
		for(int i  = 9; i < 13; i++){
			Hearts[i] = new Card(10, labels[i], suits[SUIT_HEART]);
		}
		Hearts[13] = new Card(10, labels[13], suits[SUIT_HEART]);
		
		//Spades
		for(int i = 2; i < 9; i++){
			Spades[i-2] = new Card(i, labels[i-2], suits[SUIT_SPADE]);
		}
		for(int i  = 9; i < 13; i++){
			Spades[i] = new Card(10, labels[i], suits[SUIT_SPADE]);
		}
		Spades[13] = new Card(10, labels[13], suits[SUIT_SPADE]);
	}
	
	public Card getACard(){
		//TO-DO
	}
	
}
