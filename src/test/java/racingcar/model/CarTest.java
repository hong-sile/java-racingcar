package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;

class CarTest {

    @Test
    void move_메소드는_매개변수의_값이_4이상일_때_position을_하나_증가시킨다() {
        //given
        Car car = new Car("test");
        //when
        car.move(4);
        //then
        Assertions.assertThat(car).extracting("position")
                .isEqualTo(1);
    }

    @Test
    void toDto_메소드는_CarDto를_반환한다() {
        //given
        String carName = "car";
        Car car = new Car(carName);
        //when
        CarDto carDto = car.toDto();
        //then
        Assertions.assertThat(car).extracting("name")
                .isEqualTo(carDto.getName());
        Assertions.assertThat(car).extracting("position")
                .isEqualTo(carDto.getPosition());
    }

    @Test
    void maxPosition_메소드는_매개변수와_position을_비교해_큰_값을_반환한다() {
        Car car = new Car("car");
        car.move(4);
        car.move(4);

        Assertions.assertThat(car.maxPosition(1)).isEqualTo(2);
        Assertions.assertThat(car.maxPosition(5)).isEqualTo(5);
    }

    @Test
    void isEqualPosition_메소드는_매개변수와_position이_일치하는지_확인한다() {
        Car car = new Car("car");
        car.move(4);
        car.move(4);

        Assertions.assertThat(car.isEqualPosition(1)).isFalse();
        Assertions.assertThat(car.isEqualPosition(2)).isTrue();
    }
}