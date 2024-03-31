package com.amaap.scrabblegame.domain;

import com.amaap.scrabblegame.domain.exceptions.InvalidStringException;
import com.amaap.scrabblegame.domain.model.validator.Scrabble;
import com.amaap.scrabblegame.domain.service.ScoreCalculator;
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
    void shouldNotThrowExceptionForValidString() {
        // arrange & act & assert
        Assertions.assertDoesNotThrow(() -> {
            new Scrabble("SCRABBLE");
        });
    }

    @Test
    void shouldConvertInputToUppercase() throws InvalidStringException {
        // arrange
        Scrabble scrabble = new Scrabble("sudhir");
        // act
        String word = scrabble.getWord();
        // assert
        Assertions.assertEquals("SUDHIR", word);
    }


    @Test
    void shouldThrowExceptionIfStringContainsNumbersOrChars() {
        // arrange & act & assert
        Assertions.assertThrows(InvalidStringException.class, () -> {
            new Scrabble("Sudhir99");
        });
    }

    @Test
    void shouldThrowExceptionForSpecialCharacters() {
        // arrange & act & assert
        Assertions.assertThrows(InvalidStringException.class, () -> {
            new Scrabble("!@#$");
        });
    }

    @Test
    void shouldCalculateScoreCorrectly() throws InvalidStringException {
        // arrange
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        Scrabble scrabble = new Scrabble("SCRABBLE");
        // act
        int score = scoreCalculator.calculateScore(scrabble.getWord());
        // assert
        Assertions.assertEquals(14, score);
    }
}
