package org.example.strategy;

import org.example.factory.Order;

public interface Strategy {
    boolean payment(Order order);
}
