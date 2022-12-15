package model.service;

import dto.MovieDTO;
import dto.PlayScheduleDTO;
import java.util.List;
import java.util.stream.Collectors;
import model.constants.ErrorMessage;
import model.domain.Movie;
import model.domain.MovieRepository;
import model.domain.PlaySchedule;

public class MovieService {
    private int totalBookingAmount = 0;

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
        Movie movie = MovieRepository.findMovieById(movieId);
        validateFoundMovie(movie);
        List<PlaySchedule> playSchedules = movie.getPlaySchedules();
        validateFoundSchedules(playSchedules);
        return movie.getPlaySchedules()
                .stream()
                .map(DTOConvertor::from)
                .collect(Collectors.toList());
    }

    private void validateFoundMovie(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException(ErrorMessage.MOVIE_NOT_FOUND);
        }
    }

    private void validateFoundSchedules(List<PlaySchedule> playSchedules) {
        if (playSchedules.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.MOVIE_SCHEDULES_NOT_FOUND);
        }
    }

    // TODO 영화, 시간표 조회 관련 중복 메소드 검토
    // TODO 영화, 시간표 조회 로직과 예약 로직 클래스 분리 검토
    // TODO 검토 완료 후 테스트 작성
    public void book(int movieId, int scheduleIndex, int bookingQuantity) {
        Movie movie = MovieRepository.findMovieById(movieId);
        validateFoundMovie(movie);
        List<PlaySchedule> playSchedules = movie.getPlaySchedules();
        validateScheduleIndex(playSchedules.size(), scheduleIndex);
        PlaySchedule bookingSchedule = playSchedules.get(scheduleIndex);
        bookingSchedule.occupySeats(bookingQuantity);
        totalBookingAmount += computeBookingAmount(movie, bookingQuantity);
    }

    private void validateScheduleIndex(int schedulesSize, int scheduleIndex) {
        if (schedulesSize - 1 < scheduleIndex) {
            throw new IllegalArgumentException(ErrorMessage.SCHEDULE_INDEX_INVALID);
        }
    }

    private int computeBookingAmount(Movie movie, int bookingQuantity) {
        return (movie.getPrice()) * bookingQuantity;
    }
}
