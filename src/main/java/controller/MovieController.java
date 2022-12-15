package controller;

import dto.MovieDTO;
import java.util.List;
import service.MovieService;

public class MovieController {
    private final MovieService movieService = new MovieService();

    public void run() {
        selectMovie();
    }

    private int selectMovie() {
        List<MovieDTO> allMovies = movieService.getAllMovies();
        // TODO 영화 목록 출력
        // TODO 영화 번호 입력받기
        return 0;
    }
}
