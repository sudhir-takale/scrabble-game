package com.amaap.scrabblegame.domain;

import com.amaap.scrabblegame.domain.exceptions.InvalidStringException;
import com.amaap.scrabblegame.scorecalculator.ScoreCalculator;

public class Scrabble {


    private String word;
    private ScoreCalculator scoreCalculator;

    public Scrabble(String word, ScoreCalculator scoreCalculator) throws InvalidStringException {
        validateInput(word);
        this.word = word.trim().toUpperCase();
        this.scoreCalculator = scoreCalculator;
    }

    private static boolean validateWord(String inputString) {
        return inputString.matches(".*[\\d\\W].*");
    }

    public String getWord() {
        return word;
    }

    public void validateInput(String inputString) throws InvalidStringException {
        if (inputString.trim().isEmpty()) {
            throw new InvalidStringException(inputString + "Empty string is not allowed");
        } else if (validateWord(inputString)) {
            throw new InvalidStringException(inputString + " is an invalid string");
        }
    }

    public int calculateScore() {
        System.out.println(word);
        return scoreCalculator.calculateScore(word);
    }
}
