package model.domain;

import java.util.function.Function;

public enum PayType {
    CARD(amount -> (int) (amount * (0.95))),
    CASH(amount -> (int) (amount * (0.98)));

    private final Function<Integer, Integer> payMethod;

    PayType(Function<Integer, Integer> payMethod) {
        this.payMethod = payMethod;
    }

    public int pay(int payAmount) {
        return payMethod.apply(payAmount);
    }
}
