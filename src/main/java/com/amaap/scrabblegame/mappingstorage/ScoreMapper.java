package com.amaap.scrabblegame.mappingstorage;

import com.amaap.scrabblegame.mappingstorage.exceptions.InvalidCharException;

import java.util.HashMap;
import java.util.Map;

public class ScoreMapper {

    public static final Map<Character, Integer> letterScorer = new HashMap<>();

    static final Map<Integer, String> scoreMapping = new HashMap<>();

    static {
        scoreMapping.put(1, "EAIONRTLSU");
        scoreMapping.put(2, "DG");
        scoreMapping.put(3, "BCMP");
        scoreMapping.put(4, "FHVWY");
        scoreMapping.put(5, "K");
        scoreMapping.put(8, "JX");
        scoreMapping.put(10, "QZ");
    }

    public static Map<Integer, String> getScoreMapping() {
        return scoreMapping;
    }

    public void setMappingForLetters(char c, int multiplier) throws InvalidCharException {
        if (multiplier == 0) {
            throw new InvalidCharException("Invalid arguments passed");
        }


        letterScorer.put(c, multiplier);

    }


}
