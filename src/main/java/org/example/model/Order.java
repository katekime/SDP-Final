package org.example.model;

import org.example.observer.Observer;
import org.example.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String status;
    private List<Observer> observers = new ArrayList<>();
    private Strategy paymentStrategy;


}
