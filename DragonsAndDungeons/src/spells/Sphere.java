package spells;

import map.Point;
import map.Tile;

public class Sphere extends Shape {
	
	private int radius;

	public Sphere(Point o, int r) {
		super(o);
		radius = r;
	}

	@Override
	public Tile[] GetEffectedTiles() {
		// TODO Auto-generated method stub
		return null;
	}

}
