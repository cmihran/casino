import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class casinoBlackjack extends JComponent implements casinoInterface {
	final int DISPLAY_WIDTH;
	final int DISPLAY_HEIGHT;
	
	BackButton buttonBack;
	
	public casinoBlackjack(int width, int height) {
		DISPLAY_WIDTH = width;
		DISPLAY_HEIGHT = height;
		init();
	}

	public void init() {
		setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
		
		buttonBack = new BackButton();
		buttonBack.setBounds(0,0,casinoMain.bWidth,casinoMain.bHeight);
		add(buttonBack);
		buttonBack.setVisible(true);

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
	
}
