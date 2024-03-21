package com.amaap.scrabblegame.scorecalculator;

import com.amaap.scrabblegame.Scrabble;
import com.amaap.scrabblegame.exceptions.InvalidStringException;
import com.amaap.scrabblegame.mappingstorage.ScoreMapper;
import com.amaap.scrabblegame.mappingstorage.exceptions.InvalidCharException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreCalculatorTest {
    @Test
    void shouldReturnSumOfString() throws InvalidStringException {
        // arrange
        Scrabble scrabble = new Scrabble("IT", new ScoreCalculator());
        // act
        int score = scrabble.calculateScore();
        // assert
        Assertions.assertEquals(2, score);
    }

    @Test
    void shouldReturnSumOfInputString() throws InvalidStringException {
        // arrange
        Scrabble scrabble = new Scrabble("SUDHIR", new ScoreCalculator());
        // act
        int score = scrabble.calculateScore();
        // assert
        Assertions.assertEquals(10, score);
    }

    @Test
    void shouldReturnSumOfInputString1() throws InvalidStringException {
        // arrange
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        Scrabble scrabble = new Scrabble("Guardian", scoreCalculator);
        // act
        int score = scrabble.calculateScore();
        // assert
        Assertions.assertEquals(10, score);
    }

    @Test
    void shouldAbleToCalculateScoreWhenWordDouble() throws InvalidStringException {
        // Arrange
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        Scrabble scrabble = new Scrabble("Guardian", scoreCalculator);
        scoreCalculator.setWordDouble(true);

        // Act
        int score = scrabble.calculateScore();

        // Assert
        Assertions.assertEquals(20, score);
    }

    @Test
    void shouldReturnScoreOfWordWhenLettersAreDouble() throws InvalidStringException, InvalidCharException {
//        Arrange
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        Scrabble scrabble = new Scrabble("ar", scoreCalculator);
        ScoreMapper scoreMapper = new ScoreMapper();
        scoreMapper.setMappingForLetters('A', 2);
//        act
        int actualScore = scrabble.calculateScore();
//       assert
        Assertions.assertEquals(3, actualScore);

    }


}
