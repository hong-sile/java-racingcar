package racingcar.view;

import java.util.List;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;

public class OutputView {
    private static final String WINNERS_DELIMITER = ", ";

    public static void printTryResult(CarsDto carsDto) {
        TryResultTemplate template = new TryResultTemplate(carsDto);
        System.out.println(template.buildTemplate());
    }

    public static void printWinners(WinnersDto winnersDto) {
        List<String> winners = winnersDto.getWinners();
        String winnerTemplate = String.join(WINNERS_DELIMITER, winners);
        System.out.println("최종 우승자 : " + winnerTemplate);
    }
}
