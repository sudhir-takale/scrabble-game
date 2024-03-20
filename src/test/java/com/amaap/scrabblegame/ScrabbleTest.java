package com.amaap.scrabblegame;

import com.amaap.scrabblegame.exceptions.InvalidStringException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScrabbleTest {
    @Test
    void shouldThrowExceptionIfEmptyStringIsPassed() {
        // arrange & act & assert
        Assertions.assertThrows(InvalidStringException.class, () -> {
            new Scrabble(" ");
        });
    }

    @Test
    void shouldThrowExceptionIfStringContainsNumbersOrChars() {
        // arrange & act & assert
        Assertions.assertThrows(InvalidStringException.class, () -> {
            new Scrabble("Sudhir99");
        });
    }
}
