package christmas.domain;

import christmas.constant.ChristmasConstant;
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
        String eventName = ChristmasConstant.NO_CHAMPAGNE;
        int discount = 0;
        if (totalBeforeDiscount >= ChristmasConstant.GIVE_CHAMPAGNE_THRESHOLD) {
            eventName = Menu.CHAMPAGNE.getName() + " " + ChristmasConstant.ONE_CHAMPAGNE_SERVE;
            discount = ChristmasConstant.CHAMPAGNE_DISCOUNT_AMOUNT;
        }
        return new Event(eventName, discount);
    }
}


