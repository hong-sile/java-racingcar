package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {
    Cars cars = new Cars(List.of("a", "b", "c"));

    /**
     * 나중에 합시다
     */
    @Test
    void moveCars_메소드는_랜덤으로_값을_뽑고_그_값으로_car의_move메소드를_호출한다() {

    }

    @Test
    void toDto_메소드는_Cars의_값으로_DTO를_생성해_반환한다() {
        List<CarDto> result = cars.toDto().getCars();
        List<CarDto> expected = List.of(new CarDto("a", 0), new CarDto("b", 0),
                new CarDto("c", 0));

        for (int i = 0; i < 3; i++) {
            Assertions.assertThat(result.get(i).getName()).isEqualTo(expected.get(i).getName());
            Assertions.assertThat(result.get(i).getPosition()).isEqualTo(expected.get(i).getPosition());
        }
    }

    @Test
    void getWinCars_메소드는_우승자들을_반환한다() {
        final MockedStatic<RandomNumberGenerator> mock = Mockito.mockStatic(RandomNumberGenerator.class);
        mock.when(() -> RandomNumberGenerator.generate())
                .thenReturn(5, List.of(4, 1).toArray());
        cars.moveCars();
        mock.close();

        CarsDto winCars = cars.getWinCars();

        Assertions.assertThat(winCars.getCars().size()).isEqualTo(2);
    }
}