package com.amaap.scrabblegame.mappingstorage;

import com.amaap.scrabblegame.mappingstorage.exceptions.InvalidCharException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoreMapperTest {

    @Test
    void shouldBeAbleSetLetterMultiplier() throws InvalidCharException {
        // arrange
        ScoreMapper scoreMapper = new ScoreMapper();
        // act
        scoreMapper.setMappingForLetters('W', 2);
        // assert
        Assertions.assertEquals(1, ScoreMapper.letterScorer.size());
        Assertions.assertEquals(2, ScoreMapper.letterScorer.get('W'));
    }

    @Test
    void shouldAbleToThrowInvalidCharExceptionIfCharIsNotAlphabet() throws InvalidCharException {
        //arrange
        ScoreMapper scoreMapper = new ScoreMapper();
        // act
        // assert
        Assertions.assertThrows(InvalidCharException.class, () -> scoreMapper.setMappingForLetters('W', 0));

    }


    @Test
    void shouldReturnSetMultiplierForLetter() throws InvalidCharException {
        // arrange
        ScoreMapper scoreMapper = new ScoreMapper();
        scoreMapper.setMappingForLetters('A', 3);
        // act
        int multiplier = ScoreMapper.letterScorer.get('A');
        // assert
        Assertions.assertEquals(3, multiplier);
    }


}
