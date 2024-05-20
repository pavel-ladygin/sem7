package org.example.sem7;

public class Order {
    private String dish;
    private String name;
    private String count;

    public Order(String dish, String name, String count) {
        this.dish = dish;
        this.name = name;
        this.count = count;
    }
    public String toString() {
        return dish + "   " + name + "   " + count;
    }
}
