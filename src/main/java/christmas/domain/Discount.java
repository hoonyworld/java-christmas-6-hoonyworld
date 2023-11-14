package christmas.domain;

public class Discount {
    private int totalBeforeDiscount;
    private int totalDiscount;
    private Event event;

    public Discount(int totalBeforeDiscount, int totalDiscount, Event event) {
        this.totalBeforeDiscount = totalBeforeDiscount;
        this.totalDiscount = totalDiscount;
        this.event = event;
    }

    public int calculateTotalBenefits() {
        return totalDiscount + event.getDiscount();
    }

    public int calculateTotalPriceAfterDiscount() {
        return totalBeforeDiscount - totalDiscount;
    }
}
