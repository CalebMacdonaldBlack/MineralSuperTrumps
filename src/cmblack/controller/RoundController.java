package cmblack.controller;

import cmblack.card.ICard;
import cmblack.category.ICategory;
import cmblack.player.IPlayer;
import cmblack.player.round.*;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class RoundController implements IRoundActions{
    // TODO: 19/09/2016 Make final
    private IRound round;
    private final IRoundView roundView;

    public RoundController(IRound round, IRoundView roundView) {
        this.round = round;
        this.roundView = roundView;
    }

    @Override
    public void changeCategory(ICategory category) {
        this.round = round.setCurrentCategory(category).setRoundState(RoundState.CATEGORY_UPDATED);
        roundView.update(this.round);
    }

    @Override
    public void playACard(ICard card) {
        this.round = round.setCurrentCard(card).setRoundState(RoundState.PLAYER_PLAYED_CARD);
        roundView.update(this.round);
    }

    @Override
    public void removeAPlayer(IPlayer player) {
        round.getPlayerGroup().removePlayer(player);
        this.round = round.setRoundState(RoundState.PLAYER_REMOVED);
        roundView.update(this.round);
    }

    @Override
    public void nextPlayerTurn(IPlayer player) {
        round.getPlayerGroup().getNextPlayer(player).playCard(round.getCurrentCard(), round.getCurrentCategory(), this);
        this.round = round.setRoundState(RoundState.PLAYER_FINISHED_TURN);
        roundView.update(this.round);
    }

    @Override
    public void drawACard(IPlayer player) {
        player.giveCard(round.getDeck().takeCard());
        this.round.setRoundState(RoundState.PLAYER_DREW_CARD);
        roundView.update(this.round);
    }
}
