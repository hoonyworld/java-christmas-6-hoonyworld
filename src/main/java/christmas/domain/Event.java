package christmas.domain;

import christmas.constant.Menu;

public class Event {
    private String eventName;

    public Event(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public static Event createChampagneEvent(int totalBeforeDiscount) {
        String eventName = "없음";
        if (totalBeforeDiscount >= 120000) {
            eventName = Menu.CHAMPAGNE.getName() + " 1개";
        }
        return new Event(eventName);
    }
}
