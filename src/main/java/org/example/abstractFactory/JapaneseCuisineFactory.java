package org.example.abstractFactory;

import org.example.dishes.JapaneseAppetizer;
import org.example.dishes.JapaneseDessert;
import org.example.dishes.JapaneseDrink;
import org.example.dishes.JapaneseMainCourse;
import org.example.model.Appetizer;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainCourse;

public class JapaneseCuisineFactory implements CuisineFactory {
    @Override
    public Appetizer createAppetizer() {
        return new JapaneseAppetizer("Edamame",2.99,
                "Steamed young soybeans in the pod");
    }
    @Override
    public Dessert createDessert() {
        return new JapaneseDessert("Mochi", 4.99,
                "Japanese rice cake with sweet filling");
    }
    @Override
    public Drink createDrink() {
        return new JapaneseDrink("Matcha Tea",1.99,
                "Traditional Japanese tea");
    }
    @Override
    public MainCourse createMainCourse() {
        return new JapaneseMainCourse("Sushi Roll",11.99,
                "Fresh salmon and avocado roll");
    }
}
