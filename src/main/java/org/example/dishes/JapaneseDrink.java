package org.example.dishes;

import org.example.model.Drink;

public class JapaneseDrink extends Drink {
    public JapaneseDrink() {
        this.name = "Matcha Tea";
        this.price = 4;
        this.description = "Traditional powdered green tea with a rich, slightly bitter flavor";
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
