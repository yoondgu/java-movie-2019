package view;

import dto.MovieDTO;
import java.util.List;
import view.constants.Format;
import view.constants.OutputMessage;

public class OutputView {
    public static void printMovies(List<MovieDTO> movies) {
        movies.forEach(OutputView::printMovie);
    }

    private static void printMovie(MovieDTO movie) {
        String moneyLocaleDisplay = Format.MONEY_KRW.format(movie.getPrice());
        System.out.printf(Format.MOVIE_INFO, movie.getId(), movie.getName(), moneyLocaleDisplay);
    }

    public static void printTotalPayment(int totalPayment) {
        String moneyLocaleDisplay = Format.MONEY_KRW.format(totalPayment);
        System.out.printf(Format.TOTAL_PAYMENT_INFO, moneyLocaleDisplay);
    }

    public static void printInformBookingCompleted() {
        System.out.println(OutputMessage.INFORM_BOOKING_COMPLETE);
    }
}
