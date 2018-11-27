package spells;

import roll.Roll;

public abstract class Spell {
	private String name;
	private String description;
	
	private Shape shape;
	
	private Character[] currentTargets;
	
	private Roll damage;
	
	public abstract boolean CanTarget();
}
