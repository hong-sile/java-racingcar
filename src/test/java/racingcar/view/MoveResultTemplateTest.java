package racingcar.view;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

class MoveResultTemplateTest {

    @Test
    void buildTemplate_메소드는_CarsDto를_출력형식에_맞게_변환한다() {
        //given
        List<String> carNames = Arrays.asList("a", "b", "c");
        Cars cars = new Cars(carNames);
        StringBuilder expectedStringBuilder = new StringBuilder();
        for (String carName : carNames) {
            expectedStringBuilder.append(carName);
            expectedStringBuilder.append(" : \n");
        }
        //when
        MoveResultTemplate moveResultTemplate = new MoveResultTemplate(cars.toDto());
        //then
        Assertions.assertThat(moveResultTemplate.buildTemplate()).isEqualTo(expectedStringBuilder.toString());
    }
}