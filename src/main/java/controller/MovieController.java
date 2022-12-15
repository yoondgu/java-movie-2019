package controller;

import dto.MovieDTO;
import java.util.List;
import model.domain.BookingInfo;
import model.domain.BookingSelection;
import model.domain.PayType;
import model.service.BookingService;
import model.service.MovieService;
import view.InputView;
import view.OutputView;
import view.command.PayTypeCommand;

public class MovieController {
    private final MovieService movieService = new MovieService();
    private final BookingService bookingService = new BookingService();

    public void run() {
        BookingSelection bookingSelection = selectMovie();
        bookMovie(bookingSelection);
        boolean toGoPay = InputView.inputActionCommand();
        if (!toGoPay) {
            run();
            return;
        }
        payBooking();
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
        BookingInfo bookingInfo = movieService.makeBookingInfo(bookingSelection.getMovieId(), scheduleIndex,
                bookingQuantity);
        bookingService.bookSchedule(bookingInfo);
    }

    private void payBooking() {
        int pointAmount = InputView.inputPointAmount();
        PayTypeCommand payTypeCommand = InputView.inputPayTypeCommand();
        int totalPayment = bookingService.payBooking(pointAmount, convert(payTypeCommand));
        OutputView.printTotalPayment(totalPayment);
        OutputView.printInformBookingCompleted();
    }

    private PayType convert(PayTypeCommand command) {
        if (command == PayTypeCommand.CARD) {
            return PayType.CARD;
        }
        if (command == PayTypeCommand.CASH) {
            return PayType.CASH;
        }
        return null;
    }
}
