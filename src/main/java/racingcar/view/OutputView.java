package racingcar.view;

import racingcar.dto.CarsDto;

public class OutputView {
    public static void printTryResult(CarsDto carsDto) {
        MoveResultTemplate template = new MoveResultTemplate(carsDto);
        System.out.println(template.buildTemplate());
    }
}
