package org.example.model;

import org.example.visitor.MenuItemVisitor;

public abstract class Drink extends MenuItem {
    public Drink(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public String getCategory() {
        return "Drink";
    }

    @Override
    public String prepare() {
        return "Preparing drink: " + name;
    }

    @Override
    public void accept(MenuItemVisitor menuItemVisitor) {
        menuItemVisitor.visit(this);
    }
}
