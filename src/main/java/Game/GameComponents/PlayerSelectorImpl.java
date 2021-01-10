package Game.GameComponents;

import java.util.List;

public class PlayerSelectorImpl implements PlayerSelector{

    int playerIndex = 0;
    List<Player> players;

    public PlayerSelectorImpl(List<Player> players) {
        this.players = players;
    }

    @Override
    public Player getNextPlayer() {
        int index = playerIndex/players.size();
        playerIndex = index+1;
        return players.get(playerIndex);
    }
}
