package org.example.dishes;

import org.example.model.MainCource;

public class KazakhMainCource extends MainCource {
    public KazakhMainCource() {
        this.name = "Beshbarmak";
        this.price = 12;
        this.description = "The national dish of Kazakhstan, consisting of boiled meat served with wide noodles and onion sauce";
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
