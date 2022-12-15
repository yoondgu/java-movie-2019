package model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static utils.DateTimeUtils.createDateTime;

import org.junit.jupiter.api.Test;

class PlayScheduleTest {
    @Test
    void 예매좌석_선점_성공() {
        PlaySchedule playSchedule = new PlaySchedule(createDateTime("2019-04-16 08:00"), 3);
        playSchedule.occupySeats(1);

        assertThat(playSchedule.getCapacity()).isEqualTo(2);
    }

    @Test
    void 예매좌석_선점_자리부족_예외발생() {
        PlaySchedule playSchedule = new PlaySchedule(createDateTime("2019-04-16 08:00"), 0);

        assertThatThrownBy(() -> playSchedule.occupySeats(1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}