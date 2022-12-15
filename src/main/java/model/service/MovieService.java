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

    public BookingInfo makeBookingInfo(int movieId, int scheduleIndex, int bookingQuantity) {
        Movie selectedMovie = findMovie(movieId);
        selectedMovie.occupySeats(scheduleIndex, bookingQuantity);
        return new BookingInfo(selectedMovie.getPrice(), bookingQuantity);
    }
}
