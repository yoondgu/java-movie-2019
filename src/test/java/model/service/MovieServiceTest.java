package model.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MovieServiceTest {
    private static final MovieService movieService = new MovieService();

    @Test
    void 시간표목록_조회_잘못된_영화번호_예외발생() {
        assertThatThrownBy(() -> movieService.findAllSchedulesByMovie(Integer.MAX_VALUE))
                .isInstanceOf(IllegalArgumentException.class);
    }
}