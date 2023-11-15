package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadgeTest {

    @Test
    @DisplayName("배지 테스트 - 첫 번째 임계값")
    void 배지_테스트_첫번째_임계값() {
        // given
        int totalBenefits = 20000;

        // when
        String badge = Badge.getBadge(totalBenefits);

        // then
        assertThat(badge).isEqualTo("산타");
    }

    @Test
    @DisplayName("배지 테스트 - 두 번째 임계값")
    void 배지_테스트_두번째_임계값() {
        // given
        int totalBenefits = 10000;

        // when
        String badge = Badge.getBadge(totalBenefits);

        // then
        assertThat(badge).isEqualTo("트리");
    }

    @Test
    @DisplayName("배지 테스트 - 세 번째 임계값")
    void 배지_테스트_세번째_임계값() {
        // given
        int totalBenefits = 5000;

        // when
        String badge = Badge.getBadge(totalBenefits);

        // then
        assertThat(badge).isEqualTo("별");
    }

    @Test
    @DisplayName("뱃지 테스트 - 뱃지 없음")
    void 뱃지_테스트_뱃지없음() {
        // given
        int totalBenefits = 4999;

        // when
        String badge = Badge.getBadge(totalBenefits);

        // then
        assertThat(badge).isEqualTo("없음");
    }
}
