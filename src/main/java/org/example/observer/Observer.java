package org.example.observer;

import org.example.model.Order;

public interface Observer {
    void update(Order order);
}
