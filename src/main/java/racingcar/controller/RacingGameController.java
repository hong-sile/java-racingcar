package racingcar.controller;

import java.util.function.Consumer;
import java.util.function.Supplier;
import racingcar.model.RacingGame;
import racingcar.model.RacingGameImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingGame racingGame = new RacingGameImpl();

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
        repeat(racingGame::initialCars, InputView::inputCarNames);
    }

    private void initialTryCount() {
        repeat(racingGame::initialTryCount, InputView::inputTryCount);
    }

    private <T> void repeat(Consumer<T> initializer, Supplier<T> inputReader) {
        try {
            initializer.accept(inputReader.get());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            repeat(initializer, inputReader);
        }
    }
}
