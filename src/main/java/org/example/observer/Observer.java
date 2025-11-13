package org.example.observer;

import org.example.Order;

public interface Observer {
    void update(Order order);
}
