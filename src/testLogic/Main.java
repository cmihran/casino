package testLogic;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.Deck;
import logic.Hand;

public class Main {
	public static void main(String[] args) throws IOException {
		Deck deck = new Deck();
		Hand player = new Hand("player");
		
		
		for(int i = 0; i < 52; i++){
			player.add(deck.getACard());
		}
		for(int i = 0; i < 52; i++){
			System.out.println(player.get(i).getPhotoName());
		}
		
		
		JFrame f = new JFrame();
		f.setLayout(null);
		f.setSize(5000,200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Test Logic");
		f.setVisible(true);
		
		System.out.println(player);
		
		ImageIcon img = new ImageIcon(player.toImage());
		JLabel imgLabel = new JLabel(img);
		f.add(imgLabel);
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		imgLabel.setVisible(true);
		
	}

}
