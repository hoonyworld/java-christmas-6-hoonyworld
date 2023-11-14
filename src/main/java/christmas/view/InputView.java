package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.Menu;
import christmas.view.viewConstant.IllegalArgumentExceptionType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InputView {

    private InputView() {
    }

    // 방문 날짜를 받고 1~31 날짜 검증
    public static int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (1부터 31까지의 숫자만 입력해 주세요!)");
        try {
            String input = Console.readLine();
            int date = Integer.parseInt(input);
            if (date < 1 || date > 31) {
                throw IllegalArgumentExceptionType.DECEMBER_DATE_OUT_OF_RANGE.getException();
            }
            return date;
        } catch (NumberFormatException e) {
            throw IllegalArgumentExceptionType.DECEMBER_DATE_OUT_OF_RANGE.getException();
        }
    }

    public static Map<Menu, Integer> readMenuAndMenuCount() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        return validateMenuInput(input);
    }

    private static Map<Menu, Integer> validateMenuInput(String input) {
        String[] menuItems = input.split(",");
        Map<Menu, Integer> menuOrder = new HashMap<>();

        for (String menuItem : menuItems) {
            processMenuItem(menuItem, menuOrder);
        }
        return menuOrder;
    }

    private static void processMenuItem(String menuItem, Map<Menu, Integer> menuOrder) {
        String[] menuDetails = menuItem.split("-");
        String menuName = menuDetails[0];
        validateMenuFormat(menuDetails);
        int menuCount = parseMenuCount(menuDetails[1]);
        Menu menu = validateMenuExist(menuName);
        validateMenuCount(menuCount);
        validateMenuDuplicate(menu, menuOrder);
        menuOrder.put(menu, menuCount);
    }

    private static int parseMenuCount(String menuCountStr) {
        try {
            return Integer.parseInt(menuCountStr);
        } catch (NumberFormatException e) {
            throw IllegalArgumentExceptionType.INVALID_ORDER.getException();
        }
    }

    private static void validateMenuDuplicate(Menu menu, Map<Menu, Integer> menuOrder) {
        if (menuOrder.containsKey(menu)) {
            throw IllegalArgumentExceptionType.INVALID_ORDER.getException();
        }
    }

    private static void validateMenuFormat(String[] menuDetails) {
        if (menuDetails.length != 2 || menuDetails[0].isEmpty() || menuDetails[1].isEmpty()) {
            throw IllegalArgumentExceptionType.INVALID_ORDER.getException();
        }
    }

    private static Menu validateMenuExist(String menuName) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getName().equals(menuName))
                .findFirst()
                .orElseThrow(IllegalArgumentExceptionType.INVALID_ORDER::getException);
    }

    private static void validateMenuCount(int menuCount) {
        if (menuCount < 1) {
            throw IllegalArgumentExceptionType.INVALID_ORDER.getException();
        }
    }
}
