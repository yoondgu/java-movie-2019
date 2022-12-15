package dto;

import java.util.List;

public class BookingSelection {
    private final int movieId;
    private final List<PlayScheduleDTO> playScheduleDTO;

    public BookingSelection(int movieId, List<PlayScheduleDTO> playScheduleDTO) {
        this.movieId = movieId;
        this.playScheduleDTO = playScheduleDTO;
    }

    public int getMovieId() {
        return movieId;
    }

    public List<PlayScheduleDTO> getPlayScheduleDTO() {
        return playScheduleDTO;
    }
}
