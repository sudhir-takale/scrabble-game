package com.amaap.scrabblegame.domain.model.validator;

import com.amaap.scrabblegame.domain.exceptions.InvalidStringException;

public class Scrabble {

    private String word;

    public Scrabble(String word) throws InvalidStringException {
        if (!InputValidator.validateInput(word)) {
            throw new InvalidStringException(word + "invalid input passed");

        } else {
            this.word = word.trim().toUpperCase();
        }
    }

    public String getWord() {
        return word;
    }
}
