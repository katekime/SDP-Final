package org.example.dishes;

import org.example.model.Appetizer;

public class KazakhAppetizer extends Appetizer {
    public KazakhAppetizer() {
        this.name = "Assorted Meat Delicacies";
        this.price = 15;
        this.description = "A platter of traditional Kazakh meat delicacies including kazy, and other cured meats";
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
