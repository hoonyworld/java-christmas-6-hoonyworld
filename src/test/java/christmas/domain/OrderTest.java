package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.Menu;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    @DisplayName("총 주문 금액 계산 테스트")
    void calculateTotalPriceTest() {
        // given
        Map<Menu, Integer> orderItems = new HashMap<>();
        orderItems.put(Menu.CAESAR_SALAD, 2);
        orderItems.put(Menu.T_BONE_STEAK, 1);
        Order order = new Order(orderItems);

        // when
        int totalPrice = order.calculateTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(8000 * 2 + 55000);
    }

    @Test
    @DisplayName("주문 아이템 확인 테스트")
    void getOrderItemsTest() {
        // given
        Map<Menu, Integer> orderItems = new HashMap<>();
        orderItems.put(Menu.CAESAR_SALAD, 2);
        orderItems.put(Menu.T_BONE_STEAK, 1);
        Order order = new Order(orderItems);

        // when
        Map<Menu, Integer> retrievedOrderItems = order.getOrderItems();

        // then
        assertThat(retrievedOrderItems).isEqualTo(orderItems);
    }
}
