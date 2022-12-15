package service;

import domain.Movie;
import domain.MovieRepository;
import dto.MovieDTO;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    public List<MovieDTO> getAllMovies() {
        List<Movie> allMovies = MovieRepository.getMovies();
        return allMovies.stream()
                .map(DTOConvertor::from)
                .collect(Collectors.toList());
    }
}
