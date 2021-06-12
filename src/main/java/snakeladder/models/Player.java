package snakeladder.models;

public class Player {
    final static int DEFAULT_POSITION = 1;

    private final String name;

    private int position;

    public Player(String name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void updatePosition(int position) {
        this.position = position;
    }
}
