package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Store store = new Store();
        store.addItem(new Item("Book", 30.0))
                .addItem(new Item("Pen", 10.0))
                .addItem(new Item("Bag", 80.0));

        Customer customer = new Customer("Alice", 100.0);

        customer.purchase(store, "Book")
                .discount(20)
                .complete();

        customer.purchase(store, "Pen")
                .discount(0)
                .complete();

        customer.purchase(store, "Bag")
                .discount(10)
                .complete();

        customer.purchase(store, "Laptop")
                .discount(5)
                .complete();
    }
}