package org.example.abstractFactory;

import org.example.model.Appetizer;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainCourse;

public interface CuisineFactory {
    Appetizer createAppetizer();
    Dessert createDessert();
    Drink createDrink();
    MainCourse createMainCourse();
}