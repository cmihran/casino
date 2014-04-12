package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import logic.Deck;
import logic.Hand;

@SuppressWarnings("serial")
public class casinoBlackjack extends JComponent implements casinoInterface {
	private final int DISPLAY_WIDTH;
	private final int DISPLAY_HEIGHT;
	private final int offsetSide = 10;

	BackButton buttonBack;
	StayButton buttonStay;
	HitButton buttonHit;
	ngButton buttonNewGame;

	Deck deck;
	Hand player;
	Hand dealer;

	ImageIcon playerImg;
	ImageIcon dealerImg;
	JLabel playerImgLabel;
	JLabel dealerImgLabel;

	JLabel pLbl = new JLabel("Your Cards:");
	JLabel dLbl = new JLabel("Dealer's Cards:");
	
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

		newCards();
		updateImages();

		pLbl.setFont(font);
		pLbl.setForeground(Color.WHITE);
		add(pLbl);
		pLbl.setBounds(casinoMain.width/2 - 200, 150, 150, 100);
		pLbl.setVisible(true);
		
		dLbl.setFont(font);
		dLbl.setForeground(Color.WHITE);
		add(dLbl);
		dLbl.setBounds(casinoMain.width/2 - 200, 0, 150, 100);
		dLbl.setVisible(true);
		
		
		buttonBack = new BackButton();
		System.out.println(casinoMain.height + " " + casinoMain.bHeight);
		buttonBack.setBounds(0 + offsetSide,
				(casinoMain.height - 2 * casinoMain.bHeight) - offsetSide,
				casinoMain.bWidth, casinoMain.bHeight);
		add(buttonBack);
		buttonBack.setVisible(true);

		buttonHit = new HitButton();
		buttonHit.setBounds(this.getWidth() / 2 - casinoMain.bWidth,
				(casinoMain.height - 3 * casinoMain.bHeight) - offsetSide,
				casinoMain.bWidth, casinoMain.bHeight);
		add(buttonHit);
		buttonHit.setVisible(true);

		buttonStay = new StayButton();
		buttonStay.setBounds(this.getWidth() / 2,
				(casinoMain.height - 3 * casinoMain.bHeight) - offsetSide,
				casinoMain.bWidth, casinoMain.bHeight);
		add(buttonStay);
		buttonStay.setVisible(true);

		txt.setFont(font);
		txt.setForeground(Color.WHITE);
		add(txt);
		txt.setBounds(50, 400, 500, 200);
		txt.setVisible(true);

		gameStatus.setFont(font);
		gameStatus.setForeground(Color.WHITE);
		add(gameStatus);
		gameStatus.setBounds(300, 250, 100, 100);
		gameStatus.setVisible(false);

		buttonNewGame = new ngButton();
		buttonNewGame.setBounds(this.getWidth() / 2 - casinoMain.bWidth / 2,
				(casinoMain.height - 2 * casinoMain.bHeight) - offsetSide,
				casinoMain.bWidth, casinoMain.bHeight);
		buttonNewGame.setEnabled(false);
		add(buttonNewGame);
		buttonNewGame.setVisible(true);

		// finish buttonBack.setBounds(0, 0, casinoMain.bWidth,
		// casinoMain.bHeight);
		add(buttonBack);
		buttonBack.setVisible(true);
	}

	public void updateImages() {
		try {
			playerImg = new ImageIcon(player.toImage());
			dealerImg = new ImageIcon(dealer.toImage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		playerImgLabel = new JLabel(playerImg);
		playerImgLabel.setBounds(
				casinoMain.width/2 - 200,
				100 + offsetSide + 110, 
				playerImg.getIconWidth(),
				playerImg.getIconHeight());
		add(playerImgLabel);
		playerImgLabel.setVisible(true);
		
		dealerImgLabel = new JLabel(dealerImg);
		dealerImgLabel.setBounds(
				casinoMain.width/2 - 200,
				0 + offsetSide + 70, 
				dealerImg.getIconWidth(),
				dealerImg.getIconHeight());
		add(dealerImgLabel);
		dealerImgLabel.setVisible(true);
		
		repaint();
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
		// if(dealer.hasAce() && dealer.getSum() < 21)

		if (player.getSum() > 21)
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

	public void stay() {
		if (player.getSum() > dealer.getSum())
			win();
		else
			lose();
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
			// buttonNewGame.setEnabled(false);
		}
	}

	public void resetGame() {
		newCards();
		cleanImages();
		updateImages();
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
			buttonPress();
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
			buttonPress();
			stay();
		}
	}
	
	public void buttonPress(){
		updateText();
		cleanImages();
		updateImages();
		checkStatus();
	}

	private void cleanImages() {
		remove(playerImgLabel);
		remove(dealerImgLabel);
		
	}

}