package com.amaap.scrabblegame.scorecalculator;

import com.amaap.scrabblegame.Scrabble;
import com.amaap.scrabblegame.exceptions.InvalidStringException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreCalculatorTest {
    @Test
    void shouldReturnSumOfString() throws InvalidStringException {
        // arrange
        Scrabble scrabble = new Scrabble("IT");
        // act
        int score = scrabble.calculateScore();
        // assert
        Assertions.assertEquals(2, score);
    }

    @Test
    void shouldReturnSumOfInputString() throws InvalidStringException {
        // arrange
        Scrabble scrabble = new Scrabble("SUDHIR");
        // act
        int score = scrabble.calculateScore();
        // assert
        Assertions.assertEquals(10, score);
    }

    @Test
    void shouldReturnSumOfInputString1() throws InvalidStringException {
        // arrange
        Scrabble scrabble = new Scrabble("Guardian");
        // act
        int score = scrabble.calculateScore();
        // assert
        Assertions.assertEquals(10, score);
    }

    @Test
    void shouldAbleToCalculateScoreWhenWordDouble() throws InvalidStringException {
        // Arrange
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        scoreCalculator.setWordDouble(true);
        Scrabble scrabble = new Scrabble("Guardian");

        // Act
        int score = scrabble.calculateScore();

        // Assert
        Assertions.assertEquals(20, score);
    }

}
