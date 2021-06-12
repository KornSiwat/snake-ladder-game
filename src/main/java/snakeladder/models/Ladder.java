package snakeladder.models;

public class Ladder implements Portal {
    private final int startPosition;
    private final int targetPosition;

    public Ladder(int startPosition, int targetPosition) throws IllegalArgumentException {
        boolean isValidLadder = startPosition < targetPosition;

        if (!isValidLadder) {
            throw new IllegalArgumentException("Ladder's start location must be greater than target location");
        }

        this.startPosition = startPosition;
        this.targetPosition = targetPosition;
    }

    @Override
    public int getStartPosition() {
        return this.startPosition;
    }

    @Override
    public int getTargetPosition() {
        return this.targetPosition;
    }
}
