package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.Menu;
import christmas.view.viewConstant.IllegalArgumentExceptionType;
import christmas.view.viewConstant.MessageConstant;
import christmas.view.viewConstant.NumberConstant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InputView {
    private InputView() {
    }

    // 방문 날짜를 받고 1~31 날짜 검증
    public static int readDate() {
        System.out.println(MessageConstant.WELCOME_MESSAGE);
        System.out.println(MessageConstant.DATE_PROMPT_MESSAGE);
        try {
            String input = Console.readLine();
            int date = Integer.parseInt(input);
            if (date < NumberConstant.MIN_DATE || date > NumberConstant.MAX_DATE) {
                throw IllegalArgumentExceptionType.DECEMBER_DATE_OUT_OF_RANGE.getException();
            }
            return date;
        } catch (NumberFormatException e) {
            throw IllegalArgumentExceptionType.DECEMBER_DATE_OUT_OF_RANGE.getException();
        }
    }

    public static Map<Menu, Integer> readMenuAndMenuCount() {
        System.out.println(MessageConstant.MENU_ORDER_PROMPT_MESSAGE);
        String input = Console.readLine();
        Map<Menu, Integer> menuOrder = validateMenuInput(input);
        validateTotalOrder(menuOrder);
        validateDrinkOnlyOrder(menuOrder);
        return menuOrder;
    }

    private static Map<Menu, Integer> validateMenuInput(String input) {
        String[] menuItems = input.split(",");
        Map<Menu, Integer> menuOrder = new HashMap<>();

        for (String menuItem : menuItems) {
            processMenuItem(menuItem, menuOrder);
        }
        return menuOrder;
    }

    private static void validateTotalOrder(Map<Menu, Integer> menuOrder) {
        int totalOrder = menuOrder.values().stream().mapToInt(Integer::intValue).sum();
        if (totalOrder > 20) {
            throw IllegalArgumentExceptionType.INVALID_ORDER.getException();
        }
    }

    private static void validateDrinkOnlyOrder(Map<Menu, Integer> menuOrder) {
        boolean isDrinkOnly = menuOrder.keySet().stream().allMatch(menu -> menu.getCategory() == Menu.Category.DRINK);
        if (isDrinkOnly) {
            throw IllegalArgumentExceptionType.INVALID_ORDER.getException();
        }
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
        if (menuDetails.length != NumberConstant.MENU_DETAILS_LENGTH || menuDetails[0].isEmpty()
                || menuDetails[1].isEmpty()) {
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
        if (menuCount < NumberConstant.MIN_MENU_COUNT) {
            throw IllegalArgumentExceptionType.INVALID_ORDER.getException();
        }
    }
}
