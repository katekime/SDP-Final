package org.example.decorator;

import org.example.model.MenuItem;

public class LemonDecorator extends MenuItemDecorator{
    private String plusLemon;

    public LemonDecorator(MenuItem decoratedMenuItem, String plusLemon) {
        super(decoratedMenuItem);
        this.plusLemon = plusLemon;
    }

    @Override
    public String getDescription() {
        return decoratedMenuItem.getDescription() + " Adding lemon.Type of lemon: " + plusLemon;
    }
    @Override
    public double getPrice() {
        return decoratedMenuItem.getPrice() + 0.1;
    }

}
