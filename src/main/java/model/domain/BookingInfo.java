package model.domain;

public class BookingInfo {
    private final int price;
    private final int quantity;

    public BookingInfo(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public int computeTotalPrice() {
        return price * quantity;
    }
}
