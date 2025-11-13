package org.example.dishes;

import org.example.model.Dessert;

public class JapaneseDessert extends Dessert {
    public JapaneseDessert() {
        this.name = "Mochi";
        this.price = 2;
        this.description = "Rice cake made of mochigome, a short-grain japonica glutinous rice";
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
