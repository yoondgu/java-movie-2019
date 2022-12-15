package view;

import dto.MovieDTO;
import java.util.List;
import view.constants.OutputFormat;

public class OutputView {
    public static void printMovies(List<MovieDTO> movies) {
        movies.forEach(OutputView::printMovie);
    }

    private static void printMovie(MovieDTO movie) {
        String moneyLocaleDisplay = OutputFormat.MONEY_KRW.format(movie.getPrice());
        System.out.printf(OutputFormat.MOVIE_INFO, movie.getId(), movie.getName(), moneyLocaleDisplay);
    }
}
