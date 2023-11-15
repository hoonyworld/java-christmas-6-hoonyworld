package christmas.domain;

import christmas.constant.ChristmasConstant;
import christmas.constant.Day;
import christmas.constant.Menu;
import java.util.List;
import java.util.Map;

public class PriceBenefit {
    private Map<Menu, Integer> orderItems;
    private int totalPrice;

    public PriceBenefit(Map<Menu, Integer> orderItems) {
        this.orderItems = orderItems;
        this.totalPrice = OrderCalculator.calculateTotalPrice(orderItems);
    }

    public int calculateChristmasDayDiscount(int date) {
        if (totalPrice < ChristmasConstant.MIN_TOTAL_PRICE_FOR_EVENT) {
            return 0;
        }
        if (date >= ChristmasConstant.CHRISTMAS_DAY_START && date <= ChristmasConstant.CHRISTMAS_DAY_END) {
            return ChristmasConstant.CHRISTMAS_DAY_BASE_DISCOUNT + (date - 1) * ChristmasConstant.HUNDRED_WON;
        }
        return 0;
    }

    public int calculateWeekdayDiscount(int date) {
        if (totalPrice < ChristmasConstant.MIN_TOTAL_PRICE_FOR_EVENT) {
            return 0;
        }
        if (Day.WEEKDAY.getDays().contains(date)) {
            return orderItems.entrySet().stream()
                    .filter(entry -> entry.getKey().getCategory() == Menu.Category.DESSERT)
                    .mapToInt(entry -> entry.getValue() * ChristmasConstant.WEEKDAY_DESSERT_DISCOUNT)
                    .sum();
        }
        return 0;
    }

    public int calculateWeekendDiscount(int date) {
        if (totalPrice < ChristmasConstant.MIN_TOTAL_PRICE_FOR_EVENT) {
            return 0;
        }
        if (Day.WEEKEND.getDays().contains(date)) {
            return orderItems.entrySet().stream()
                    .filter(entry -> entry.getKey().getCategory() == Menu.Category.MAIN)
                    .mapToInt(entry -> entry.getValue() * ChristmasConstant.WEEKEND_MAIN_DISCOUNT)
                    .sum();
        }
        return 0;
    }

    public int calculateSpecialDiscount(int date) {
        if (totalPrice < ChristmasConstant.MIN_TOTAL_PRICE_FOR_EVENT) {
            return 0;
        }
        List<Integer> starDays = Day.STARDAY.getDays();
        int discount = 0;
        if (starDays.contains(date)) {
            discount = ChristmasConstant.SPECIAL_DISCOUNT;
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
