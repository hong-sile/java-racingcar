package racingcar.model;

import java.util.List;
import racingcar.dto.CarsDto;

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
        return null;
    }

    @Override
    public List<String> getWinners() {
        return null;
    }
}
