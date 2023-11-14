package christmas.view;

import christmas.constant.Menu;
import christmas.domain.Event;
import java.text.NumberFormat;
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
}
