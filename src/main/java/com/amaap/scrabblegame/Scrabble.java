package com.amaap.scrabblegame;

import com.amaap.scrabblegame.exceptions.InvalidStringException;
import com.amaap.scrabblegame.scorecalculator.ScoreCalculator;

public class Scrabble {

    private String word;

    public Scrabble(String word) throws InvalidStringException {
        validateInput(word);
        this.word = word.trim().toUpperCase();
    }

    public void validateInput(String inputString) throws InvalidStringException {
        if (inputString.trim().isEmpty()) {
            throw new InvalidStringException(inputString + "Empty string is not allowed");
        } else if (validateWord(inputString)) {
            throw new InvalidStringException(inputString + " is an invalid string");
        }
    }

    private static boolean validateWord(String inputString) {
        return inputString.matches(".*[\\d\\W].*");
    }

    public int calculateScore() {
        return new ScoreCalculator().calculateScore(word);
    }
}
