package model.service;

import dto.MovieDTO;
import dto.PlayScheduleDTO;
import model.domain.Movie;
import model.domain.PlaySchedule;

public class DTOConvertor {
    private DTOConvertor() {
    }

    public static MovieDTO from(Movie movie) {
        return new MovieDTO(movie.getId(), movie.getName(), movie.getPrice());
    }

    public static PlayScheduleDTO from(PlaySchedule playSchedule) {
        return new PlayScheduleDTO(playSchedule.getFormattedStartDateTime(), playSchedule.getCapacity());
    }
}
