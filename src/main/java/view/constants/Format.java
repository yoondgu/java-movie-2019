package view.constants;

import java.text.DecimalFormat;

public class Format {
    public static final DecimalFormat MONEY_KRW = new DecimalFormat("###,###원");

    public static final String MOVIE_INFO = "%d - %s, %s" + System.lineSeparator();
    public static final String SCHEDULE_INFO = "시작시간: %s 예약가능인원: %d" + System.lineSeparator();
    public static final String INPUT_MESSAGE_HEADER = "## %s" + System.lineSeparator();

    private Format() {
    }
}
