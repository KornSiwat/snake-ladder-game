package snakeladder.models;

public class Snake implements Portal {
    private final int startPosition;
    private final int targetPosition;

    public Snake(int startPosition, int targetPosition) throws IllegalArgumentException {
        boolean isValidSnake = startPosition > targetPosition;

        if (!isValidSnake) {
            throw new IllegalArgumentException("Snake's start location must be greater than target location");
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
