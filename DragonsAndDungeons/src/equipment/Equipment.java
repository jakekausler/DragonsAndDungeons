package equipment;

import java.util.ArrayList;
import java.util.HashSet;

import equipment.items.Item;

public class Equipment {

	private double gold;
	
	private ArrayList<Item> inventory;
	
	// Set of indices of enabled items (that have bonuses) in the inventory
	private HashSet<Integer> enabledItems;
	
	// Set of indices of weapons
	private HashSet<Integer> weapons;

	// Set of indices of weapons
	private HashSet<Integer> ammo;
	
	public Equipment() {
		//TODO
	}
	
	public int GetArmorClass() {
		//TODO: Calculate via enabled items
		return 0;
	}
	
}
