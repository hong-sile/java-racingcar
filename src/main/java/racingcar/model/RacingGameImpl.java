package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;

public class RacingGameImpl implements RacingGame {
    private Cars cars;
    private TryCount tryCount;

    @Override
    public void initialCars(List<String> carNames) {
        cars = new Cars(carNames);
    }

    @Override
    public void initialTryCount(int tryCount) {
        this.tryCount = new TryCount(tryCount);
    }

    @Override
    public void tryOneTime() {
        cars.moveCars();
        tryCount.decrease();
    }

    @Override
    public boolean isPlayable() {
        return tryCount.isPlayable();
    }

    @Override
    public CarsDto getTryResult() {
        return cars.toDto();
    }

    @Override
    public WinnersDto getWinners() {
        CarsDto winCars = cars.getWinCars();
        List<String> winnerNames = winCars.getCars().stream()
                .map(CarDto::getName)
                .collect(Collectors.toList());
        return new WinnersDto(winnerNames);
    }
}
