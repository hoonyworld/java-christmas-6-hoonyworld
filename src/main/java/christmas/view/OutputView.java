package christmas.view;

import christmas.constant.Menu;
import christmas.domain.Event;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void printDate(int input) {
        System.out.println("12월 " + input + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public static void printMenu(Map<Menu, Integer> menuOrder) {
        System.out.println("<주문 메뉴>");
        for (Map.Entry<Menu, Integer> entry : menuOrder.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue() + "개");
        }
        System.out.println();
    }

    public static void printTotalPriceBeforeDiscount(int total) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formatPrice(total) + "원");
        System.out.println();
    }


    private static String formatPrice(int price) {
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(price);
    }

    public static void printBenefits(int totalBeforeDiscount) {
        System.out.println("<증정 메뉴>");
        Event event = Event.createChampagneEvent(totalBeforeDiscount);
        System.out.println(event.getEventName());
        System.out.println();
    }

    public static void printBenefitsDetails(int christmasDayDiscount, int weekdayDiscount, int weekendDiscount,
                                            int specialDiscount, Event event) {
        System.out.println("<혜택 내역>");
        List<String> benefits = new ArrayList<>();
        if (christmasDayDiscount != 0) {
            benefits.add("크리스마스 디데이 할인: " + "-" + formatPrice(christmasDayDiscount) + "원");
        }
        if (weekdayDiscount != 0) {
            benefits.add("평일 할인: " + "-" + formatPrice(weekdayDiscount) + "원");
        }
        if (weekendDiscount != 0) {
            benefits.add("주말 할인: " + "-" + formatPrice(weekendDiscount) + "원");
        }
        if (specialDiscount != 0) {
            benefits.add("특별 할인: " + "-" + formatPrice(specialDiscount) + "원");
        }
        if (event.getDiscount() != 0) {
            benefits.add("증정 이벤트: " + "-" + formatPrice(event.getDiscount()) + "원");
        }
        if (benefits.isEmpty()) {
            System.out.println("없음");
        }
        for (String benefit : benefits) {
            System.out.println(benefit);
        }
        System.out.println();
    }

    public static void printTotalBenefits(int totalBenefits) {
        System.out.println("<총혜택 금액>");
        System.out.println("-" + formatPrice(totalBenefits) + "원");
        System.out.println();
    }

    public static void printTotalPriceAfterDiscount(int totalPriceAfterDiscount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(formatPrice(totalPriceAfterDiscount) + "원");
        System.out.println();
    }

    public static void printBadge(String badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
        System.out.println();
    }

}
