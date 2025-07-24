package org.example;

import org.jetbrains.annotations.NotNull;

public class Customer {
    private final String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public PurchaseBuilder purchase(@NotNull Store store, String itemName) {
        Item item = store.findItem(itemName);
        if (item != null) {
            return new PurchaseBuilder(this, item);
        } else {
            System.out.println("Item '" + itemName + "' not found in store.");
            return new PurchaseBuilder(this, null);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deductBalance(double amount) {
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', balance=$" + balance + "}";
    }

    // Inner class for fluent purchase building
    public static class PurchaseBuilder {
        private final Customer customer;
        private final Item item;
        private double discount; // %

        public PurchaseBuilder(Customer customer, Item item) {
            this.customer = customer;
            this.item = item;
        }

        public PurchaseBuilder discount(double discount) {
            this.discount = discount;
            return this;
        }

        public void complete() {
            if (item == null) {
                System.out.println("Purchase failed: item not found.");
                return;
            }

            double finalPrice = item.price() * (1 - discount / 100.0);
            if (customer.balance >= finalPrice) {
                customer.deductBalance(finalPrice);
                System.out.println(customer.name + " purchased " + item.name() +
                        " for $" + finalPrice + ". Remaining balance: $" + customer.getBalance());
            } else {
                System.out.println(customer.name + " does not have enough balance to buy " + item.name() + ".");
            }
        }
    }
}
