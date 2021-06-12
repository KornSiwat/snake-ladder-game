package snakeladder.models;

import java.util.Vector;

public class PlayerManager {
    private Vector<Player> unfinishedPlayers;
    private int currentPlayerIndex;

    public PlayerManager() {
        this.unfinishedPlayers = new Vector<>();
        this.currentPlayerIndex = 0;
    }

    public void addPlayer(Player player) {
        this.unfinishedPlayers.add(player);
    }

    public Player getNextUnfinishedPlayer() {
        Player nextPlayer = this.unfinishedPlayers.get(this.currentPlayerIndex);

        ++this.currentPlayerIndex;

        return nextPlayer;
    }

    public boolean hasUnfinishedPlayer() {
        return this.unfinishedPlayers.size() != 0;
    }

    public void finish(Player player) {
        this.unfinishedPlayers.remove(player);

        --this.currentPlayerIndex;
    }
}
