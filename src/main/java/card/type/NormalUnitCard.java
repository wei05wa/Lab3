package card.type;

import card.base.UnitCard;

public class NormalUnitCard extends UnitCard {

	public NormalUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		// ส่งค่าไปยัง Constructor ของ UnitCard (คลาสแม่)
		super(name, flavorText, bloodCost, power, health);
	}

	// ใช้การโจมตีมาตรฐานจาก UnitCard (attackUnit และ attackPlayer)

	@Override
	public String toString() {
		// รูปแบบข้อความที่ใช้แสดงผลบน Board ใน PlayTest
		return getName() + " (Power: " + getPower() + ", Health: " + getHealth() + ")";
	}
}