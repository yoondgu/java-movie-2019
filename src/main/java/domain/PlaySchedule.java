package domain;

import static utils.DateTimeUtils.format;

import java.time.LocalDateTime;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private final int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
