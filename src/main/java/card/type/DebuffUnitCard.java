package card.type;

import card.base.UnitCard;

public class DebuffUnitCard extends UnitCard {
	private int debuffPower;

	public DebuffUnitCard(String name, String flavorText, int bloodCost, int power, int health, int debuffPower) {
		super(name, flavorText, bloodCost, power, health);
		setDebuffPower(debuffPower);
	}

	@Override
	public int attackUnit(UnitCard unitCard) {
		// 1. ทำดาเมจปกติใส่ศัตรู (เรียกใช้ logic จากคลาสแม่)
		int damageDealt = super.attackUnit(unitCard);

		// 2. ความสามารถพิเศษ: ลดพลังโจมตีของศัตรูลงตามค่า debuffPower
		unitCard.setPower(unitCard.getPower() - this.debuffPower);

		return damageDealt;
	}

	@Override
	public String toString() {
		// แสดงชื่อ พลัง และค่า Debuff
		return getName() + " (Power: " + getPower() + ", Health: " + getHealth() + ") [Debuff: " + debuffPower + "]";
	}

	public int getDebuffPower() {
		return debuffPower;
	}

	public void setDebuffPower(int debuffPower) {
		// ดักไม่ให้ค่า Debuff ติดลบ
		this.debuffPower = Math.max(0, debuffPower);
	}
}