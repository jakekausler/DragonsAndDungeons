package spells;

import map.Point;
import map.Tile;

public abstract class Shape {
	public Point origin;
	
	public Shape(Point o) {
		origin = o;
	}
	
	public abstract Tile[] GetEffectedTiles();
}
