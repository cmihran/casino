import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class casinoBlackjack extends JComponent implements casinoInterface {
	final int DISPLAY_WIDTH;
	final int DISPLAY_HEIGHT;

	BackButton buttonBack;
	StayButton buttonStay;
	HitButton buttonHit;

	Deck deck = new Deck();
	Hand player = new Hand("Player");
	Hand dealer = new Hand("Dealer");

	public casinoBlackjack(int width, int height) {
		DISPLAY_WIDTH = width;
		DISPLAY_HEIGHT = height;
		init();
	}

	public void init() {
		setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);

		buttonBack = new BackButton();
		buttonBack.setBounds(0, 0, casinoMain.bWidth, casinoMain.bHeight);
		add(buttonBack);
		buttonBack.setVisible(true);
		
		buttonStay = new StayButton();
		//finish buttonBack.setBounds(0, 0, casinoMain.bWidth, casinoMain.bHeight);
		add(buttonBack);
		buttonBack.setVisible(true);

		
		//text
		dealer.add(deck.getACard());
		dealer.add(deck.getACard());
		
		player.add(deck.getACard());
		player.add(deck.getACard());
		
		JLabel txt = new JLabel();
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

	private class BackButton extends JButton implements ActionListener {
		BackButton() {
			super("Back");
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
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
