package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.constant.IllegalArgumentExceptionType;

public class InputView {

    private InputView() {
    }

    // 방문 날짜를 받고 1~31 날짜 검증
    public static int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (1부터 31까지의 숫자만 입력해 주세요!)");
        try {
            String input = Console.readLine();
            if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 31) {
                throw IllegalArgumentExceptionType.DECEMBER_DATE_OUT_OF_RANGE.getException();
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw IllegalArgumentExceptionType.NOT_NUMBER.getException();
        }
    }
}

