package org.amaap.task;

import org.amaap.task.exceptions.InvalidStringException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScrabbleTest {


    @Test
    void shouldReturnZeroIfEmptyStringIsPassed() throws InvalidStringException {

        Assertions.assertThrows(InvalidStringException.class, () -> {
            new Scrabble(" ");
        });

    }

    @Test
    void shouldReturnInvalidStringExceptionIfStringContainsNumbersOrChars() {
        Assertions.assertThrows(InvalidStringException.class, () -> {
            new Scrabble("Sudhir99");
        });
    }





}
