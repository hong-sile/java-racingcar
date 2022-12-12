package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingGameImplTest {
    RacingGame racingGame;

    @BeforeEach
    void initialRacingGameObject() {
        racingGame = new RacingGameImpl();
    }

    @Test
    void initialCars_메소드는_자동차_이름들을_받아_Car객체를_생성한다() {
        List<String> carNames = List.of("car1", "car2");
        racingGame.initialCars(carNames);

        Assertions.assertThat(racingGame).extracting("cars").isNotNull();
    }

    @Test
    void initialTryCount_메소드는_시도횟수를_받아_TryCount객체를_생성한다() {
        racingGame.initialTryCount(10);

        Assertions.assertThat(racingGame).extracting("tryCount").isNotNull();
    }

    @Test
    void tryOneTime_메소드는_자동차들을_한번_이동시키고_시도횟수를_1감소한다() {
        racingGame.initialCars(List.of("car1"));
        racingGame.initialTryCount(1);
        racingGame.tryOneTime();

        Assertions.assertThat(racingGame.isPlayable()).isFalse();
    }

    @Test
    void isPlayable_메소드는_게임의_진행가능여부를_반환한다() {
        racingGame.initialCars(List.of("car1"));
        racingGame.initialTryCount(1);

        Assertions.assertThat(racingGame.isPlayable()).isTrue();

        racingGame.initialTryCount(0);

        Assertions.assertThat(racingGame.isPlayable()).isFalse();
    }

    @Test
    void getTryResult_메소드는_게임상태를_DTO로_반환한다() {
        final MockedStatic<RandomNumberGenerator> mock = Mockito.mockStatic(RandomNumberGenerator.class);
        mock.when(() -> RandomNumberGenerator.generate()).thenReturn(4);
        racingGame.initialCars(List.of("car1"));
        racingGame.initialTryCount(1);
        racingGame.tryOneTime();
        mock.close();

        CarsDto result = racingGame.getTryResult();
        Assertions.assertThat(result.getCars().get(0).getPosition())
                .isEqualTo(1);
        Assertions.assertThat(result.getCars().get(0).getName())
                .isEqualTo("car1");
    }

    @Test
    void getWinners_메소드는_게임에서_승자를_구한다() {
        final MockedStatic<RandomNumberGenerator> mock = Mockito.mockStatic(RandomNumberGenerator.class);
        mock.when(() -> RandomNumberGenerator.generate()).thenReturn(4);
        racingGame.initialCars(List.of("car1"));
        racingGame.initialTryCount(1);
        mock.close();

        WinnersDto winners = racingGame.getWinners();

        Assertions.assertThat(winners.getWinners().get(0))
                .isEqualTo("car1");
    }
}