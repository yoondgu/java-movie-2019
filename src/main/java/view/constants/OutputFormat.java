package view.constants;

import java.text.DecimalFormat;

public class OutputFormat {
    public static final String MOVIE_INFO = "%d - %s, %s" + System.lineSeparator();
    public static final DecimalFormat MONEY_KRW = new DecimalFormat("###,###원");

    private OutputFormat() {
    }
}
