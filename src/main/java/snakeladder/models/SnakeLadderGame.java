package snakeladder.models;

public class SnakeLadderGame {
    private final Board board;
    private final Dice dice;
    private final PlayerManager playerManager;

    public SnakeLadderGame(Board board, Dice dice, PlayerManager playerManager) {
        this.board = board;
        this.dice = dice;
        this.playerManager = playerManager;
    }

    public void start() {
        this.startGameLoop();
    }

    private void startGameLoop() {
        while (!isGameEnded()) {
            Player player = getPlayerForCurrentTurn();

            int diceResult = rollDice();

            int moveCount = diceResult;
            movePlayer(player, moveCount);
        }
    }

    private Player getPlayerForCurrentTurn() {
        return this.playerManager.getNextUnfinishedPlayer();
    }

    private boolean isGameEnded() {
        return playerManager.hasUnfinishedPlayer();
    }

    private int rollDice() {
        promptEnter();

        return this.dice.roll();
    }

    private void promptEnter() {
        System.out.println("Press Enter key to continue...");

        try {
            System.in.read();
        }
        catch(Exception e) {}
    }

    private void movePlayer(Player player, int moveCount) {
        int newPosition = calculatePlayerNewPosition(player, moveCount);

        player.updatePosition(newPosition);

        updatePlayerStatus(player);
    }

    private int calculatePlayerNewPosition(Player player, int moveCount) {
        int newPosition = player.getPosition() + moveCount;

        try {
            Portal portal = this.board.getPortal(newPosition);

            newPosition = portal.getTargetPosition();
        }
        catch(Exception e) {}

        return newPosition;
    }

    private void updatePlayerStatus(Player player) {
        if (isPlayerReachedEndPosition(player)) {
            this.playerManager.finish(player);
        }
    }

    private boolean isPlayerReachedEndPosition(Player player) {
        return this.board.isPositionReachedEndPosition(player.getPosition());
    }
}

