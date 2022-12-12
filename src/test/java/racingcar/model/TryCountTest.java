package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TryCountTest {

    @ParameterizedTest(name = "시도횟수가 {0}인 경우")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, Integer.MAX_VALUE})
    void isPlayable_메소드는_시도횟수가_0보다_큰지_확인한다_count가_0보다_큰_경우(int count) {
        TryCount tryCount = new TryCount(count);

        Assertions.assertThat(tryCount.isPlayable()).isTrue();
    }

    @Test
    void isPlayable_메소드는_시도횟수가_0보다_큰지_확인한다_count가_0인경우() {
        int count = 0;
        TryCount tryCount = new TryCount(count);

        Assertions.assertThat(tryCount.isPlayable()).isFalse();
    }

    @Test
    void decrease_메소드는_count를_하나_감소시킨다() {
        //given
        int count = 1;
        TryCount tryCount = new TryCount(count);
        //when
        tryCount.decrease();
        //then
        Assertions.assertThat(tryCount.isPlayable())
                .isFalse();
    }
}