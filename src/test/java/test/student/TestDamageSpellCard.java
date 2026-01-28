package test.student;

// 1. เพิ่ม Import สำหรับ Assertions (สำคัญมาก ไม่งั้นจะเจอ error cannot find symbol)
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import card.base.SpellCard;
import card.type.DamageSpellCard;
import card.type.NormalUnitCard;

public class TestDamageSpellCard {
	NormalUnitCard unit;

	SpellCard spell0 = new DamageSpellCard("DSpell0" , "-1" , 1, true, 1);
	DamageSpellCard spell1 = new DamageSpellCard("DSpell1" , "-1" , 1, true, 1);
	DamageSpellCard spell2 = new DamageSpellCard("DSpell2" , "-2" , 1, true, 2);
	DamageSpellCard spell3 = new DamageSpellCard("DSpell3" , "-3" , 2, false, 3);
	DamageSpellCard spellN = new DamageSpellCard("DSpellN" , "XX" , -2, false, -1);

	@BeforeEach
	public void setUp() {
		unit = new NormalUnitCard("Tanky Unit" , "I'm a tanky unit" , 0 , 2 , 10);
	}

	@Test
	void testConstructor() {
		assertEquals("DSpell1", spell1.getName());
		assertEquals("-1", spell1.getFlavorText());
		assertEquals(1, spell1.getBloodCost());
		assertTrue(spell1.isBurstSpeed());
		assertEquals(1, spell1.getDamage());

		// เพิ่มการเช็คค่ากรณี Negative (spellN) เพื่อให้ครอบคลุม logic Math.max(1, ...)
		assertEquals(1, spellN.getDamage());
		assertEquals(0, spellN.getBloodCost());
	}

	@Test
	void testSetDamage() {
		spell1.setDamage(5);
		assertEquals(5, spell1.getDamage());
		spell1.setDamage(-10); // Logic ใน class ควรเป็น Math.max(1, damage)
		assertEquals(1, spell1.getDamage());
	}

	@Test
	void testCastSpell() {
		// พลังชีวิตเริ่มต้นคือ 10
		spell1.castSpell(unit); // damage 1 -> เหลือ 9
		assertEquals(9, unit.getHealth());

		spell2.castSpell(unit); // damage 2 -> เหลือ 7
		assertEquals(7, unit.getHealth());

		spell3.castSpell(unit); // damage 3 -> เหลือ 4
		assertEquals(4, unit.getHealth());
	}
}