package org.example.decorator;

import org.example.model.MenuItem;

public class SorpaDecorator extends MenuItemDecorator {
    private String sorpa;
    public SorpaDecorator(MenuItem decoratedMenuItem, String sorpa) {
        super(decoratedMenuItem);
        this.sorpa = sorpa;
    }
    @Override
    public String getDescription() {
        return decoratedMenuItem.getDescription() + " Adding sorpa.Sorpa type:  " + sorpa;
    }
    @Override
    public double getPrice() {
        return decoratedMenuItem.getPrice() + 0.5;
    }
}
