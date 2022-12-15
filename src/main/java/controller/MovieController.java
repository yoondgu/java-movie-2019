package controller;

import dto.BookingSelectionDTO;
import dto.MovieDTO;
import java.util.List;
import model.domain.BookingInfo;
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
        BookingSelectionDTO bookingSelectionDTO = selectMovie();
        addBooking(bookingSelectionDTO);
        boolean toGoPay = InputView.inputActionCommand();
        if (!toGoPay) {
            run();
            return;
        }
        completeBooking();
    }

    private BookingSelectionDTO selectMovie() {
        List<MovieDTO> allMovies = movieService.getAllMovies();
        OutputView.printMovies(allMovies);
        int movieId = InputView.inputMovieId();
        return new BookingSelectionDTO(movieId, movieService.findAllSchedulesByMovie(movieId));
    }

    private void addBooking(BookingSelectionDTO bookingSelectionDTO) {
        int scheduleIndex = InputView.inputPlayScheduleIndex(bookingSelectionDTO.getPlayScheduleDTO());
        int bookingQuantity = InputView.inputBookingQuantity();
        BookingInfo bookingInfo = movieService.makeBookingInfo(bookingSelectionDTO.getMovieId(), scheduleIndex,
                bookingQuantity);
        bookingService.addBooking(bookingInfo);
    }

    private void completeBooking() {
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
