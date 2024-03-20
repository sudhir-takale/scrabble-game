package com.amaap.scrabblegame.scorecalculator;

import com.amaap.scrabblegame.mappingstorage.ScoreMapper;

import java.util.Map;

public class ScoreCalculator {
    private boolean isWordDouble = false;
    private boolean isWordTriple = false;


    public boolean isWordDouble() {
        return isWordDouble;
    }

    public boolean isWordTriple() {
        return isWordTriple;
    }

    public int calculateScore(String word) {
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            score += getScore(word.charAt(i));
        }
        return score;
    }

    private int getScore(char c) {
        return ScoreMapper.getScoreMapping().entrySet().stream()
                .filter(entry -> entry.getValue().contains(String.valueOf(c)))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
    }




}
