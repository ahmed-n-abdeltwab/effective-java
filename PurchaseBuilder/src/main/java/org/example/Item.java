package org.example;

import org.jetbrains.annotations.NotNull;

public record Item(String name, double price) {
    @Override
    public @NotNull String toString() {
        return "Item{name='" + name + "', price=$" + price + "}";
    }
}
