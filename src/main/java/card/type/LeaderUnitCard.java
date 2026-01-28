package card.type;

import card.base.UnitCard;

public class LeaderUnitCard extends UnitCard {
	private int buffPower;
	private int buffHealth;

	public LeaderUnitCard(String name, String flavorText, int bloodCost, int power, int health, int buffPower, int buffHealth) {
		super(name, flavorText, bloodCost, power, health);
		setBuffPower(buffPower);
		setBuffHealth(buffHealth);
	}

	// Method ที่ PlayTest.java บรรทัด 180 เรียกใช้
	public void buffUnit(UnitCard[] playerField) {
		if (playerField == null) return;
		for (UnitCard unit : playerField) {
			if (unit != null) {
				unit.setPower(unit.getPower() + buffPower);
				unit.setHealth(unit.getHealth() + buffHealth);
			}
		}
	}

	@Override
	public String toString() {
		return getName() + " (Power: " + getPower() + ", Health: " + getHealth() + ") [Buff: " + buffPower + "/" + buffHealth + "]";
	}

	public int getBuffPower() { return buffPower; }
	public void setBuffPower(int buffPower) { this.buffPower = Math.max(0, buffPower); }
	public int getBuffHealth() { return buffHealth; }
	public void setBuffHealth(int buffHealth) { this.buffHealth = Math.max(0, buffHealth); }
}