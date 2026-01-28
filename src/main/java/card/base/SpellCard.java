package card.base;

public abstract class SpellCard extends Card {
	private boolean isBurstSpeed;

	public SpellCard(String name, String flavorText, int bloodCost, boolean isBurstSpeed) {
		super(name, flavorText, bloodCost);
		this.isBurstSpeed = isBurstSpeed;
	}

	public abstract void castSpell(UnitCard unitCard);

	public boolean isBurstSpeed() { return isBurstSpeed; }
	public void setBurstSpeed(boolean isBurstSpeed) { this.isBurstSpeed = isBurstSpeed; }
}