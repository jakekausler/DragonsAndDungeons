package characters;

import races.Race;
import classes.Class;
import equipment.Equipment;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import backgrounds.Background;

public class Character {
	
	private enum Abilities {
		STRENGTH,
		DEXTERITY,
		CONSTITUTION,
		WISDOM,
		INTELLIGENCE,
		CHARISMA
	}
	
	private enum Skills {
		ACROBATICS,
		ARCANA,
		ATHLETICS,
		DECEPTION,
		HISTORY,
		INSIGHT,
		INTIMIDATION,
		INVESTIGATION,
		MEDICINE,
		NATURE,
		PERCEPTION,
		PERFORMANCE,
		PERSUASION,
		RELIGION,
		SLEIGHT_OF_HAND,
		STEALTH,
		SURVIVAL
	}
	
	/*
	 * Map of Level -> Experience needed for next level
	 */
	private static final Map<Integer, Integer> ExperienceTable;
    static {
        Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
        m.put(1, 300);
        m.put(2, 900);
        m.put(3, 2700);
        m.put(4, 6500);
        m.put(5, 14000);
        m.put(6, 23000);
        m.put(7, 34000);
        m.put(8, 48000);
        m.put(9, 64000);
        m.put(10, 85000);
        m.put(11, 100000);
        m.put(12, 120000);
        m.put(13, 140000);
        m.put(14, 165000);
        m.put(15, 195000);
        m.put(16, 225000);
        m.put(17, 265000);
        m.put(18, 305000);
        m.put(19, 355000);
        m.put(20, Integer.MAX_VALUE);
        ExperienceTable = Collections.unmodifiableMap(m);
    }
    
    /*
     * Map of Level -> Proficiency Bonus
     */
    private static final Map<Integer, Integer> ProficiencyTable;
    static {
        Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
        m.put(1, 0);
        m.put(2, 300);
        m.put(3, 900);
        m.put(4, 2700);
        m.put(5, 6500);
        m.put(6, 14000);
        m.put(7, 23000);
        m.put(8, 34000);
        m.put(9, 48000);
        m.put(10, 64000);
        m.put(11, 85000);
        m.put(12, 100000);
        m.put(13, 120000);
        m.put(14, 140000);
        m.put(15, 165000);
        m.put(16, 195000);
        m.put(17, 225000);
        m.put(18, 265000);
        m.put(19, 305000);
        m.put(20, 355000);
        ProficiencyTable = Collections.unmodifiableMap(m);
    }
	
	private int[] abilityScores;
	
	private boolean[] savingProficiencies;
	
	private boolean[] skillProficiencies;
	
	private Race race;
	private Class[] classes;
	private Background background;
	
	private int experience;
	
	private Equipment equipment;
	
	private int naturalArmorClass;
	
	private boolean hasInspiration;
	
	public Character() {
		abilityScores = new int[] {0, 0, 0, 0, 0, 0};
	}
	
	public int GetCharacterLevel() {
		for (int key : ExperienceTable.keySet()) {
			if (experience < ExperienceTable.get(key)) {
				return key;
			}
		}
		return ExperienceTable.values().stream().max(Integer::compare).get();
	}
	
	public int GetProficiency() {
		return ProficiencyTable.get(GetCharacterLevel());
	}
	
	public int GetArmorClass() {
		return naturalArmorClass + equipment.GetArmorClass();
	}
	
	public int GetInitiative() {
		return GetModifiers()[Abilities.DEXTERITY.ordinal()];
	}
	
	public int[] GetModifiers() {
		int[] modifiers = new int[6];
		for (int i = 0; i < abilityScores.length; i++) {
			modifiers[i] = (abilityScores[i]-10)/2;
		}
		return modifiers;
	}
	
}
