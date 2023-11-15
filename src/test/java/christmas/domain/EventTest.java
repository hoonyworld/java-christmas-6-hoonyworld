package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventTest {

    @Test
    @DisplayName("샴페인 증정 이벤트 테스트")
    void createChampagneEventTest() {
        // given
        int totalBeforeDiscount = 120000;

        // when
        Event event = Event.createChampagneEvent(totalBeforeDiscount);

        // then
        assertThat(event.getEventName()).isEqualTo("샴페인 1개");
        assertThat(event.getDiscount()).isEqualTo(25000);
    }

    @Test
    @DisplayName("샴페인 증정 없는 테스트")
    void createNoChampagneEventTest() {
        // given
        int totalBeforeDiscount = 119999;

        // when
        Event event = Event.createChampagneEvent(totalBeforeDiscount);

        // then
        assertThat(event.getEventName()).isEqualTo("없음");
        assertThat(event.getDiscount()).isEqualTo(0);
    }
}