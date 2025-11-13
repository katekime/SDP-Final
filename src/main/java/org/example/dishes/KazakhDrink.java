package org.example.dishes;

import org.example.model.Drink;

public class KazakhDrink extends Drink {
    public KazakhDrink() {
        this.name = "Kumis";
        this.price = 5;
        this.description = "Fermented mare's milk, a traditional sour and slightly alcoholic dairy drink";
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
