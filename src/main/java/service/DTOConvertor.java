package service;

import domain.Movie;
import dto.MovieDTO;

public class DTOConvertor {
    private DTOConvertor() {
    }

    public static MovieDTO from(Movie movie) {
        return new MovieDTO(movie.getId(), movie.getName(), movie.getPrice());
    }
}
