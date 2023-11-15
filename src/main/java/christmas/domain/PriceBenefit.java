package christmas.domain;

import christmas.constant.Day;
import christmas.constant.Menu;
import java.util.List;
import java.util.Map;

public class PriceBenefit {
    private Map<Menu, Integer> orderItems;
    private int totalPrice;

    public PriceBenefit(Map<Menu, Integer> orderItems) {
        this.orderItems = orderItems;
        this.totalPrice = calculateTotalPrice();
    }

    private int calculateTotalPrice() {
        return orderItems.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int calculateChristmasDayDiscount(int date) {
        if (totalPrice < 10000) {
            return 0;
        }
        if (date >= 1 && date <= 25) {
            return 1000 + (date - 1) * 100;
        }
        return 0;
    }

    public int calculateWeekdayDiscount(int date) {
        if (totalPrice < 10000) {
            return 0;
        }
        if (Day.WEEKDAY.getDays().contains(date)) {
            return orderItems.entrySet().stream()
                    .filter(entry -> entry.getKey().getCategory() == Menu.Category.DESSERT)
                    .mapToInt(entry -> entry.getValue() * 2023)
                    .sum();
        }
        return 0;
    }

    public int calculateWeekendDiscount(int date) {
        if (totalPrice < 10000) {
            return 0;
        }
        if (Day.WEEKEND.getDays().contains(date)) {
            return orderItems.entrySet().stream()
                    .filter(entry -> entry.getKey().getCategory() == Menu.Category.MAIN)
                    .mapToInt(entry -> entry.getValue() * 2023)
                    .sum();
        }
        return 0;
    }

    public int calculateSpecialDiscount(int date) {
        if (totalPrice < 10000) {
            return 0;
        }
        List<Integer> starDays = Day.STARDAY.getDays();
        int discount = 0;
        if (starDays.contains(date)) {
            discount = 1000;
        }
        return discount;
    }

    public int calculateTotalDiscount(int date) {
        return calculateChristmasDayDiscount(date) +
                calculateWeekdayDiscount(date) +
                calculateWeekendDiscount(date) +
                calculateSpecialDiscount(date);
    }
}
