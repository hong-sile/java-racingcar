package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";

    public static List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return Arrays.stream(input.split(DELIMITER)).collect(Collectors.toList());
    }

    public static int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = inputIntValue();
        if (tryCount < 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 0이상 이어야 합니다.");
        }
        return tryCount;
    }

    private static int inputIntValue() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }
}
