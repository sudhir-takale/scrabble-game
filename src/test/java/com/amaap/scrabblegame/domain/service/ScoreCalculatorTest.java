package com.amaap.scrabblegame.domain.service;

import com.amaap.scrabblegame.cofig.InvalidCharException;
import com.amaap.scrabblegame.cofig.LetterScoreManager;
import com.amaap.scrabblegame.domain.exceptions.InvalidStringException;
import com.amaap.scrabblegame.domain.model.validator.Scrabble;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreCalculatorTest {
    ScoreCalculator scoreCalculator = new ScoreCalculator();

    @AfterEach
    void tearDown() {
        LetterScoreManager.letterScorer.clear();

    }

    @Test
    void shouldBeAbleReturnSumOfString() throws InvalidStringException {
        // arrange
        Scrabble scrabble = new Scrabble("IT");
        // act
        int score = scoreCalculator.calculateScore(scrabble.getWord());
        // assert
        Assertions.assertEquals(2, score);
    }

    @Test
    void shouldBeAbleReturnSumOfInputString() throws InvalidStringException {
        // arrange
        Scrabble scrabble = new Scrabble("SUDHIR");
        // act
        int score = scoreCalculator.calculateScore(scrabble.getWord());
        // assert
        Assertions.assertEquals(10, score);
    }


    @Test
    void shouldAbleToCalculateScoreWhenWordDouble() throws InvalidStringException {
        // arrange
        Scrabble scrabble = new Scrabble("Guardian");
        scoreCalculator.setWordDouble(true);
        // act
        int score = scoreCalculator.calculateScore(scrabble.getWord());
        // assert
        Assertions.assertEquals(20, score);
    }

    @Test
    void shouldBeAbleToCalculateScoreWhenWordTriple() throws InvalidStringException {
        // arrange
        Scrabble scrabble = new Scrabble("Guardian");
        scoreCalculator.setWordTriple(true);
        // act
        int score = scoreCalculator.calculateScore(scrabble.getWord());
        // assert
        Assertions.assertEquals(30, score);
    }

    @Test
    void shouldBeAbleReturnScoreOfWordWhenLettersAreDouble() throws InvalidStringException, InvalidCharException {
//        arrange
        LetterScoreManager scoreMapper = new LetterScoreManager();
        scoreMapper.setMappingForLetters('A', 2);
        Scrabble scrabble = new Scrabble("Guardian");
//        act
        int actualScore = scoreCalculator.calculateScore(scrabble.getWord());
//       assert
        Assertions.assertEquals(3, actualScore);

    }

    @Test
    void shouldBeAbleSetLetterMultiplierForLowercaseLetters() throws InvalidCharException {
        // arrange
        LetterScoreManager scoreMapper = new LetterScoreManager();
        // act
        scoreMapper.setMappingForLetters('w', 2);
        // assert
        Assertions.assertEquals(1, LetterScoreManager.letterScorer.size());
        Assertions.assertEquals(2, LetterScoreManager.letterScorer.get('W'));
    }

    @Test
    void shouldBeAbleReturnFalseIfWordDoubleOrTripleNotSet() throws InvalidStringException {
//        act
        Scrabble scrabble = new Scrabble("ar");
//        assert
        Assertions.assertFalse(scoreCalculator.isWordTriple());
        Assertions.assertFalse(scoreCalculator.isWordDouble());
    }

}
