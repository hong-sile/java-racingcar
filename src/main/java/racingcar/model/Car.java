package racingcar.model;

import racingcar.dto.CarDto;

public class Car {
    private static final int MOVE_CUTLINE_VALUE = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름의 길이는 5를 넘으면 안된다.");
        }
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_CUTLINE_VALUE) {
            position += 1;
        }
    }

    public CarDto toDto() {
        return new CarDto(name, position);
    }

    public int maxPosition(int position) {
        return Math.max(this.position, position);
    }

    public boolean isEqualPosition(int position) {
        return position == this.position;
    }
}
