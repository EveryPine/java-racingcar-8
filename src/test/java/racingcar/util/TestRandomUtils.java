package racingcar.util;

public class TestRandomUtils implements RandomUtils {

    private final int testRandomNumber;

    public TestRandomUtils(int testRandomNumber) {
        this.testRandomNumber = testRandomNumber;
    }

    @Override
    public int getRandomInteger() {
        return testRandomNumber;
    }
}
