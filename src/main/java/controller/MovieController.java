package controller;

import dto.MovieDTO;
import dto.PlayScheduleDTO;
import java.util.List;
import model.service.MovieService;
import view.InputView;
import view.OutputView;

public class MovieController {
    private final MovieService movieService = new MovieService();

    public void run() {
        selectMovie();
    }

    private List<PlayScheduleDTO> selectMovie() {
        List<MovieDTO> allMovies = movieService.getAllMovies();
        OutputView.printMovies(allMovies);
        int movieId = InputView.inputMovieId();
        return movieService.findAllSchedulesByMovie(movieId);
    }

    private int selectPlaySchedule(int movieId) {
        // TODO 시간표 출력
        // TODO 시간표 번호 선택
        return 0;
    }
}
