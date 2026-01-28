package card.base;

public abstract class Card implements Cloneable {
	private String name;
	private String flavorText;
	private int bloodCost;

	public Card(String name, String flavorText, int bloodCost) {
		this.name = name;
		this.flavorText = flavorText;
		this.setBloodCost(bloodCost);
	}

	// --- เพิ่ม Method เหล่านี้เพื่อให้ Test หาเจอ ---
	public String getName() { return name; }
	public String getFlavorText() { return flavorText; }
	public int getBloodCost() { return bloodCost; }

	public void setBloodCost(int bloodCost) {
		// ต้องเป็น = เท่านั้น ห้ามใช้ +=
		this.bloodCost = Math.max(0, bloodCost);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public abstract String toString();
}