package org.example.visitor;

import org.example.model.Appetizer;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainCourse;

public interface MenuItemVisitor {
    void visit(Appetizer appetizer);
    void visit(Dessert dessert);
    void visit(Drink drink);
    void visit(MainCourse mainCourse);
}
