package cmblack.player;

import cmblack.player.playerhand.IPlayerHand;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */

public class BotPlayer implements IPlayer {

    private final String name;
    private final IPlayerHand playerHand;

    public BotPlayer(String name, IPlayerHand playerHand) {
        this.name = name;
        this.playerHand = playerHand;
    }

    @Override
    public IPlayerHand getPlayerHand() {
        return playerHand;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(IPlayer player) {
        return name.equals(player.getName());
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.BOT;
    }
}
