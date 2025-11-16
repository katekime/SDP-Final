package org.example.decorator;

import org.example.model.MenuItem;
import org.example.visitor.MenuItemVisitor;

public class SorpaDecorator extends MenuItemDecorator {
    private String sorpa;
    public SorpaDecorator(MenuItem decoratedMenuItem, String sorpa) {
        super(decoratedMenuItem);
        this.sorpa = sorpa;
    }
    @Override
    public String getDescription() {
        return decoratedMenuItem.getDescription() + ".Adding sorpa.Sorpa type:  " + sorpa;
    }
    @Override
    public double getPrice() {
        return decoratedMenuItem.getPrice() + 0.5;
    }
    @Override
    public String getCategory() {
        return  decoratedMenuItem.getCategory();
    }
    @Override
    public String prepare() {
        return decoratedMenuItem.prepare() + ".Preparing sorpa you want: " + sorpa;
    }
    @Override
    public void accept(MenuItemVisitor visitor) {
        decoratedMenuItem.accept(visitor);
    }
}
