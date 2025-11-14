package org.example.model;

public abstract class Appetizer extends MenuItem {
    public Appetizer(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public String getCategory() {
        return "Appetizer";
    }

    @Override
    public String prepare() {
        return "Preparing appetizer: " + name;
    }
}
