package org.example;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<Item> items;

    public Store() {
        this.items = new ArrayList<>();
    }

    public Store addItem(Item item) {
        items.add(item);
        return this;
    }

    public Item findItem(String name) {
        for (Item item : items) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Store{items=" + items + "}";
    }
}

