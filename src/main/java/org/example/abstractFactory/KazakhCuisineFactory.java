package org.example.abstractFactory;

import org.example.dishes.*;
import org.example.model.Appetizer;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainCourse;

public class KazakhCuisineFactory implements CuisineFactory {
    @Override
    public Appetizer createAppetizer() {
        return new KazakhAppetizer("Kazy", 5.99,
                "Traditional Kazakh horse meat sausage");
    }
    @Override
    public Dessert createDessert() {
        return new KazakhDessert("Zhent", 3.99,
                "A traditional sweet made from millet, sugar, and butter");
    }
    @Override
    public Drink createDrink() {
        return new KazakhDrink("Kumys", 2.99,
                "Fermented mare's milk");
    }
    @Override
    public MainCourse createMainCourse() {
        return new KazakhMainCourse("Beshbarmak", 15.99,
                "Traditional Kazakh dish with meat and noodles");
    }
}
