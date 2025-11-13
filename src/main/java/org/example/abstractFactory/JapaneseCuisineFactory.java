package org.example.abstractFactory;

import org.example.dishes.JapaneseAppetizer;
import org.example.dishes.JapaneseDessert;
import org.example.dishes.JapaneseDrink;
import org.example.dishes.JapaneseMainCource;
import org.example.model.Appetizer;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainCource;

public class JapaneseCuisineFactory implements CuisineFactory {
    @Override
    public Appetizer createAppetizer() {
        return new JapaneseAppetizer();
    }
    @Override
    public Dessert createDessert() {
        return new JapaneseDessert();
    }
    @Override
    public Drink createDrink() {
        return new JapaneseDrink();
    }
    @Override
    public MainCource createMainCource() {
        return new JapaneseMainCource();
    }
}
