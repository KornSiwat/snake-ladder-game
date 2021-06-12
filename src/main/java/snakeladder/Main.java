package snakeladder;

import snakeladder.models.*;

public class Main {
    public static void main(String[] args) {
        SnakeLadderGame game = createSnakeLadderGame();

        game.start();
    }

    public static SnakeLadderGame createSnakeLadderGame() {
        Board board = new Board(36);

        board.addLadder(new Ladder(2,8));
        board.addLadder(new Ladder(4,9));
        board.addLadder(new Ladder(5,18));


        board.addSnake(new Snake(12, 1));
        board.addSnake(new Snake(24, 9));
        board.addSnake(new Snake(28, 22));

        Dice dice = new Dice(6);

        PlayerManager playerManager = new PlayerManager();

        playerManager.addPlayer(new Player("Siwat"));

        SnakeLadderGame game = new SnakeLadderGame(board, dice, playerManager);

        return game;
    }
}
