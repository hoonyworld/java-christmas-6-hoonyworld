package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.Menu;
import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.StringJoiner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @AfterEach
    public void tearDown() {
        Console.close();
        System.setIn(System.in);
    }

    @Test
    @DisplayName("유효한 날짜 입력을 읽는 테스트")
    public void testReadDate_ValidInput() {
        provideInput("5");
        int result = InputView.readDate();
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("먼저 유효하지 않은 날짜 입력을 제공한 후 유효한 날짜 입력을 제공하는 테스트")
    public void testReadDate_InvalidThenValidInput() {
        provideInput("32", "5");
        int result = InputView.readDate();
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("유효한 메뉴와 메뉴 수 입력을 읽는 테스트")
    public void testReadMenuAndMenuCount_ValidInput() {
        provideInput("타파스-2,제로콜라-1");
        Map<Menu, Integer> result = InputView.readMenuAndMenuCount();
        assertThat(result).containsEntry(Menu.TAPAS, 2);
        assertThat(result).containsEntry(Menu.ZERO_COLA, 1);
    }

    @Test
    @DisplayName("먼저 유효하지 않은 메뉴와 메뉴 수 입력을 제공한 후 유효한 입력을 제공하는 테스트")
    public void testReadMenuAndMenuCount_InvalidThenValidInput() {
        provideInput("타파스-21,제로콜라-1", "타파스-2,제로콜라-1");
        Map<Menu, Integer> result = InputView.readMenuAndMenuCount();
        assertThat(result).containsEntry(Menu.TAPAS, 2);
        assertThat(result).containsEntry(Menu.ZERO_COLA, 1);
    }


    private void provideInput(String... inputs) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (String input : inputs) {
            joiner.add(input);
        }
        joiner.add(""); // Add an extra line to simulate pressing Enter
        System.setIn(new ByteArrayInputStream(joiner.toString().getBytes()));
    }
}
