package org.amaap.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScrabbleTest {

    @Test
    void shouldReturnZeroIfEmptyStringIsPassed() {

        Scrabble scrabble = new Scrabble("");

        int result = scrabble.calculateResult();

        Assertions.assertEquals(0, result);


    }


}
