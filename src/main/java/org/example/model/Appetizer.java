package org.example.model;

import org.example.visitor.MenuItemVisitor;

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

    @Override
    public void accept(MenuItemVisitor menuItemVisitor) {
        menuItemVisitor.visit(this);
    }
}
