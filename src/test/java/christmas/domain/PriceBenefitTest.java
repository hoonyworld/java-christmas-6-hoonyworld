package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.Menu;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceBenefitTest {
    private Map<Menu, Integer> orderItems;
    private PriceBenefit priceBenefit;

    @BeforeEach
    void setUp() {
        orderItems = new HashMap<>();
    }

    @Test
    @DisplayName("크리스마스 디데이 할인 계산")
    void calculateChristmasDayDiscount() {
        orderItems.put(Menu.CHRISTMAS_PASTA, 1);
        orderItems.put(Menu.ICE_CREAM, 2);
        priceBenefit = new PriceBenefit(orderItems);

        int discount = priceBenefit.calculateChristmasDayDiscount(25);

        assertThat(discount).isEqualTo(3400);
    }

    @Test
    @DisplayName("평일 디저트 할인 계산")
    void calculateWeekdayDiscount() {
        orderItems.put(Menu.ICE_CREAM, 3);
        priceBenefit = new PriceBenefit(orderItems);

        int discount = priceBenefit.calculateWeekdayDiscount(5);

        assertThat(discount).isEqualTo(6069);
    }

    @Test
    @DisplayName("주말 메인 할인 계산")
    void calculateWeekendDiscount() {
        orderItems.put(Menu.T_BONE_STEAK, 1);
        priceBenefit = new PriceBenefit(orderItems);

        int discount = priceBenefit.calculateWeekendDiscount(9);

        assertThat(discount).isEqualTo(2023);
    }

    @Test
    @DisplayName("특별 할인 계산")
    void calculateSpecialDiscount() {
        orderItems.put(Menu.CHRISTMAS_PASTA, 1);
        priceBenefit = new PriceBenefit(orderItems);

        int discount = priceBenefit.calculateSpecialDiscount(4);

        assertThat(discount).isEqualTo(0);
    }

    @Test
    @DisplayName("총 할인 계산")
    void calculateTotalDiscount() {
        orderItems.put(Menu.CHRISTMAS_PASTA, 1);
        orderItems.put(Menu.ICE_CREAM, 2);
        orderItems.put(Menu.T_BONE_STEAK, 1);
        priceBenefit = new PriceBenefit(orderItems);

        int discount = priceBenefit.calculateTotalDiscount(25);

        assertThat(discount).isEqualTo(8446);
    }
}
