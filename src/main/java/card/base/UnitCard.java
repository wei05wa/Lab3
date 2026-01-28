package card.base;

import player.Player;

public abstract class UnitCard extends Card {
	private int power;
	private int health;

	public UnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name, flavorText, bloodCost);
		this.setPower(power);
		this.setHealth(health);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	// --- จุดตายที่ทำให้เกิดเลข 8 ---
	public void setPower(int power) {
		// ต้องใช้ = เท่านั้น!! ห้ามใช้ this.power += power;
		this.power = Math.max(0, power);
	}

	public void setHealth(int health) {
		// ต้องใช้ = เท่านั้น!! ห้ามใช้ this.health += health;
		this.health = Math.max(0, health);
	}

	public int getPower() { return power; }
	public int getHealth() { return health; }

	public int attackUnit(UnitCard unitCard) {
		int damageDealt = Math.min(this.getPower(), unitCard.getHealth());
		// ตรงนี้ใช้ setter เพื่อความปลอดภัย
		unitCard.setHealth(unitCard.getHealth() - this.getPower());
		return damageDealt;
	}

	public int attackPlayer(Player opponent) {
		opponent.setCurrentDamagePoint(opponent.getCurrentDamagePoint() + this.getPower());
		return this.getPower();
	}
}