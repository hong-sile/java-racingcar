package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class MoveResultTemplate {
    private static final String COLON = " : ";
    private static final String PROGRESS_MARK = "-";
    private static final String LINE_SEPARATOR = "\n";
    private final StringBuilder builder = new StringBuilder();

    public MoveResultTemplate(CarsDto carsDto) {
        for (CarDto carDto : carsDto.getCars()) {
            addCarProgress(carDto);
        }
    }

    private void addCarProgress(CarDto carDto) {
        builder.append(carDto.getName());
        builder.append(COLON);
        for (int i = 0; i < carDto.getPosition(); i++) {
            builder.append(PROGRESS_MARK);
        }
        builder.append(LINE_SEPARATOR);
    }

    public String buildTemplate() {
        return builder.toString();
    }
}
