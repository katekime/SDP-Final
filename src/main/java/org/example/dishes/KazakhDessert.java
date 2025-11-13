package org.example.dishes;

import org.example.model.Dessert;

public class KazakhDessert extends Dessert {
    public KazakhDessert() {
        this.name = "Zhent";
        this.price = 4;
        this.description = "A traditional sweet made from millet, sugar, and butter, often shaped into bars or balls";
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public String getDescription() {
        return description;
    }
}
