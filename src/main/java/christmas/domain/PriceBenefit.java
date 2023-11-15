package christmas.domain;

import christmas.constant.Day;
import christmas.constant.Menu;
import java.util.List;
import java.util.Map;

public class PriceBenefit {
    private Map<Menu, Integer> orderItems;

    public PriceBenefit(Map<Menu, Integer> orderItems) {
        this.orderItems = orderItems;
    }

    public int calculateChristmasDayDiscount(int date) {
        if (date >= 1 && date <= 25) {
            return 1000 + (date - 1) * 100;
        }
        return 0;
    }

    public int calculateWeekdayDiscount(int date) {
        if (Day.WEEKDAY.getDays().contains(date)) {
            return orderItems.entrySet().stream()
                    .filter(entry -> entry.getKey().getCategory() == Menu.Category.DESSERT)
                    .mapToInt(entry -> entry.getValue() * 2023)
                    .sum();
        }
        return 0;
    }

    public int calculateWeekendDiscount(int date) {
        if (Day.WEEKEND.getDays().contains(date)) {
            return orderItems.entrySet().stream()
                    .filter(entry -> entry.getKey().getCategory() == Menu.Category.MAIN)
                    .mapToInt(entry -> entry.getValue() * 2023)
                    .sum();
        }
        return 0;
    }

    public int calculateSpecialDiscount(int date) {
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
