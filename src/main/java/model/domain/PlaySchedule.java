package model.domain;

import static utils.DateTimeUtils.format;

import java.time.LocalDateTime;
import model.constants.ErrorMessage;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public String getFormattedStartDateTime() {
        return format(startDateTime);
    }

    public int getCapacity() {
        return capacity;
    }

    public void occupySeats(int count) {
        validateOccupyCount(count);
        capacity -= count;
    }

    private void validateOccupyCount(int count) {
        if (count > capacity) {
            throw new IllegalArgumentException(ErrorMessage.SCHEDULE_CAPACITY_LACK);
        }
    }
}
