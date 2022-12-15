package model.service;

import model.domain.BookingInfo;
import model.domain.PlaySchedule;

public class BookingService {
    private int totalBookingAmount = 0;

    // TODO 테스트 코드 작성
    public void bookSchedule(BookingInfo bookingInfo) {
        PlaySchedule bookingSchedule = bookingInfo.getSelectedSchedule();
        bookingSchedule.occupySeats(bookingInfo.getQuantity());
        totalBookingAmount += bookingInfo.computeTotalPrice();
    }

    // TODO 결제 진행
}