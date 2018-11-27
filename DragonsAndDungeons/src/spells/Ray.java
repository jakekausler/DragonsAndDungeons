package spells;

import map.Point;
import map.Tile;

public abstract class Ray extends Shape {

	private int length;
	private int direction;
	
	public Ray(Point o, int l, int d) { 
		super(o);
		length = l;
		direction = d;
	}

}
