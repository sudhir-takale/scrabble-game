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


    public String getWord() {
        return word;
    }

    public void validateInput(String inputString) throws InvalidStringException {
        if (inputString.trim().isEmpty() || inputString.matches(".*[\\d\\W].*")) {
            throw new InvalidStringException(inputString + "Empty string is not allowed");
        }
    }

    public int calculateScore() {
        System.out.println(word);
        return scoreCalculator.calculateScore(word);
    }
}
