package controller;

import dto.MovieDTO;
import java.util.List;
import service.MovieService;
import view.InputView;
import view.OutputView;

public class MovieController {
    private final MovieService movieService = new MovieService();

    public void run() {
        selectMovie();
    }

    private int selectMovie() {
        List<MovieDTO> allMovies = movieService.getAllMovies();
        OutputView.printMovies(allMovies);
        if (allMovies.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return InputView.inputMovieId();
    }
}
