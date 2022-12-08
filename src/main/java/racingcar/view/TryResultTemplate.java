package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class TryResultTemplate {
    private static final String COLON = " : ";
    private static final String PROGRESS_MARK = "-";
    private static final String LINE_SEPARATOR = "\n";
    private final StringBuilder builder = new StringBuilder();

    public TryResultTemplate(CarsDto carsDto) {
        for (CarDto carDto : carsDto.getCars()) {
            addCarProgress(carDto);
        }
    }

    private void addCarProgress(CarDto carDto) {
        builder.append(carDto.getName());
        builder.append(COLON);
        builder.append(PROGRESS_MARK.repeat(carDto.getPosition()));
        builder.append(LINE_SEPARATOR);
    }

    public String buildTemplate() {
        return builder.toString();
    }
}
