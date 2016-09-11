package cmblack.player.round;

import cmblack.deck.IDeck;
import cmblack.player.IPlayer;

import java.io.FileNotFoundException;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class RoundResult implements IRoundResult {
    private final IPlayer[] players, playersWhoWon;
    private final IDeck deck;
    private final IPlayer roundWinningPlayer;

    public RoundResult(IPlayer[] players, IPlayer[] playersWhoWon, IDeck deck, IPlayer roundWinningPlayer) {
        this.players = players;
        this.playersWhoWon = playersWhoWon;
        this.deck = deck;
        this.roundWinningPlayer = roundWinningPlayer;
    }

    @Override
    public IPlayer[] players() {
        return new IPlayer[0];
    }

    @Override
    public IDeck deck() throws FileNotFoundException {
        return null;
    }

    @Override
    public IPlayer roundWinningPlayer() {
        return null;
    }

    @Override
    public IPlayer[] playersWhoWon() {
        return new IPlayer[0];
    }
}
