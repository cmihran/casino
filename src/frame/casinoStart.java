package frame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class casinoStart extends JComponent implements casinoInterface {
	// coordinate values
	final int DISPLAY_WIDTH;
	final int DISPLAY_HEIGHT;

	// gamemodes
	int curMode = 0;
	private final int MODE_BLACKJACK = 0;
	private final int MODE_WAR = 1;

	// JComponents
	private StartButton buttonStart;
	private gmSelect dropdownMode;
	private java.net.URL titleURL = this.getClass().getResource("/title.png");

	// Colors
	final Color feltGreen = casinoMain.bg;

	public casinoStart(int width, int height) {
		DISPLAY_WIDTH = width;
		DISPLAY_HEIGHT = height;
		init();
	}


	public void init() {
		setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);

		// Start Button
		buttonStart = new StartButton();
		buttonStart.setBounds(DISPLAY_WIDTH / 2 - casinoMain.bWidth / 2, DISPLAY_HEIGHT
				/ 2 -  casinoMain.bHeight / 2, casinoMain.bWidth,  casinoMain.bHeight);
		add(buttonStart);
		buttonStart.setVisible(true);

		// GameMode Drop Down
		dropdownMode = new gmSelect();
		dropdownMode.setBounds(buttonStart.getX(),
				buttonStart.getY() + casinoMain.bHeight, casinoMain.bWidth, casinoMain.bHeight);
		dropdownMode.setBackground(feltGreen);
		add(dropdownMode);
		dropdownMode.setVisible(true);

		/*
		// Game Logo
		ImageIcon titleIcon = new ImageIcon(titleURL);
		JLabel titleLabel = new JLabel(titleIcon);
		titleLabel.setBounds(
				DISPLAY_WIDTH / 2 - titleIcon.getIconWidth() / 2,
				DISPLAY_HEIGHT / 2 - titleIcon.getIconHeight()
						- buttonStart.getHeight(), titleIcon.getIconWidth(),
				titleIcon.getIconHeight());
		add(titleLabel);
		titleLabel.setVisible(true);
		*/
		
		repaint();

	}

	private class StartButton extends JButton implements ActionListener {
		StartButton() {
			super("Play");
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
			if(curMode == MODE_BLACKJACK) casinoMain.modeBlackjack();
		}
	}

	private class gmSelect extends JPanel implements ActionListener {
		String[] presets = { "Blackjack", "War", "etc.." };
		JComboBox presetBox = new JComboBox(presets);

		gmSelect() {
			presetBox.setSelectedIndex(0);
			presetBox.addActionListener(this);
			add(presetBox);
		}

		public void actionPerformed(ActionEvent event) {
			if ((presetBox.getSelectedItem()).equals("Blackjack")) {
				curMode = MODE_BLACKJACK;
			}
			if ((presetBox.getSelectedItem()).equals("War")) {
				curMode = MODE_WAR;
			}
		}
	}
}
