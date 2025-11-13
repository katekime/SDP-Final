package org.example.decorator;

import org.example.model.MenuItem;

public abstract class MenuItemDecorator extends MenuItem {
    protected MenuItem decoratedMenuItem;

    public MenuItemDecorator(MenuItem decoratedMenuItem) {
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

}
