package logic;

import java.util.EmptyStackException;

public class Deck {
	private static String[] labels = { 
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
	
	private static String[] suits = {
			"Clubs", "Diamonds", "Hearts", "Spades" 
	};
	
	public final static int SUIT_CLUB = 0;
	public final static int SUIT_DIAMOND = 1;
	public final static int SUIT_HEART = 2;
	public final static int SUIT_SPADE = 3;
	
	private Card[][] deck = new Card[4][13];
	private int cardsLeft = 52;
	
	public Deck() {
		for(int z = 0; z < deck.length; z++){
			for(int i = 0; i < 9; i++){
				deck[z][i] = new Card(i+2, labels[i], suits[z]);
			}
			for(int i  = 9; i < 12; i++){
				deck[z][i] = new Card(10, labels[i], suits[z]);
			}
			deck[z][12] = new Card(11, labels[12], suits[z]);
		}
	}
	
	public Card getACard(){
		if(cardsLeft == 0) throw new EmptyStackException();
		
		int randomSuit = 0 + (int) (Math.random() * 4);
		int randomCard = 0 + (int) (Math.random() * 13);
		Card retval = deck[randomSuit][randomCard];
		
		while(retval.getAvail() == false){
			randomSuit = 0 + (int) (Math.random() * 4);
			randomCard = 0 + (int) (Math.random() * 13);
			retval = deck[randomSuit][randomCard];
			if(retval.getAvail() == true) {
				deck[randomSuit][randomCard].setAvail(false);
				break;
			}
		}
		cardsLeft--;
		return retval;
	}
	
	public int getCardsLeft(){
		return cardsLeft;
	}
	
	public void printDeck(){
		for(int z = 0; z < 4; z++){
			for(int i = 0; i < 13; i++){
				deck[z][i].printCard();
			}	
		}
	}

}
