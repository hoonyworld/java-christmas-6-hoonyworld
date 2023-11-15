package christmas.view;

import christmas.constant.Menu;
import christmas.domain.Event;
import christmas.view.viewConstant.MessageConstant;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void printDate(int input) {
        System.out.println(MessageConstant.DATE_MESSAGE_PREFIX + input + MessageConstant.DATE_MESSAGE_SUFFIX);
        System.out.println();
    }

    public static void printMenu(Map<Menu, Integer> menuOrder) {
        System.out.println(MessageConstant.ORDER_MENU_HEADER);
        for (Map.Entry<Menu, Integer> entry : menuOrder.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue() + MessageConstant.ORDER_MENU_COUNT);
        }
        System.out.println();
    }

    public static void printTotalPriceBeforeDiscount(int total) {
        System.out.println(MessageConstant.TOTAL_PRICE_BEFORE_DISCOUNT_HEADER);
        System.out.println(formatPrice(total) + MessageConstant.WON_SUFFIX);
        System.out.println();
    }


    private static String formatPrice(int price) {
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(price);
    }

    public static void printBenefits(int totalBeforeDiscount) {
        System.out.println(MessageConstant.BENEFITS_MENU_HEADER);
        Event event = Event.createChampagneEvent(totalBeforeDiscount);
        System.out.println(event.getEventName());
        System.out.println();
    }

    public static void printBenefitsDetails(int christmasDayDiscount, int weekdayDiscount, int weekendDiscount,
                                            int specialDiscount, Event event) {
        System.out.println(MessageConstant.BENEFITS_DETAILS_HEADER);
        List<String> benefits = new ArrayList<>();
        addBenefit(benefits, MessageConstant.CHRISTMAS_DAY_DISCOUNT, christmasDayDiscount);
        addBenefit(benefits, MessageConstant.WEEKDAY_DISCOUNT, weekdayDiscount);
        addBenefit(benefits, MessageConstant.WEEKEND_DISCOUNT, weekendDiscount);
        addBenefit(benefits, MessageConstant.SPECIAL_DISCOUNT, specialDiscount);
        addBenefit(benefits, MessageConstant.EVENT_DISCOUNT, event.getDiscount());

        printBenefits(benefits);
        System.out.println();
    }

    private static void addBenefit(List<String> benefits, String benefitName, int discount) {
        if (discount != 0) {
            benefits.add(benefitName + ": " + MessageConstant.MINUS_PREFIX + formatPrice(discount)
                    + MessageConstant.WON_SUFFIX);
        }
    }

    private static void printBenefits(List<String> benefits) {
        if (benefits.isEmpty()) {
            System.out.println(MessageConstant.NO_BENEFITS_MESSAGE);
            return;
        }
        benefits.forEach(System.out::println);
    }

    public static void printTotalBenefits(int totalBenefits) {
        System.out.println(MessageConstant.TOTAL_BENEFITS_HEADER);
        String formattedTotalBenefits = formatPrice(totalBenefits);

        if (totalBenefits != 0) {
            formattedTotalBenefits = "-" + formattedTotalBenefits;
        }

        System.out.println(formattedTotalBenefits + MessageConstant.WON_SUFFIX);
        System.out.println();
    }

    public static void printTotalPriceAfterDiscount(int totalPriceAfterDiscount) {
        System.out.println(MessageConstant.TOTAL_PRICE_AFTER_DISCOUNT_HEADER);
        System.out.println(formatPrice(totalPriceAfterDiscount) + MessageConstant.WON_SUFFIX);
        System.out.println();
    }

    public static void printBadge(String badge) {
        System.out.println(MessageConstant.EVENT_BADGE_HEADER);
        System.out.println(badge);
        System.out.println();
    }
}
