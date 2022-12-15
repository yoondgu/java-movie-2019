import domain.Movie;
import domain.MovieRepository;
import java.util.List;
import view.InputView;
import view.OutputView;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        // TODO 구현 진행
    }
}
