package org.example.factory;

import org.example.dishes.JapaneseAppetizer;
import org.example.dishes.KazakhAppetizer;
import org.example.model.Appetizer;

public class AppetizerFactory {
    public Appetizer createAppetizer(String cuisine) {
        switch (cuisine.toLowerCase()) {
            case "japanese": return new JapaneseAppetizer();
            case "kazakh": return new KazakhAppetizer();
            default: return null;
        }
    }
}
