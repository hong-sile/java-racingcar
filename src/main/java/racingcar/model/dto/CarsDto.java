package racingcar.model.dto;

import java.util.ArrayList;
import java.util.List;

public class CarsDto {
    private final List<CarDto> cars;

    public CarsDto(CarDto... cars) {
        this.cars = new ArrayList<>();
        for (CarDto car : cars) {
            this.cars.add(car);
        }
    }

    public List<CarDto> getCars() {
        return cars;
    }
}
