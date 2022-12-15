package view;

import dto.MovieDTO;
import java.util.List;
import view.constants.Format;

public class OutputView {
    public static void printMovies(List<MovieDTO> movies) {
        movies.forEach(OutputView::printMovie);
    }

    private static void printMovie(MovieDTO movie) {
        String moneyLocaleDisplay = Format.MONEY_KRW.format(movie.getPrice());
        System.out.printf(Format.MOVIE_INFO, movie.getId(), movie.getName(), moneyLocaleDisplay);
    }
}
