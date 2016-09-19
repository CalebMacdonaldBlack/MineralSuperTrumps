package cmblack.game;

import cmblack.card.EmptyCard;
import cmblack.category.ICategory;
import cmblack.controller.RoundController;
import cmblack.deck.IDeck;
import cmblack.player.IPlayer;
import cmblack.player.round.*;

import java.io.FileNotFoundException;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class Game implements IGame {
    private final IPlayerGroup playerGroup;
    private final IDeck deck;
    private final IRoundView roundView;

    public Game(IPlayerGroup playerGroup, IDeck deck, IRoundView roundView) {
        this.playerGroup = playerGroup;
        this.deck = deck;
        this.roundView = roundView;
    }

    @Override
    public void startGame() throws FileNotFoundException {
        ICategory startCategory = playerGroup.getAllPlayers()[0].chooseCategory();

        for(IPlayer player: playerGroup.getAllPlayers()){
            for(int count=1;count<=5;count++){
                player.giveCard(deck.takeCard());
            }
        }

        IRound round = new Round(playerGroup, new EmptyCard(), deck, startCategory, RoundState.START);
        RoundController roundController = new RoundController(round, this.roundView);
        playerGroup.getAllPlayers()[0].playCard(round.getCurrentCard(), round.getCurrentCategory(), roundController);
    }

    @Override
    public GameState getGameState() {
        return null;
    }
}
