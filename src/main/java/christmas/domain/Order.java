package christmas.domain;

import christmas.constant.Menu;
import java.util.Map;

public class Order {
    private Map<Menu, Integer> orderItems;

    public Order(Map<Menu, Integer> orderItems) {
        this.orderItems = orderItems;
    }

    public Map<Menu, Integer> getOrderItems() {
        return orderItems;
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Map.Entry<Menu, Integer> entry : orderItems.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}

