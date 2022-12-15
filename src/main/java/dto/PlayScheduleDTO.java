package dto;

public class PlayScheduleDTO {
    private final String startDateTime;
    private final int capacity;

    public PlayScheduleDTO(String startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "PlayScheduleDTO{" +
                "startDateTime='" + startDateTime + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
