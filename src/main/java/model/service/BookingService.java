package model.service;

import model.constants.ErrorMessage;
import model.domain.BookingInfo;
import model.domain.PayType;
import model.domain.PlaySchedule;

public class BookingService {
    private int totalBookingAmount = 0;

    // TODO 테스트 코드 작성
    public void bookSchedule(BookingInfo bookingInfo) {
        PlaySchedule bookingSchedule = bookingInfo.getSelectedSchedule();
        // TODO 좌석 수 변경 반영안됨 수정 필요
        bookingSchedule.occupySeats(bookingInfo.getQuantity());
        totalBookingAmount += bookingInfo.computeTotalPrice();
    }

    // TODO 테스트 코드 작성
    public int payBooking(int pointAmount, PayType payType) {
        if (payType == null) {
            throw new NullPointerException(ErrorMessage.PAY_TYPE_NULL);
        }
        if (pointAmount > totalBookingAmount) {
            return pointAmount - totalBookingAmount;
        }
        return payType.pay(totalBookingAmount - pointAmount);
    }
}