package racingcar.parser;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarNameParserTest {

    private CarNameParser carNameParser = new CarNameParser();

    @Test
    void parse_Normal_SuccessToParse() {
        // given
        String input = "pobi,woni,jun";
        List<String> expected = List.of("pobi", "woni", "jun");

        // when
        List<String> actual = carNameParser.parse(input);

        // then
        assertEquals(expected, actual);
    }
}