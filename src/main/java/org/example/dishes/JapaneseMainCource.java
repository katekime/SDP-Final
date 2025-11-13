package org.example.dishes;

import org.example.model.MainCource;

public class JapaneseMainCource extends MainCource {
    public JapaneseMainCource() {
        this.name = "Tonkatsu";
        this.price = 10;
        this.description = "Breaded and deep-fried pork cutlet, served with shredded cabbage and a tangy sauce";
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
