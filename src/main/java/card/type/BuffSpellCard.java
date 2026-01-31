package card.type;

import card.base.SpellCard;
import card.base.UnitCard;

public class BuffSpellCard extends SpellCard {
	private int powerIncrease;

	public BuffSpellCard(String name, String flavorText, int bloodCost, boolean isBurstSpeed, int powerIncrease) {
		super(name, flavorText, bloodCost, isBurstSpeed); // ส่งให้ SpellCard -> Card
		this.setPowerIncrease(powerIncrease);
	}

	@Override
	public void castSpell(UnitCard unitCard) {
		if (unitCard != null) {
			// หัวใจสำคัญ: ใช้ Getter เพื่อดึงค่าพลังปัจจุบันมาบวก
			unitCard.setPower(unitCard.getPower() + this.getPowerIncrease());
		}
	}

	public int getPowerIncrease() { return powerIncrease; }

	public void setPowerIncrease(int powerIncrease) {
		this.powerIncrease = Math.max(1, powerIncrease);
	}

	@Override
	public String toString() {
		// ต้องเรียก getName() และ getBloodCost() จากคลาสแม่เท่านั้น
		return getName() + " (Cost: " + getBloodCost() + ")";
	}
}