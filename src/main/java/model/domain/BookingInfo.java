package model.domain;

public class BookingInfo {
    private final int price;
    private final int quantity;
    private final PlaySchedule selectedSchedule;

    public BookingInfo(int price, int quantity, PlaySchedule selectedSchedule) {
        this.price = price;
        this.quantity = quantity;
        this.selectedSchedule = selectedSchedule;
    }

    public int computeTotalPrice() {
        return price * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public PlaySchedule getSelectedSchedule() {
        return selectedSchedule;
    }
}
