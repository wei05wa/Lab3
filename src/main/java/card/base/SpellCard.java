package card.base;

public abstract class SpellCard extends Card {
	private boolean isBurstSpeed;

	public SpellCard(String name, String flavorText, int bloodCost, boolean isBurstSpeed) {
		super(name, flavorText, bloodCost); // ส่งให้ Card จัดการ
		this.isBurstSpeed = isBurstSpeed;
	}

	public abstract void castSpell(UnitCard unitCard);

	// --- ห้ามมี private String name; หรือ private int bloodCost; ที่นี่ ---

	public boolean isBurstSpeed() { return isBurstSpeed; }
	public void setBurstSpeed(boolean isBurstSpeed) { this.isBurstSpeed = isBurstSpeed; }
}