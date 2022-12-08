package racingcar.model;

import java.util.List;
import racingcar.dto.CarsDto;

public interface RacingGame {
    public void initialCars(List<String> carNames);

    public void initialTryCount(int tryCount);

    public void tryOneTime();

    public boolean isPlayable();

    public CarsDto getTryResult();

    public List<String> getWinners();
}
