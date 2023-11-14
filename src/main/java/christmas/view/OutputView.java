package christmas.view;

import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void printDate(int input) {
        System.out.println("12월 " + input + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public static void printMenu(Map<String, Integer> menuOrder) {
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> entry : menuOrder.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "개");
        }
        System.out.println();
    }

}
