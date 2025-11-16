package org.example.model;

import org.example.visitor.MenuItemVisitor;

public abstract class MainCourse extends MenuItem {
    public MainCourse(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public String getCategory() {
        return "Main Course";
    }

    @Override
    public String prepare() {
        return "Preparing main course: " + name;
    }

    @Override
    public void accept(MenuItemVisitor menuItemVisitor) {
        menuItemVisitor.visit(this);
    }
}
