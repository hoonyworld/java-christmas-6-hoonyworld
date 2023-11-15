package christmas.domain;

import christmas.constant.Menu;
import java.util.Map;

public class OrderCalculator {
    public static int calculateTotalPrice(Map<Menu, Integer> orderItems) {
        return orderItems.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}
