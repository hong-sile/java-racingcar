package racingcar.view;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputViewTest {

    @ParameterizedTest(name = "입력값이 {0}일 때")
    @ValueSource(strings = {"q", ",", ";", " ", "12k"})
    void inputTryCount_메소드는_숫자형식이_아닌_값을_입력받으면_IllegalArgumentException을_던진다(String input) {
        ByteArrayInputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        Assertions.assertThatThrownBy(InputView::inputTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }
}