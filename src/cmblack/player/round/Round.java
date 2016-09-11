package cmblack.player.round;

import cmblack.deck.IDeck;
import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class Round implements IRound {

    private final IDeck deck;
    private final IPlayer[] players;
    private final IPlayer winnerOfLastRound;

    public Round(IDeck deck, IPlayer[] players, IPlayer winnerOfLastRound) {
        this.deck = deck;
        this.players = players;
        this.winnerOfLastRound = winnerOfLastRound;
    }

    @Override
    public IRoundResult haveRound() {
        return null;
    }
}
