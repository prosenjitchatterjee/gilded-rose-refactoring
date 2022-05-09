package com.gildedrose.service.impl;

import com.gildedrose.Item;
import com.gildedrose.service.GildedRose;
import com.gildedrose.util.Constants;

public class GildedRoseImpl implements GildedRose {
	public Item[] items;

	public GildedRoseImpl(Item[] items) {
		this.items = items;
	}

	@Override
	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!isAgedBarie(items[i].name) && !isBackstageTafkal80etc(items[i].name)) {
				if (items[i].quality > 0) {
					if (!isSulfurasHandOfRagnaros(items[i].name)) {

						if (isConjured(items[i].name)) {
							// for CONJURED
							if (items[i].quality > 1)
								items[i].quality -= 2;
						} else {
							items[i].quality--;
						}
					}
				}
			} else {
				if (items[i].quality < 50) {
					items[i].quality = items[i].quality + 1;

					if (isBackstageTafkal80etc(items[i].name)) {
						if (items[i].sellIn < 11) {
							if (items[i].quality < 50) {
								items[i].quality++;
							}
						}

						if (items[i].sellIn < 6) {
							if (items[i].quality < 50) {
								items[i].quality++;
							}
						}
					}
				}
			}

			// Update sell in for non Sulfuras, Hand of Ragnaros
			if (!isSulfurasHandOfRagnaros(items[i].name)) {
				items[i].sellIn--;
			}

			if (items[i].sellIn < 0) {
				if (!isAgedBarie(items[i].name)) {
					if (!isBackstageTafkal80etc(items[i].name)) {
						if (items[i].quality > 0) {
							if (!isSulfurasHandOfRagnaros(items[i].name)) {

								if (isConjured(items[i].name)) {
									// for CONJURED
									if (items[i].quality > 1)
										items[i].quality -= 2;
								} else {
									items[i].quality--;
								}
							}
						}
					} else {
						items[i].quality = items[i].quality - items[i].quality;
					}
				} else {
					if (items[i].quality < 50) {
						items[i].quality++;
					}
				}
			}
		}
	}

	private boolean isConjured(String name) {
		return name.equals(Constants.CONJURED);
	}

	private boolean isSulfurasHandOfRagnaros(String name) {
		return name.equals(Constants.SULFURAS_HAND_OF_RAGNAROS);
	}

	private boolean isBackstageTafkal80etc(String name) {
		return name.equals(Constants.BACKSTAGE_TAFKAL80ETC);
	}

	private boolean isAgedBarie(String name) {
		return name.equals(Constants.AGED_BRIE);
	}
}