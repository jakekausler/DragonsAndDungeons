package roll;

import java.security.InvalidParameterException;
import java.util.Random;

public class Roll {
	
	private int[] diceTypes;
	private int[] numberOfRolls;
	private int constantAddition;
	
	private Random random;
	
	public Roll(int[] types, int[] nRolls, int cAdder) {
		if (types.length != nRolls.length) {
			throw new InvalidParameterException("types and nRolls must be the same length!");
		}
		diceTypes = types;
		numberOfRolls = nRolls;
		constantAddition = cAdder;
		
		random = new Random();
	}
	
	public int Roll() {
		int sum = 0;
		for (int i=0; i < diceTypes.length; i++) {
			for (int j=0; j < numberOfRolls[i]; j++) {
				sum += random.nextInt(diceTypes[i]) + 1;
			}
		}
		return sum;
	}
}
