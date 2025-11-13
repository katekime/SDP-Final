package org.example.abstractFactory;

import org.example.model.Appetizer;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainCource;

public interface CuisineFactory {
    Appetizer createAppetizer();
    Dessert createDessert();
    Drink createDrink();
    MainCource createMainCource();
}