package snakeladder.models;

public class Dice {
    private final int minResult;
    private final int maxResult;

    public Dice(int faceCount) {
        this.minResult = 1;
        this.maxResult = faceCount;
    }

    public int roll() {
        return randomInteger(this.minResult, this.maxResult);
    }

    private int randomInteger(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
