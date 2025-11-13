package org.example.factory;

import org.example.dishes.JapaneseDessert;
import org.example.dishes.KazakhDessert;
import org.example.model.Dessert;

public class DessertFactory {
    public Dessert createDessert(String cuisine) {
        switch (cuisine.toLowerCase()) {
            case "japanese": return new JapaneseDessert();
            case "kazakh": return new KazakhDessert();
            default: return null;
        }
    }
}