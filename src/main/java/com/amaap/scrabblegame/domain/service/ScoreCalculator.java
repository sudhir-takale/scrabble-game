package com.amaap.scrabblegame.domain.service;

import com.amaap.scrabblegame.cofig.LetterScoreManager;

import java.util.Map;

public class ScoreCalculator {
    private boolean isWordDouble = false;
    private boolean isWordTriple = false;

    public boolean isWordDouble() {
        return isWordDouble;
    }

    public void setWordDouble(boolean wordDouble) {
        isWordDouble = wordDouble;
    }

    public boolean isWordTriple() {
        return isWordTriple;
    }

    public void setWordTriple(boolean wordTriple) {
        isWordTriple = wordTriple;
    }

    public int calculateScore(String word) {
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            int letterScore = getScore(word.charAt(i));
            if (LetterScoreManager.letterScorer.containsKey(word.charAt(i))) {
                letterScore *= LetterScoreManager.letterScorer.get(word.charAt(i));
            }
            score += letterScore;
        }
        System.out.println(isWordDouble);
        if (isWordDouble) score *= 2;
        else if (isWordTriple) score *= 3;

        return score;
    }

    private int getScore(char c) {
        return LetterScoreManager.getScoreMapping().entrySet().stream()
                .filter(entry -> entry.getValue().contains(String.valueOf(c)))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
    }


}
