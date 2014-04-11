package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import logic.Deck;
import logic.Hand;
import logic.Card;

public class casinoBlackjack extends JComponent implements casinoInterface {
	final int DISPLAY_WIDTH;
	final int DISPLAY_HEIGHT;
	final int buttonOffset = 10;

	BackButton buttonBack;
	StayButton buttonStay;
	HitButton buttonHit;
	ngButton buttonNewGame;

	Deck deck;
	Hand player;
	Hand dealer;

	JLabel txt = new JLabel();
	JLabel gameStatus = new JLabel();
	
	public casinoBlackjack(int width, int height) {
		DISPLAY_WIDTH = width;
		DISPLAY_HEIGHT = height;
		init();
	}

	public void newCards() {
		deck = new Deck();
		player = new Hand("Player");
		dealer = new Hand("Dealer");

		dealer.add(deck.getACard());
		dealer.add(deck.getACard());

		player.add(deck.getACard());
		player.add(deck.getACard());

		updateText();
		checkStatus();
	}

	public void updateText() {
		txt.setText("<html>" + dealer.toString() + "<br>Dealer Sum: "
				+ dealer.getSum() + "<br>" + player.toString()
				+ "<br>Player Sum: " + player.getSum() + "</html>");
	}

	public void init() {
		Font font = new Font("Arial", Font.PLAIN, 20);
		setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);

		buttonBack = new BackButton();
		System.out.println(casinoMain.height + " " + casinoMain.bHeight);
		buttonBack.setBounds(0 + buttonOffset,
				(casinoMain.height - 2 * casinoMain.bHeight) - buttonOffset,
				casinoMain.bWidth, casinoMain.bHeight);
		add(buttonBack);
		buttonBack.setVisible(true);

		buttonHit = new HitButton();
		buttonHit.setBounds(100, 250, 100, 36);
		add(buttonHit);
		buttonHit.setVisible(true);

		buttonStay = new StayButton();
		buttonStay.setBounds(200, 250, 100, 36);
		add(buttonStay);
		buttonStay.setVisible(true);

		txt.setFont(font);
		txt.setForeground(Color.WHITE);
		add(txt);
		txt.setBounds(50, 50, 500, 200);
		txt.setVisible(true);

		gameStatus.setFont(font);
		gameStatus.setForeground(Color.WHITE);
		add(gameStatus);
		gameStatus.setBounds(300, 250, 100, 100);
		gameStatus.setVisible(false);

		buttonNewGame = new ngButton();
		buttonNewGame.setBounds(300,250,100,36);
		buttonNewGame.setEnabled(false);
		add(buttonNewGame);
		buttonNewGame.setVisible(true);
		
		// finish buttonBack.setBounds(0, 0, casinoMain.bWidth,
		// casinoMain.bHeight);
		add(buttonBack);
		buttonBack.setVisible(true);

		newCards();

		Hand test = new Hand("test");
		test.add(new Card(10,"Jack", "Hearts"));
		test.add(new Card(11,"Ace", "Hearts"));
		System.out.println(test.isBlackjack() + " test");
	}

	public void win() {
		gameStatus.setText("You win!");
		gameStatus.setVisible(true);

		buttonStay.setEnabled(false);
		buttonHit.setEnabled(false);
		buttonNewGame.setEnabled(true);
	}

	public void lose() {
		gameStatus.setText("You lose!");
		gameStatus.setVisible(true);

		buttonStay.setEnabled(false);
		buttonHit.setEnabled(false);
		buttonNewGame.setEnabled(true);
	}

	public void checkStatus() {
		//if(dealer.hasAce() && dealer.getSum() < 21)
		
		if(player.getSum() > 21) 
			lose();
		else if (player.isBlackjack() || player.getSum() == 21)
			win();
		else if (dealer.getSum() > 16 && player.getSum() > dealer.getSum())
			win();
		else if (player.getSum() == 21
				|| (dealer.getSum() > 21 && player.getSum() <= 21)) {
			win();
		} else if (player.getSum() > 21 || dealer.getSum() == 21) {
			lose();
		}
	}

	private class BackButton extends JButton implements ActionListener {
		BackButton() {
			super("Back");
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
			casinoMain.modeStart();
			resetGame();
		}
	}
	
	private class ngButton extends JButton implements ActionListener {
		ngButton() {
			super("New Game");
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
			resetGame();
			//buttonNewGame.setEnabled(false);
		}
	}

	public void resetGame() {
		newCards();
		gameStatus.setVisible(false);
		buttonHit.setEnabled(true);
		buttonStay.setEnabled(true);
	}

	private class HitButton extends JButton implements ActionListener {
		HitButton() {
			super("Hit");
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
			player.add(deck.getACard());
			if (dealer.getSum() <= 16) {
				dealer.add(deck.getACard());
			}
			updateText();
			checkStatus();
		}
	}

	private class StayButton extends JButton implements ActionListener {
		StayButton() {
			super("Stay");
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
			if (dealer.getSum() <= 16) {
				dealer.add(deck.getACard());
			}
			buttonHit.setEnabled(false);
			updateText();
			checkStatus();
		}
	}

}