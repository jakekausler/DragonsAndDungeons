package equipment.items.armor;

import equipment.items.ArmorClassEffector;
import equipment.items.Item;

public class Armor extends Item implements ArmorClassEffector {
	
	private int armorClassEffect;
	
	public Armor() {
		
	}
	
	public int GetArmorClassEffect() {
		return armorClassEffect;
	}
}
