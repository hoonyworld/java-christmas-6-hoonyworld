package christmas.domain;

import christmas.constant.Menu;

public class Event {
    private String eventName;
    private int discount;

    public Event(String eventName, int discount) {
        this.eventName = eventName;
        this.discount = discount;
    }

    public String getEventName() {
        return eventName;
    }

    public int getDiscount() {
        return discount;
    }

    public static Event createChampagneEvent(int totalBeforeDiscount) {
        String eventName = "없음";
        int discount = 0;
        if (totalBeforeDiscount >= 120000) {
            eventName = Menu.CHAMPAGNE.getName() + " 1개";
            discount = 25000;
        }
        return new Event(eventName, discount);
    }
}


