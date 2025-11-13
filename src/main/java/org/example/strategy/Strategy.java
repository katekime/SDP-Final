package org.example.strategy;

import org.example.Order;

public interface Strategy {
    void payment(Order order);
}
