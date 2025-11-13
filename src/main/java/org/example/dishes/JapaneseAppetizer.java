package org.example.dishes;

import org.example.model.Appetizer;

public class JapaneseAppetizer extends Appetizer {
    public JapaneseAppetizer() {
        this.name = "Edamame";
        this.price = 2.99;
        this.description = "Steamed young soybeans in the pod, lightly salted";
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
