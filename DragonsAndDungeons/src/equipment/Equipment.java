package equipment;

import java.util.ArrayList;
import java.util.HashSet;

import equipment.items.ArmorClassEffector;
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
		int sum = 0;
		for (Integer i : enabledItems) {
			if (inventory.get(i) instanceof ArmorClassEffector) {
				sum += ((ArmorClassEffector)inventory.get(i)).GetArmorClassEffect();
			}
		}
		return sum;
	}
	
	public double GetTotalWeight() {
		double sum = 0;
		for (Item i : inventory) {
			sum += i.GetWeight();
		}
		return sum;
	}
	
	public double GetTotalValue() {
		double sum = gold;
		for (Item i : inventory) {
			sum += i.GetValue();
		}
		return sum;
	}
	
}
