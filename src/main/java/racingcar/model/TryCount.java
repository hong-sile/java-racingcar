package racingcar.model;

public class TryCount {
    private int tryCount;

    public TryCount(int tryCount) {
        validateCount(tryCount);
        this.tryCount = tryCount;
    }

    private void validateCount(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException("[ERROR]시도 횟수는 음수면 안 됩니다.");
        }
    }

    public boolean isPlayable() {
        return tryCount > 0;
    }

    public void decrease() {
        tryCount -= 1;
    }
}
