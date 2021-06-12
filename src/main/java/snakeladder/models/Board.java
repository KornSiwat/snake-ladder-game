package snakeladder.models;

import java.util.HashMap;

public class Board {
    private final int size;
    private final HashMap<Integer, Portal> portals;

    public Board(int size) {
        this.size = size;
        this.portals = new HashMap<>();
    }

    public void addSnake(Snake snake) {
        addPortal(snake);
    }

    public void addLadder(Ladder ladder) {
        addPortal(ladder);
    }

    public Portal getPortal(int position) {
        return this.portals.get(position);
    }

    public boolean isPositionReachedEndPosition(int position) {
        int endPosition = this.size;

        return position >= endPosition;
    }

    private void addPortal(Portal portal) throws IllegalArgumentException {
        validatePortal(portal);

        this.portals.put(portal.getStartPosition(), portal);
    }

    private void validatePortal(Portal portal) throws IllegalArgumentException {
        if (!isPortalPositionValid(portal)) {
            throw new IllegalArgumentException("Invalid Portal Position");
        }

        boolean isPortalAlreadyExist = hasPortal(portal.getStartPosition());
        if (isPortalAlreadyExist) {
            throw new IllegalArgumentException("Portal already exist");
        }

        boolean isPortalChaining = hasPortal(portal.getTargetPosition());
        if (isPortalChaining) {
            throw new IllegalArgumentException("Portal Chaining is not allowed");
        }
    }

    private boolean hasPortal(int position) {
        return portals.containsKey(position);
    }

    private boolean isPortalPositionValid(Portal portal) {
        boolean isStartPositionInBoard = isPositionInBoard(portal.getStartPosition());
        boolean isTargetPositionInBoard = isPositionInBoard(portal.getTargetPosition());

        return isStartPositionInBoard && isTargetPositionInBoard;
    }

    private boolean isPositionInBoard(int position) {
        int endPosition = this.size;
        boolean isPositionGreaterOrEqualToStartPosition = position >= 1;
        boolean isPositionNotExceedEndPosition = position <= endPosition;

        return  isPositionGreaterOrEqualToStartPosition && isPositionNotExceedEndPosition;
    }
}
