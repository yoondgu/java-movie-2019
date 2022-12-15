package controller;

import dto.BookingSelection;
import dto.MovieDTO;
import java.util.List;
import model.service.MovieService;
import view.InputView;
import view.OutputView;

public class MovieController {
    private final MovieService movieService = new MovieService();

    public void run() {
        BookingSelection bookingSelection = selectMovie();
        bookMovie(bookingSelection);
    }

    private BookingSelection selectMovie() {
        List<MovieDTO> allMovies = movieService.getAllMovies();
        OutputView.printMovies(allMovies);
        int movieId = InputView.inputMovieId();
        return new BookingSelection(movieId, movieService.findAllSchedulesByMovie(movieId));
    }

    private void bookMovie(BookingSelection bookingSelection) {
        int scheduleIndex = InputView.inputPlayScheduleIndex(bookingSelection.getPlayScheduleDTO());
        int bookingQuantity = InputView.inputBookingQuantity();
        movieService.book(bookingSelection.getMovieId(), scheduleIndex, bookingQuantity);
    }

    // TOOD 결제 / 추가 예매 여부 확인
    // TODO 결제
}
