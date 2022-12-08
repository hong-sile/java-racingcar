package racingcar.controller;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import racingcar.model.RacingGame;
import racingcar.view.InputView;

public class RacingGameController {
    private RacingGame racingGame;

    public void run() {

    }

    public void initialCars() {
        List<String> carNames = repeat(InputView::inputCarNames);
        repeat(racingGame::initialCars, carNames);
    }

    public void initialTryCount() {
        int tryCount = repeat(InputView::inputTryCount);
        repeat(racingGame::initialTryCount, tryCount);
    }

    public <T> void repeat(Consumer<T> inputReader, T value) {
        try {
            inputReader.accept(value);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            repeat(inputReader, value);
        }
    }

    public <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return repeat(inputReader);
        }
    }
}
