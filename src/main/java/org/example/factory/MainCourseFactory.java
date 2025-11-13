package org.example.factory;

import org.example.dishes.JapaneseMainCource;
import org.example.dishes.KazakhMainCource;
import org.example.model.MainCource;

public class MainCourseFactory {
    public MainCource createMainCource(String cuisine) {
        switch (cuisine.toLowerCase()) {
            case "japanese": return new JapaneseMainCource();
            case "kazakh": return new KazakhMainCource();
            default: return null;
        }
    }
}
