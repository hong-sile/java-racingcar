package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.generate());
        }
    }

    public CarsDto toDto() {
        List<CarDto> carDtos = cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
        return new CarsDto(carDtos);
    }
}
