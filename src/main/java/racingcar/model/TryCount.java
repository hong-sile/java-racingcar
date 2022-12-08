package racingcar.model;

public class TryCount {
    private int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public boolean isPlayable() {
        return tryCount > 0;
    }

    public void decrease() {
        tryCount -= 1;
    }
}
