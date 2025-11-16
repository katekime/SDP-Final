package org.example.visitor;

import org.example.model.Appetizer;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainCourse;

public class ServeFeeVisitor implements MenuItemVisitor {
    private double totalFee = 0; // serving fee will be 10%

    @Override
    public void visit(Appetizer appetizer) {
        totalFee += appetizer.getPrice() * 0.1;
    }

    @Override
    public void visit(Dessert dessert) {
        totalFee += dessert.getPrice() * 0.1;
    }

    @Override
    public void visit(Drink drink) {
        totalFee += drink.getPrice() * 0.1;
    }

    @Override
    public void visit(MainCourse mainCourse) {
        totalFee += mainCourse.getPrice() * 0.1;
    }
}
