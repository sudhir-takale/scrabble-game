package com.amaap.scrabblegame;

import com.amaap.scrabblegame.exceptions.InvalidStringException;
import com.amaap.scrabblegame.scorecalculator.ScoreCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScrabbleTest {
    @Test
    void shouldThrowExceptionIfEmptyStringIsPassed() {
        // arrange & act & assert
        Assertions.assertThrows(InvalidStringException.class, () -> {
            new Scrabble(" ", new ScoreCalculator());
        });
    }

    @Test
    void shouldNotThrowExceptionForValidString() {
        // arrange & act & assert
        Assertions.assertDoesNotThrow(() -> {
            new Scrabble("SCRABBLE", new ScoreCalculator());
        });
    }

    @Test
    void shouldConvertInputToUppercase() throws InvalidStringException {
        // arrange
        Scrabble scrabble = new Scrabble("sudhir", new ScoreCalculator());

        // act
        String word = scrabble.getWord();

        // assert
        Assertions.assertEquals("SUDHIR", word);
    }


    @Test
    void shouldThrowExceptionIfStringContainsNumbersOrChars() {
        // arrange & act & assert
        Assertions.assertThrows(InvalidStringException.class, () -> {
            new Scrabble("Sudhir99", new ScoreCalculator());
        });
    }

    @Test
    void shouldThrowExceptionForSpecialCharacters() {
        // arrange & act & assert
        Assertions.assertThrows(InvalidStringException.class, () -> {
            new Scrabble("!@#$", new ScoreCalculator());
        });
    }

    @Test
    void shouldCalculateScoreCorrectly() throws InvalidStringException {
        // arrange
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        Scrabble scrabble = new Scrabble("SCRABBLE", scoreCalculator);

        // act
        int score = scrabble.calculateScore();

        // assert
        Assertions.assertEquals(14, score);
    }
}
