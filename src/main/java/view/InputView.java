package view;

import java.util.Scanner;
import view.util.NumberParser;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println();
        System.out.println("## 예약할 영화를 선택하세요.");
        String line = scanner.nextLine();
        System.out.println();
        return NumberParser.parseInteger(line);
    }
}
