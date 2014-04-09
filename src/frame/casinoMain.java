package frame;
import java.awt.Color;

import javax.swing.JFrame;

public class casinoMain {
	final static Color bg = new Color(0, 102, 0);
	private static JFrame f = new JFrame();
	public final static int width = 800;
	public final static int height = 700;
	private static casinoStart casStart = new casinoStart(width, height);
	private static casinoBlackjack casBJ = new casinoBlackjack(width, height);
	
	public final static int bWidth = 100;
	public final static int bHeight = 36;

	public static void main(String[] args) {
		f.setSize(width, height);
		f.getContentPane().setBackground(bg);
		f.setLayout(null);
		f.add(casStart);
		f.add(casBJ);
		casBJ.setVisible(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Casino Alpha 1");
		f.setVisible(true);

	}
	
	public static void modeStart() {
		casStart.setVisible(true);
		casBJ.setVisible(false);
		f.setTitle("Casino Alpha 1");
	}

	public static void modeBlackjack() {
		casStart.setVisible(false);
		casBJ.setVisible(true);
		f.setTitle("Casino Alpha 1 - Blackjack");
	}
}
