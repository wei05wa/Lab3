package card.type;

import card.base.UnitCard;
import player.Player;

public class VenomUnitCard extends UnitCard {

	public VenomUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name, flavorText, bloodCost, power, health);
	}

	@Override
	public int attackUnit(UnitCard unitCard) {
		int damageDealt = super.attackUnit(unitCard);
		// Venom ลดเลือดตัวเองตามพลังโจมตี
		this.setHealth(this.getHealth() - this.getPower());
		return damageDealt;
	}
	public int dead(Player opponent) {
		// ใช้ค่า power ของตัวเองเป็นดาเมจ (ห้ามใส่เลข 2 หรือ 4 ตรงๆ)
		int damage = this.getPower();
		opponent.setCurrentDamagePoint(opponent.getCurrentDamagePoint() + damage);
		return damage;
	}

	@Override
	public String toString() {
		return getName() + " (Power: " + getPower() + ", Health: " + getHealth() + ") [Venom]";
	}
}