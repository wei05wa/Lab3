package deck;

import java.util.Arrays;
import card.base.Card;

public class Deck {
	private String name;
	private Card[] deckList;

	public Deck(String name, Card[] deckList) {
		this.name = name;
		this.deckList = deckList;
	}

	public int insertCard(Card card) throws InsertCardFailedException {
		int count = 0;
		// 1. ตรวจสอบว่ามีการ์ดชื่อเดียวกันนี้ในเด็คกี่ใบแล้ว
		for (Card c : deckList) {
			if (c != null && c.equals(card)) {
				count++;
			}
		}

		// 2. ถ้ามีครบ 4 ใบแล้ว ให้โยน Exception
		if (count >= 4) {
			throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
		}

		// 3. เพิ่มการ์ดใหม่เข้าไปในเด็ค โดยขยายขนาด Array ขึ้น 1 ช่อง
		Card[] newDeckList = Arrays.copyOf(deckList, deckList.length + 1);
		newDeckList[deckList.length] = card;
		this.deckList = newDeckList;

		// 4. ส่งคืนขนาดใหม่ของเด็ค
		return deckList.length;
	}

	public Card removeCard(int slotNumber) throws RemoveCardFailedException {
		// 1. ตรวจสอบเงื่อนไข Error
		if (this.deckList.length <= slotNumber) {
			throw new RemoveCardFailedException("Number you insert exceed deck size");
		}
		if (this.deckList[slotNumber] == null) {
			throw new RemoveCardFailedException("There is no card in that slot");
		}

		// 2. เก็บการ์ดที่จะลบไว้เพื่อ return
		Card removedCard = deckList[slotNumber];

		// 3. สร้าง Array ใหม่ที่มีขนาดลดลง 1
		Card[] newDeckList = new Card[deckList.length - 1];

		// 4. ทำการ Rearrange (เลื่อนการ์ดที่อยู่ข้างหลังขึ้นมาแทนที่ช่องว่าง)
		int newIdx = 0;
		for (int i = 0; i < deckList.length; i++) {
			if (i == slotNumber) continue; // ข้ามช่องที่ถูกลบ
			newDeckList[newIdx++] = deckList[i];
		}

		this.deckList = newDeckList;
		return removedCard;
	}

	@Override
	public String toString() {
		return "Deck: " + name + "\n" + Arrays.toString(deckList);
	}

	// Getter & Setter
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Card[] getDeckList() { return deckList; }
	public void setDeckList(Card[] deckList) { this.deckList = deckList; }

	public int getDeckSize() {
		return this.deckList.length;
	}
}