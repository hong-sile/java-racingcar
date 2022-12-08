package racingcar.dto;

import java.util.List;

public class CarsDto {
    private final List<CarDto> cars;

    public CarsDto(List<CarDto> cars) {
        this.cars = cars;
    }

    public List<CarDto> getCars() {
        return cars;
    }
}
