package racingcar.parser;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {

    private final String DELIMITER = ",";

    public List<String> parse(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }
}
