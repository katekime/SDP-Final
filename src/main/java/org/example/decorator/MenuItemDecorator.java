package org.example.decorator;

import org.example.model.MenuItem;
import org.example.visitor.MenuItemVisitor;

public abstract class MenuItemDecorator extends MenuItem {
    protected MenuItem decoratedMenuItem;

    public MenuItemDecorator(MenuItem decoratedMenuItem) {
        super(decoratedMenuItem.getName(), decoratedMenuItem.getPrice(), decoratedMenuItem.getDescription());
        this.decoratedMenuItem = decoratedMenuItem;
    }
    @Override
    public String getName() {
        return decoratedMenuItem.getName();
    }
    @Override
    public double getPrice() {
        return decoratedMenuItem.getPrice();
    }
    @Override
    public String getDescription() {
        return decoratedMenuItem.getDescription();
    }
    @Override
    public String getCategory() {
        return decoratedMenuItem.getCategory();
    }
    @Override
    public String prepare() {
        return decoratedMenuItem.prepare();
    }
}
