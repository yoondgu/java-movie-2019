package view.util;

import view.constants.ErrorMessage;

public class NumberParser {
    private NumberParser() {
    }

    public static int parseDigit(String value) {
        int number = parseInteger(value);
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_DIGIT);
        }
        return number;
    }

    public static int parseNaturalNumber(String value) {
        int number = parseInteger(value);
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NATURAL_NUMBER);
        }
        return number;
    }

    public static int parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_INTEGER);
        }
    }
}
