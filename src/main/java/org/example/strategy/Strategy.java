package org.example.strategy;

import org.example.factory.Order;

public interface Strategy {
    void payment(Order order);
}
