package christmas.controller;

import christmas.constant.Menu;
import christmas.domain.Badge;
import christmas.domain.Discount;
import christmas.domain.Event;
import christmas.domain.Order;
import christmas.domain.PriceBenefit;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class ChristmasController {
    public void run() {
        int date = getDate();
        Map<Menu, Integer> menuOrder = getMenuOrder();

        Order order = createOrder(menuOrder);
        PriceBenefit priceBenefit = createPriceBenefit(order);

        printOrderDetails(date, order);
        printDiscountDetails(priceBenefit, date, order);
    }

    private int getDate() {
        return InputView.readDate();
    }

    private Map<Menu, Integer> getMenuOrder() {
        return InputView.readMenuAndMenuCount();
    }

    private Order createOrder(Map<Menu, Integer> menuOrder) {
        return new Order(menuOrder);
    }

    private PriceBenefit createPriceBenefit(Order order) {
        return new PriceBenefit(order.getOrderItems());
    }

    private void printOrderDetails(int date, Order order) {
        OutputView.printDate(date);
        OutputView.printMenu(order.getOrderItems());
        OutputView.printTotalPriceBeforeDiscount(order.calculateTotalPrice());
    }

    private void printDiscountDetails(PriceBenefit priceBenefit, int date, Order order) {
        int totalBeforeDiscount = order.calculateTotalPrice();
        Event event = Event.createChampagneEvent(totalBeforeDiscount);

        OutputView.printBenefits(totalBeforeDiscount, event.getEventName());
        OutputView.printBenefitsDetails(
                priceBenefit.calculateChristmasDayDiscount(date),
                priceBenefit.calculateWeekdayDiscount(date),
                priceBenefit.calculateWeekendDiscount(date),
                priceBenefit.calculateSpecialDiscount(date),
                event.getEventName(),
                event.getDiscount()
        );
        printFinalDetails(priceBenefit, date, totalBeforeDiscount, event);
    }

    private void printFinalDetails(PriceBenefit priceBenefit, int date, int totalBeforeDiscount, Event event) {
        int totalDiscount = priceBenefit.calculateTotalDiscount(date);
        Discount discount = new Discount(totalBeforeDiscount, totalDiscount, event);

        OutputView.printTotalBenefits(discount.calculateTotalBenefits());
        OutputView.printTotalPriceAfterDiscount(discount.calculateTotalPriceAfterDiscount());

        String badge = Badge.getBadge(discount.calculateTotalBenefits());
        OutputView.printBadge(badge);
    }
}
