package map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Tile {
	private Point origin;
	
	private static Random random = new Random();
	
	private BufferedImage image;
	
	public Tile(Point o, String imagePath) {
		origin = o;
		File imageSrc = new File(imagePath);
		try {
			image = ImageIO.read(imageSrc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g, int x, int y, int width) {
		g.drawImage(image, x, y, width, width, null);
	}
	
	@Override
	public String toString() {
		return "Coordinates: " + origin.toString();
	}

}
