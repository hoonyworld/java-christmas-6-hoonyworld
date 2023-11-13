package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        return convertToIntegerValue(input);
    }

    private static int convertToIntegerValue(String inputStringValue) {
        try {
            long changeLongValue = Long.parseLong(inputStringValue);
            if (changeLongValue < Integer.MIN_VALUE || changeLongValue > Integer.MAX_VALUE) {
                throw new IllegalArgumentException(
                        "[ERROR] : 구입 금액은 " + Integer.MIN_VALUE + "에서" + Integer.MAX_VALUE + "사이의 값이어야 합니다");
            }
            return (int) changeLongValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력이 가능해요");
        }
    }
}
