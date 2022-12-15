package model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.constants.ErrorMessage;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private final List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<PlaySchedule> getPlaySchedules() {
        return Collections.unmodifiableList(playSchedules);
    }

    public void occupySeats(int scheduleIndex, int bookingQuantity) {
        findPlaySchedule(scheduleIndex).occupySeats(bookingQuantity);
    }

    private PlaySchedule findPlaySchedule(int scheduleIndex) {
        validateScheduleIndex(playSchedules.size(), scheduleIndex);
        return playSchedules.get(scheduleIndex - 1);
    }

    private void validateScheduleIndex(int schedulesSize, int scheduleIndex) {
        if (schedulesSize - 1 < scheduleIndex) {
            throw new IllegalArgumentException(ErrorMessage.SCHEDULE_INDEX_INVALID);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb;
    }
}
