package view.command;

import java.util.Arrays;
import java.util.Objects;
import view.constants.ErrorMessage;

public enum PayTypeCommand {
    CARD("1"),
    CASH("2");

    private final String key;

    PayTypeCommand(String key) {
        this.key = key;
    }

    public static PayTypeCommand find(String key) {
        return Arrays.stream(values())
                .filter(value -> Objects.equals(value.key, key))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(ErrorMessage.INPUT_INVALID_COMMAND);
                });
    }
}
