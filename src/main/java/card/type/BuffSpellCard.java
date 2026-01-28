package card.type;

import card.base.SpellCard;
import card.base.UnitCard;

public class BuffSpellCard extends SpellCard {
	private int powerIncrease;

	public BuffSpellCard(String name, String flavorText, int bloodCost, boolean isBurstSpeed, int powerIncrease) {
		super(name, flavorText, bloodCost, isBurstSpeed);
		this.setPowerIncrease(powerIncrease);
	}

	@Override
	public void castSpell(UnitCard unitCard) {
		if (unitCard != null) {
			// Logic: พลังใหม่ = พลังเดิม + ส่วนที่เพิ่ม
			// ห้ามใช้ unitCard.setPower(unitCard.getPower() + unitCard.getPower()) เด็ดขาด
			unitCard.setPower(unitCard.getPower() + this.getPowerIncrease());
		}
	}

	public int getPowerIncrease() { return powerIncrease; }

	public void setPowerIncrease(int powerIncrease) {
		this.powerIncrease = Math.max(1, powerIncrease);
	}

	@Override
	public String toString() {
		return getName() + " (Cost: " + getBloodCost() + ")";
	}
}