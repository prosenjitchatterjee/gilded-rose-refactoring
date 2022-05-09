package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.service.impl.GildedRoseImpl;
import com.gildedrose.util.Constants;

class GildedRoseTest {

	/**
	 * Testing for Conjured Item
	 */
    @Test
    void testConjured() {
        Item[] items = new Item[] { new Item(Constants.CONJURED, 2, 4) };
        GildedRoseImpl app = new GildedRoseImpl(items);
        app.updateQuality();
        assertNotEquals("fixme", app.items[0].name);		// Validating Item Names
        assertEquals(Constants.CONJURED, app.items[0].name);// Validating Item Names
        assertEquals(2, app.items[0].quality);				// Validating Item Quality
        assertNotEquals(3, app.items[0].quality);			// Validating Item Quality
    }
    
	/**
	 * Testing for Conjured Item
	 */
    @Test
    void testBackstageTafkal80etc() {
        Item[] items = new Item[] { new Item(Constants.BACKSTAGE_TAFKAL80ETC, 2, 4) };
        GildedRoseImpl app = new GildedRoseImpl(items);
        app.updateQuality();
        assertNotEquals("fixme", app.items[0].name);						// Validating Item Names
        assertEquals(Constants.BACKSTAGE_TAFKAL80ETC, app.items[0].name);	// Validating Item Names
        assertEquals(7, app.items[0].quality); 								// Validating Item Quality
        assertNotEquals(1, app.items[0].quality);							// Validating Item Quality
    }

    
    /**
	 * Testing for Aged Brie Item
	 */
    @Test
    void testAgedBarie() {
        Item[] items = new Item[] { new Item(Constants.AGED_BRIE, 2, 4) };
        GildedRoseImpl app = new GildedRoseImpl(items);
        app.updateQuality();
        assertNotEquals("fixme", app.items[0].name);				// Validating Item Names
        assertEquals(Constants.AGED_BRIE, app.items[0].name);		// Validating Item Names
        assertEquals(5, app.items[0].quality);						// Validating Item Quality
        assertNotEquals(1, app.items[0].quality);					// Validating Item Quality
    }
    
    /**
	 * Testing for Sulfuras, Hand of Ragnaros Item
	 */
    @Test
    void testSulfurasHandOfRagnaros() {
        Item[] items = new Item[] { new Item(Constants.SULFURAS_HAND_OF_RAGNAROS, 0, 80) };
        GildedRoseImpl app = new GildedRoseImpl(items);
        app.updateQuality();
        assertNotEquals("fixme", app.items[0].name);							// Validating Item Names
        assertEquals(Constants.SULFURAS_HAND_OF_RAGNAROS, app.items[0].name);	// Validating Item Names
        assertEquals(80, app.items[0].quality);									// Validating Item Quality
        assertNotEquals(1, app.items[0].quality);								// Validating Item Quality
    }

}
