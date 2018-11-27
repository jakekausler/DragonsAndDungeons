package spells;

import map.Point;
import map.Tile;

public class Cone extends Ray {
	
	private double angle;

	public Cone(Point o, int l, int d, double a) {
		super(o, l, d);
		angle = a;
	}

	@Override
	public Tile[] GetEffectedTiles() {
		// TODO Auto-generated method stub
		return null;
	}

}
