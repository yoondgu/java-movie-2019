package model.service;

import model.constants.ErrorMessage;
import model.domain.BookingInfo;
import model.domain.PayType;

public class BookingService {
    private int totalBookingAmount = 0;

    // TODO 테스트 코드 작성
    public void addBooking(BookingInfo bookingInfo) {
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