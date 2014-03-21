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

public class casinoBlackjack extends JComponent implements casinoInterface {
	final int DISPLAY_WIDTH;
	final int DISPLAY_HEIGHT;
	final int buttonOffset = 10;
	
	BackButton buttonBack;
	StayButton buttonStay;
	HitButton buttonHit;

	Deck deck;
	Hand player;
	Hand dealer;
	
	JLabel txt = new JLabel();

	public casinoBlackjack(int width, int height) {
		DISPLAY_WIDTH = width;
		DISPLAY_HEIGHT = height;
		init();
	}
	
	public void newCards(){
		deck = new Deck();
		player = new Hand("Player");
		dealer = new Hand("Dealer");
		
		dealer.add(deck.getACard());
		dealer.add(deck.getACard());
		
		player.add(deck.getACard());
		player.add(deck.getACard());
		
		txt.setText("<html>" + dealer.toString() 
				+ "<br>Dealer Sum: " + dealer.getSum()
				+ "<br>" + player.toString()
				+ "<br>Player Sum: " + player.getSum() + "</html>");
		Font font = new Font("Arial", Font.PLAIN, 20);
		txt.setFont(font);
		txt.setForeground(Color.WHITE);
		add(txt);
		txt.setBounds(100,100, 500,100);
		txt.setVisible(true);
	}

	public void init() {
		setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);

		buttonBack = new BackButton();
		System.out.println(casinoMain.height + " " + casinoMain.bHeight);
		buttonBack.setBounds(0+buttonOffset, (casinoMain.height - 2*casinoMain.bHeight) -buttonOffset, casinoMain.bWidth, casinoMain.bHeight);
		add(buttonBack);
		buttonBack.setVisible(true);
		
		buttonStay = new StayButton();
		//finish buttonBack.setBounds(0, 0, casinoMain.bWidth, casinoMain.bHeight);
		add(buttonBack);
		buttonBack.setVisible(true);

		newCards();

	}

	private class BackButton extends JButton implements ActionListener {
		BackButton() {
			super("Back");
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
			newCards();
			casinoMain.modeStart();
		}
	}
	
	private class HitButton extends JButton implements ActionListener {
		HitButton() {
			super("Hit");
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	private class StayButton extends JButton implements ActionListener {
		StayButton() {
			super("Stay");
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
}
