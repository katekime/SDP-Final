package org.example.decorator;

import org.example.model.MenuItem;

public class WasabiDecorator extends MenuItemDecorator {
    private int levelOfSpiciness;

    public WasabiDecorator(MenuItem decoratedMenuItem, int levelOfSpiciness) {
        super(decoratedMenuItem);
        this.levelOfSpiciness = levelOfSpiciness;
    }
    @Override
    public String getDescription() {
        return decoratedMenuItem.getDescription() + " Adding a wasabi.Level of wasabi spiciness: "  +  levelOfSpiciness;
    }
    @Override
    public double getPrice() {
        return decoratedMenuItem.getPrice() + 2;
    }
}
