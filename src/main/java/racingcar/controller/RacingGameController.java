package racingcar.controller;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private RacingGame racingGame;

    public void run() {
        initialCars();
        initialTryCount();
        gameStart();
        gameEnd();
    }

    private void gameEnd() {
        OutputView.printWinners(racingGame.getWinners());
    }

    private void gameStart() {
        while (racingGame.isPlayable()) {
            racingGame.tryOneTime();
            OutputView.printTryResult(racingGame.getTryResult());
        }
    }

    private void initialCars() {
        List<String> carNames = repeat(InputView::inputCarNames);
        repeat(racingGame::initialCars, carNames);
    }

    private void initialTryCount() {
        int tryCount = repeat(InputView::inputTryCount);
        repeat(racingGame::initialTryCount, tryCount);
    }

    private <T> void repeat(Consumer<T> inputReader, T value) {
        try {
            inputReader.accept(value);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            repeat(inputReader, value);
        }
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return repeat(inputReader);
        }
    }
}
