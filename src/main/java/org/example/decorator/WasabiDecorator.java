package org.example.decorator;

import org.example.model.MenuItem;
import org.example.visitor.MenuItemVisitor;

public class WasabiDecorator extends MenuItemDecorator {
    private int levelOfSpiciness;

    public WasabiDecorator(MenuItem decoratedMenuItem, int levelOfSpiciness) {
        super(decoratedMenuItem);
        if (levelOfSpiciness < 1 || levelOfSpiciness > 10) {
            throw new IllegalArgumentException("Spiciness must be between 1 and 10");
        }
        this.levelOfSpiciness = levelOfSpiciness;
    }
    @Override
    public String getDescription() {
        return decoratedMenuItem.getDescription() + ".Adding a wasabi.Level of wasabi spiciness: "  +  levelOfSpiciness;
    }
    @Override
    public double getPrice() {
        return decoratedMenuItem.getPrice() + 2;
    }
    @Override
    public String getCategory() {
        return decoratedMenuItem.getCategory();
    }
    @Override
    public String prepare() {
        return decoratedMenuItem.prepare() + ".Preparing wasabi.Spiciness level: " + levelOfSpiciness;
    }
    @Override
    public void accept(MenuItemVisitor visitor) {
        decoratedMenuItem.accept(visitor);
    }
}
