package org.example.visitor;

import org.example.model.Appetizer;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainCourse;

public class ServeFeeVisitor implements MenuItemVisitor {
    private double totalFee = 0; // serving fee will be 10%

    @Override
    public void visit(Appetizer appetizer) {
        double fee = appetizer.getPrice() * 0.1;
        totalFee += fee;
        System.out.println("  - " + appetizer.getName() + " (Appetizer) - Service fee: $" + String.format("%.2f", fee));
    }

    @Override
    public void visit(Dessert dessert) {
        double fee = dessert.getPrice() * 0.1;
        totalFee += fee;
        System.out.println("  - " + dessert.getName() + " (Dessert) - Service fee: $" + String.format("%.2f", fee));
    }

    @Override
    public void visit(Drink drink) {
        double fee = drink.getPrice() * 0.1;
        totalFee += fee;
        System.out.println("  - " + drink.getName() + " (Drink) - Service fee: $" + String.format("%.2f", fee));
    }

    @Override
    public void visit(MainCourse mainCourse) {
        double fee = mainCourse.getPrice() * 0.1;
        totalFee += fee;
        System.out.println("  - " + mainCourse.getName() + " (Main Course) - Service fee: $" + String.format("%.2f", fee));
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void reset() {
        totalFee = 0;
    }
}
