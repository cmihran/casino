
public class Deck {
	String[] labels = { 
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
			"Queen", "King", "Ace"
	};
	
	String[] suits = {
			"Club", "Diamond", "Heart", "Spade" 
	};
	
	public Deck() {
		//Clubs
		Card[] Clubs = new Card[13];
		for(int i = 2; i < 9; i++){
			Clubs[i-2] = new Card(i, labels[i-2], suits[0]);
		}
		Clubs[9] = new Card(10, labels[9], suits[0]);
		Clubs[10] = new Card(10, labels[10], suits[0]);
	}
	
	public Card getACard(){
		
	}
	
}
