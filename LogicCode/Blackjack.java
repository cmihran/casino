import java.util.Scanner;


public class Blackjack {
	
	public static void main(String[] args){
		Deck deck = new Deck();
		Hand player = new Hand("Player");
		Hand dealer = new Hand("Dealer");
		
		dealer.add(deck.getACard());
		dealer.add(deck.getACard());
		
		player.add(deck.getACard());
		player.add(deck.getACard());
		
		System.out.println(dealer.size());
		System.out.println(dealer);
		System.out.println("Dealer Sum: " + dealer.getSum());
		System.out.println(player);
		System.out.println("Player Sum: " + player.getSum());
		
		Scanner scannerino = new Scanner(System.in);
		System.out.println("Hit or stay?");
		String input = scannerino.next();
		if(input.equals("hit")){
			
		}
		if(input.equals("stay")){
			
		}
		
	}
}
