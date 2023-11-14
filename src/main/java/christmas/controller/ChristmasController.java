package christmas.controller;

import christmas.constant.Day;
import christmas.constant.Menu;
import christmas.domain.Badge;
import christmas.domain.Discount;
import christmas.domain.Event;
import christmas.domain.Order;
import christmas.domain.PriceBenefit;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.Map;

public class ChristmasController {
    public void run() {
        int date = InputView.readDate();
        Map<Menu, Integer> menuOrder = InputView.readMenuAndMenuCount();

        Order order = new Order(menuOrder);
        int totalBeforeDiscount = order.calculateTotalPrice();

        PriceBenefit priceBenefit = new PriceBenefit(order.getOrderItems());
        int christmasDayDiscount = priceBenefit.calculateChristmasDayDiscount(date);
        int weekdayDiscount = priceBenefit.calculateWeekdayDiscount(date);
        int weekendDiscount = priceBenefit.calculateWeekendDiscount(date);
        List<Integer> starDays = Day.STARDAY.getDays();
        int specialDiscount = priceBenefit.calculateSpecialDiscount(starDays.contains(date));

        OutputView.printDate(date);
        OutputView.printMenu(order.getOrderItems());
        OutputView.printTotalPriceBeforeDiscount(totalBeforeDiscount);
        OutputView.printBenefits(totalBeforeDiscount);

        Event event = Event.createChampagneEvent(totalBeforeDiscount);
        OutputView.printBenefitsDetails(christmasDayDiscount, weekdayDiscount, weekendDiscount, specialDiscount, event);

        int totalDiscount = priceBenefit.calculateTotalDiscount(date, starDays.contains(date));
        Discount discount = new Discount(totalBeforeDiscount, totalDiscount, event);

        OutputView.printTotalBenefits(discount.calculateTotalBenefits());
        OutputView.printTotalPriceAfterDiscount(discount.calculateTotalPriceAfterDiscount());

        String badge = Badge.getBadge(discount.calculateTotalBenefits());
        OutputView.printBadge(badge);
    }
}



