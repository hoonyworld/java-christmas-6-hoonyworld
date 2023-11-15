package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountTest {

    @Test
    @DisplayName("총 혜택 계산 테스트")
    void calculateTotalBenefitsTest() {
        // given
        Event event = new Event("Test Event", 100);
        Discount discount = new Discount(10000, 500, event);

        // when
        int totalBenefits = discount.calculateTotalBenefits();

        // then
        assertThat(totalBenefits).isEqualTo(600);
    }

    @Test
    @DisplayName("할인 적용 후 총 가격 계산 테스트")
    void calculateTotalPriceAfterDiscountTest() {
        // given
        Event event = new Event("Test Event", 100);
        Discount discount = new Discount(10000, 500, event);

        // when
        int totalPriceAfterDiscount = discount.calculateTotalPriceAfterDiscount();

        // then
        assertThat(totalPriceAfterDiscount).isEqualTo(9500);
    }
}
