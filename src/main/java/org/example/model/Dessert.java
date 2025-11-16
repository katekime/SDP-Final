package org.example.model;

import org.example.visitor.MenuItemVisitor;

public abstract class Dessert extends MenuItem {
    public Dessert(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public String getCategory() {
        return "Dessert";
    }

    @Override
    public String prepare() {
        return "Preparing dessert: " + name;
    }

    @Override
    public void accept(MenuItemVisitor menuItemVisitor) {
        menuItemVisitor.visit(this);
    }
}
