package model.service;

import dto.MovieDTO;
import dto.PlayScheduleDTO;
import java.util.List;
import java.util.stream.Collectors;
import model.constants.ErrorMessage;
import model.domain.Movie;
import model.domain.MovieRepository;

public class MovieService {
    public List<MovieDTO> getAllMovies() {
        List<Movie> allMovies = MovieRepository.getMovies();
        validateAllMovies(allMovies);
        return allMovies.stream()
                .map(DTOConvertor::from)
                .collect(Collectors.toList());
    }

    private void validateAllMovies(List<Movie> allMovies) {
        if (allMovies.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.MOVIES_NOT_FOUND);
        }
    }

    public List<PlayScheduleDTO> findAllSchedulesByMovie(int movieId) {
        return null;
    }
}
