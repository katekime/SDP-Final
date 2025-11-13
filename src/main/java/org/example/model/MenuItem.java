package org.example.model;

public abstract class MenuItem {
    protected String name;
    protected double price;
    protected String description;

    public abstract String getName();
    public abstract double getPrice();
    public abstract String getDescription();
}
