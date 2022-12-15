package model.service;

import dto.MovieDTO;
import dto.PlayScheduleDTO;
import java.util.List;
import java.util.stream.Collectors;
import model.constants.ErrorMessage;
import model.domain.BookingInfo;
import model.domain.Movie;
import model.domain.MovieRepository;
import model.domain.PlaySchedule;

public class MovieService {
    private final int totalBookingAmount = 0;

    public List<MovieDTO> getAllMovies() {
        List<Movie> allMovies = MovieRepository.getMovies();
        validateAllMovies(allMovies);
        return allMovies.stream()
                .map(DTOConvertor::from)
                .collect(Collectors.toList());
    }

    private void validateAllMovies(List<Movie> allMovies) {
        if (allMovies.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.MOVIES_NOT_FOUND);
        }
    }

    public List<PlayScheduleDTO> findAllSchedulesByMovie(int movieId) {
        Movie movie = findMovie(movieId);
        List<PlaySchedule> playSchedules = movie.getPlaySchedules();
        validateFoundSchedules(playSchedules);
        return movie.getPlaySchedules()
                .stream()
                .map(DTOConvertor::from)
                .collect(Collectors.toList());
    }

    private void validateFoundSchedules(List<PlaySchedule> playSchedules) {
        if (playSchedules.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.MOVIE_SCHEDULES_NOT_FOUND);
        }
    }

    private Movie findMovie(int movieId) {
        Movie movie = MovieRepository.findMovieById(movieId);
        validateFoundMovie(movie);
        return movie;
    }

    private void validateFoundMovie(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException(ErrorMessage.MOVIE_NOT_FOUND);
        }
    }

    // TODO 테스트 코드 작성
    public BookingInfo makeBookingInfo(int movieId, int scheduleIndex, int bookingQuantity) {
        Movie selectedMovie = findMovie(movieId);
        PlaySchedule selectedSchedule = findPlaySchedule(selectedMovie, scheduleIndex);
        return new BookingInfo(selectedMovie.getPrice(), bookingQuantity, selectedSchedule);
    }

    private PlaySchedule findPlaySchedule(Movie movie, int scheduleIndex) {
        List<PlaySchedule> playSchedules = movie.getPlaySchedules();
        validateScheduleIndex(playSchedules.size(), scheduleIndex);
        return playSchedules.get(scheduleIndex);
    }

    private void validateScheduleIndex(int schedulesSize, int scheduleIndex) {
        if (schedulesSize - 1 < scheduleIndex) {
            throw new IllegalArgumentException(ErrorMessage.SCHEDULE_INDEX_INVALID);
        }
    }
}
