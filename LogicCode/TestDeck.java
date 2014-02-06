
public class TestDeck {
	public static void main(String[] args){
		Deck dk = new Deck();
		for(int i = 0; i < 20; i++){
			System.out.println(dk.getACard());
			System.out.println(dk.getCardsLeft());
		}
	}
}
