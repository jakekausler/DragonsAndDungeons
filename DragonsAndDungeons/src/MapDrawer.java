
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import map.Area;
import map.Point;

public class MapDrawer extends Canvas implements KeyListener {
	
	public final static int MAX_ZOOM = 128;
	public final static int MIN_ZOOM = 2;
	public final static int MAX_SPEED= 20;
	public final static int MIN_SPEED = 1;
	
	
	private int zoom = 32;
	private int speed = 5;
	
	private int x = 0;
	private int y = 0;
	
	private Area area;
	
	public MapDrawer(Area area) {
		this.area = area;
		addKeyListener(this);
	}
	
	public void paint(Graphics g) {
		int x1 = x + getWidth();
		int y1 = y + getHeight();
		
		int xFirstTile = x/zoom;
		int yFirstTile = y/zoom;
		
		int xLastTile = x1/zoom;
		int yLastTile = y1/zoom;
		
		if (xLastTile >= area.getWidth()) {
			xLastTile = area.getWidth()-1;
		}
		if (yLastTile >= area.getHeight()) {
			yLastTile = area.getHeight()-1;
		}
		
		for (int xs=xFirstTile; xs <= xLastTile; xs++) {
			int xStart = xs*zoom - x;
			for (int ys=yFirstTile; ys <= yLastTile; ys++) {
				int yStart = ys*zoom - y;
				area.getTile(new Point(xs, ys)).draw(g, xStart, yStart, zoom);
			}
		}
		
	}
	
	public void zoomIn() {
		zoom *= 2;
		if (zoom > MAX_ZOOM) {
			zoom = MAX_ZOOM;
		}
		repaint();
	}
	
	public void zoomOut() {
		zoom /= 2;
		if (zoom < MIN_ZOOM) {
			zoom = MIN_ZOOM;
		}
		repaint();
	}
	
	public void speedDown() {
		speed -= 1;
		if (speed < MIN_SPEED) {
			speed = MIN_SPEED;
		}
		repaint();
	}
	
	public void speedUp() {
		speed += 1;
		if (speed < MAX_SPEED) {
			speed = MAX_SPEED;
		}
		repaint();
	}
	
	public void moveScreen(int deltaX, int deltaY) {
		x += deltaX*speed;
		y += deltaY*speed;
		if (x > zoom * area.getWidth() - getWidth()) {
			x = zoom * area.getWidth() - getWidth();
		}
		if (y > zoom * area.getHeight() - getHeight()) {
			y = zoom * area.getHeight() - getHeight();
		}
		if (x < 0) {
			x = 0;
		}
		if (y < 0) {
			y = 0;
		}
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'w':
			moveScreen(0, -1);
			break;
		case 's':
			moveScreen(0, 1);
			break;
		case 'a':
			moveScreen(-1, 0);
			break;
		case 'd':
			moveScreen(1, 0);
			break;
			
		case '=':
			zoomIn();
			break;
		case '-':
			zoomOut();
			break;
			
		case '.':
			speedUp();
			break;
		case ',':
			speedDown();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
}
