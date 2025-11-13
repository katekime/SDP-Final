package org.example.strategy;

import org.example.model.Order;

public interface Strategy {
    void payment(Order order);
}
