package org.example.factory;

import org.example.dishes.JapaneseDrink;
import org.example.dishes.KazakhDrink;
import org.example.model.Drink;

public class DrinkFactory {
    public Drink createDrink(String cuisine) {
        switch (cuisine.toLowerCase()) {
            case "japanese": return new JapaneseDrink();
            case "kazakh": return new KazakhDrink();
            default: return null;
        }
    }
}
