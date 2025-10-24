package racingcar.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class StandardRandomUtils implements RandomUtils{

    private final int START_INTEGER = 0;
    private final int END_INTEGER = 9;

    @Override
    public int getRandomInteger() {
        return pickNumberInRange(START_INTEGER, END_INTEGER);
    }
}
