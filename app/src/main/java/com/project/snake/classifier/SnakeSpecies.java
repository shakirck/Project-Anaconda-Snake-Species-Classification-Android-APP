package com.project.snake.classifier;


import java.io.Serializable;


public class SnakeSpecies implements Serializable, Comparable<SnakeSpecies> {

    private String snakeType;
    private String probability;

    public void  setSnakenType(String snakeType) {
        this.snakeType = snakeType;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getSnakenType() {
        return snakeType;
    }

    public String getProbability() {
        return probability;
    }

    public SnakeSpecies() {
        this.snakeType = snakeType;
        this.probability = probability;
    }

    @Override
    public int compareTo(SnakeSpecies s) {
        return Float.valueOf(this.getProbability()).compareTo(Float.valueOf(s.getProbability()));
    }
}
