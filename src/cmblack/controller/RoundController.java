package cmblack.controller;

import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.category.ICategory;
import cmblack.player.IPlayer;
import cmblack.player.round.IRound;
import cmblack.player.round.Round;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class RoundController implements IRoundActions{
    private IRound round;

    public RoundController(IRound round) {
        this.round = round;
    }

    @Override
    public void changeCategory(ICategory category) {
        this.round = round.setCurrentCategory(category);
    }

    @Override
    public void playACard(ICard card) {
        this.round = round.setCurrentCard(card);
    }

    @Override
    public void removeAPlayer(IPlayer player) {
        round.getPlayerGroup().removePlayer(player);
    }

    @Override
    public void nextPlayerTurn(IPlayer player) {
        round.getPlayerGroup().getNextPlayer(player).playCard(round.getCurrentCard(), round.getCurrentCategory(), this);
    }
}
