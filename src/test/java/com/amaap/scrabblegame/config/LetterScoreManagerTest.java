package com.amaap.scrabblegame.config;

import com.amaap.scrabblegame.cofig.LetterScoreManager;
import com.amaap.scrabblegame.cofig.InvalidCharException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LetterScoreManagerTest {

    @Test
    void shouldBeAbleSetLetterMultiplier() throws InvalidCharException {
        // arrange
        LetterScoreManager scoreMapper = new LetterScoreManager();
        // act
        scoreMapper.setMappingForLetters('W', 2);
        // assert
        Assertions.assertEquals(1, LetterScoreManager.letterScorer.size());
        Assertions.assertEquals(2, LetterScoreManager.letterScorer.get('W'));
    }

    @Test
    void shouldAbleToThrowInvalidCharExceptionIfCharIsNotAlphabet() throws InvalidCharException {
        //arrange
        LetterScoreManager scoreMapper = new LetterScoreManager();
        // act & act
        Assertions.assertThrows(InvalidCharException.class, () -> scoreMapper.setMappingForLetters('W', 0));

    }

    @Test
    void shouldReturnSetMultiplierForLetter() throws InvalidCharException {
        // arrange
        LetterScoreManager scoreMapper = new LetterScoreManager();
        scoreMapper.setMappingForLetters('A', 3);
        // act
        int multiplier = LetterScoreManager.letterScorer.get('A');
        // assert
        Assertions.assertEquals(3, multiplier);
    }


}
