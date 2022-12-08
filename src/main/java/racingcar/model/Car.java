package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MOVE_CUTLINE_VALUE = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름의 길이는 5를 넘어야한다.");
        }
    }

    public void moveCar() {
        //이 랜덤값 뽑는 것을 Car 밖으로 빼야할 것 같음. 추후에 리팩토링
        if (Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE) > MOVE_CUTLINE_VALUE) {
            position += 1;
        }
    }
}
