package logic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class Hand extends ArrayList<Card> {
	String name;

	public Hand(String name) {
		this.name = name;
	}

	public int getSum() {
		int sum = 0;
		for (int i = 0; i < this.size(); i++) {
			sum += this.get(i).getValue();
		}
		return sum;
	}

	@Override
	public String toString() {
		String retval = name + "'s Cards: ";
		for (int i = 0; i < this.size(); i++) {
			retval += ("[" + this.get(i) + "] ");
		}
		return retval;
	}

	public boolean isBlackjack() {
		return (this.size() == 2 && this.getSum() == 21);
	}

	public boolean hasAce() {
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).isAce())
				return true;
		}
		return false;
	}

	public Image toImage() throws IOException {

		BufferedImage[] images = new BufferedImage[this.size()];

		for (int i = 0; i < this.size(); i++) {
			String imgLoc = "/pictures/" + this.get(i).getPhotoName();
			java.net.URL imgURL = this.getClass().getResource(imgLoc);
			images[i] = ImageIO.read(imgURL);
		}

		int width = images[0].getWidth() * this.size();
		int height = images[0].getHeight();
		BufferedImage result = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = result.getGraphics();

		int x = 0;
		for (BufferedImage image: images) {
			g.drawImage(image, x, 0, null);
			x += images[0].getWidth();
		}

		return result;
	}

}