package view;

import dto.PlayScheduleDTO;
import java.util.List;
import java.util.Scanner;
import view.command.ActionCommand;
import view.command.PayTypeCommand;
import view.constants.Format;
import view.constants.InputMessage;
import view.util.NumberParser;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println();
        printInputHeader(InputMessage.SELECT_MOVIE_ID);
        String line = scanner.nextLine();
        return NumberParser.parseInteger(line);
    }

    public static int inputPlayScheduleIndex(List<PlayScheduleDTO> playSchedules) {
        System.out.println();
        printInputHeader(InputMessage.SELECT_SCHEDULE_INDEX);
        showPlaySchedules(playSchedules);
        String line = scanner.nextLine();
        return NumberParser.parseNaturalNumber(line);
    }

    private static void showPlaySchedules(List<PlayScheduleDTO> playSchedules) {
        playSchedules.forEach(playSchedule -> System.out.printf(Format.SCHEDULE_INFO, playSchedule.getStartDateTime(),
                playSchedule.getCapacity()));
    }

    public static int inputBookingQuantity() {
        System.out.println();
        printInputHeader(InputMessage.INPUT_BOOKING_QUANTITY);
        String line = scanner.nextLine();
        return NumberParser.parseNaturalNumber(line);
    }

    // TODO Command 인터페이스 검토
    public static boolean inputActionCommand() {
        System.out.println();
        printInputHeader(InputMessage.SELECT_TO_GO_PAY_OR_NOT);
        String line = scanner.nextLine();
        ActionCommand actionCommand = ActionCommand.find(line);
        return actionCommand.isYes();
    }

    public static PayTypeCommand inputPayTypeCommand() {
        System.out.println();
        printInputHeader(InputMessage.SELECT_TO_GO_PAY_OR_NOT);
        String line = scanner.nextLine();
        return PayTypeCommand.find(line);
    }

    public static int inputPointAmount() {
        System.out.println();
        printInputHeader(InputMessage.INPUT_POINT_AMOUNT);
        String line = scanner.nextLine();
        return NumberParser.parseDigit(line);
    }

    private static void printInputHeader(String message) {
        System.out.printf(Format.INPUT_MESSAGE_HEADER, message);
    }
}
