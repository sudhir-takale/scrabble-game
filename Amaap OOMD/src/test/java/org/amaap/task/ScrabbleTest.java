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

    @Test
    void shouldAbleToReturnSumOfString() throws InvalidStringException {
        Scrabble scrabble = new Scrabble("IT");
        int score = scrabble.calculateScore();
        Assertions.assertEquals(2, score);
    }
    @Test
    void shouldBeAbleToReturnSumOfInputString() throws InvalidStringException {
        Scrabble scrabble = new Scrabble("SUDHIR");
        int score = scrabble.calculateScore();
        Assertions.assertEquals(10, score);
    }
 @Test
    void shouldBeAbleToReturnSumOfInputString1() throws InvalidStringException {

        Scrabble scrabble = new Scrabble("Guardian");
        int score = scrabble.calculateScore();
        Assertions.assertEquals(10, score);
    }
}
