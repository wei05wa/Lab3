package card.type;

import card.base.SpellCard;
import card.base.UnitCard;

public class DamageSpellCard extends SpellCard {
	private int damage;

	public DamageSpellCard(String name, String flavorText, int bloodCost, boolean isBurstSpeed, int damage) {
		super(name, flavorText, bloodCost, isBurstSpeed);
		this.setDamage(damage);
	}

	@Override
	public void castSpell(UnitCard unitCard) {
		if (unitCard != null) {
			unitCard.setHealth(unitCard.getHealth() - this.getDamage());
		}
	}

	public void setDamage(int damage) {
		this.damage = Math.max(1, damage);
	}

	public int getDamage() { return damage; }

	@Override
	public String toString() {
		return getName() + " (Cost: " + getBloodCost() + ")";
	}
}