package com.vishrosh.tileengine.item;

import com.vishrosh.tileengine.gameobjects.GameObject;

public class Item extends GameObject<Item>{
	
	private int itemID;
	
	public Item() {
		
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

}
