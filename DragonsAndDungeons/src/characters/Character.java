package characters;

import races.Race;
import classes.Class;
import backgrounds.Background;

public class Character {
	
	private int[] abilityScores;
	
	private Race race;
	private Class[] classes;
	private Background background;
	
	private int experience;
	
	public Character() {
		abilityScores = new int[] {0, 0, 0, 0, 0, 0};
		
	}
	
}
