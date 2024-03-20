package com.amaap.scrabblegame.mappingstorage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoreMapperTest {

    @Test
    void shouldBeAbleSetLetterMultiplier() {
        // arrange
        ScoreMapper scoreMapper = new ScoreMapper();
        // act
        scoreMapper.setMappingForLetters('W', 2);
        // assert
        Assertions.assertEquals(1, ScoreMapper.letterScorer.size());
        Assertions.assertEquals(2, ScoreMapper.letterScorer.get('W'));
    }


    @Test
    void shouldReturnSetMultiplierForLetter() {
        // arrange
        ScoreMapper scoreMapper = new ScoreMapper();
        scoreMapper.setMappingForLetters('A', 3);
        // act
        int multiplier = ScoreMapper.letterScorer.get('A');
        // assert
        Assertions.assertEquals(3, multiplier);
    }


}
