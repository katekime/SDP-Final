package org.example.abstractFactory;

import org.example.dishes.*;
import org.example.model.Appetizer;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainCource;

public class KazakhCuisineFactory implements CuisineFactory {
    @Override
    public Appetizer createAppetizer() {
        return new KazakhAppetizer();
    }
    @Override
    public Dessert createDessert() {
        return new KazakhDessert();
    }
    @Override
    public Drink createDrink() {
        return new KazakhDrink();
    }
    @Override
    public MainCource createMainCource() {
        return new KazakhMainCource();
    }
}
