package model.domain;

public class BookingInfo {
    private final int price;
    private final int scheduleIndex;
    private final int quantity;

    public BookingInfo(int price, int scheduleIndex, int quantity) {
        this.price = price;
        this.scheduleIndex = scheduleIndex;
        this.quantity = quantity;
    }

    public int computeTotalPrice() {
        return price * quantity;
    }

    public int getScheduleIndex() {
        return scheduleIndex;
    }
}
