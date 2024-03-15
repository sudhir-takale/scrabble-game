package org.amaap.task;

import org.amaap.task.exceptions.InvalidStringException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


public class Scrabble {

    private String word;
    private Map<Integer, String> scoreMapping;

    public Scrabble(String inputString) throws InvalidStringException {
        if (inputString.trim().isEmpty()) {
            throw new InvalidStringException(inputString + "Empty string is not allowed");
        } else if (validateWord(inputString)) {
            throw new InvalidStringException(inputString + " is an invalid string");
        }
        this.word = inputString.trim().toUpperCase();
    }

    private void createScoreManager() {
        scoreMapping = new HashMap<>();
        scoreMapping.put(1, "EAIONRTLSU");
        scoreMapping.put(2, "DG");
        scoreMapping.put(3, "BCMP");
        scoreMapping.put(4, "FHVWY");
        scoreMapping.put(5, "K");
        scoreMapping.put(8, "JX");
        scoreMapping.put(10, "QZ");

    }


    private boolean validateWord(String inputString) {
        return Pattern.matches(".*[\\d\\W].*", inputString);
    }


    public int calculateScore() {
        int score = 0;
        createScoreManager();
        for (int i = 0; i < word.length(); i++) {
            score += getScore(word.charAt(i));
        }

        return score;
    }

    private int getScore(char c) {

        return scoreMapping.entrySet().stream()
                .filter(entry -> entry.getValue().contains(String.valueOf(c)))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);

    }
}


