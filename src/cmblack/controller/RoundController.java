package cmblack.controller;

import cmblack.card.ICard;
import cmblack.category.ICategory;
import cmblack.game.IGameActions;
import cmblack.player.IPlayer;
import cmblack.player.round.*;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class RoundController implements IRoundActions{
    // TODO: 19/09/2016 Make final and unit test whole controller
    private IRound round;
    private final IRoundView roundView;
    private final IGameActions gameActions;

    public RoundController(IRound round, IRoundView roundView, IGameActions gameActions) {
        this.round = round;
        this.roundView = roundView;
        this.gameActions = gameActions;
    }

    @Override
    public void changeCategory(ICategory category) {
        round = round.setCurrentCategory(category).setRoundState(RoundState.CATEGORY_UPDATED);
        roundView.update(this.round);
    }

    @Override
    public void playACard(ICard card) {
        round = round.setCurrentCard(card).setRoundState(RoundState.PLAYER_PLAYED_CARD);
        roundView.update(round);
    }

    @Override
    public void removeAPlayer(IPlayer player) {
        round = round.setPlayerGroup(round.getPlayerGroup().removePlayerFromRound(player));
        round = round.setRoundState(RoundState.PLAYER_REMOVED);
        roundView.update(round);
    }

    @Override
    public void drawACard(IPlayer player) {
        player.giveCard(round.getDeck().takeCard());
        round = round.setRoundState(RoundState.PLAYER_DREW_CARD);
        roundView.update(round);
    }

    // TODO: 19/09/2016 remove player parameter 
    @Override
    public void turnEnded(IPlayer player) {
        round = round.setRoundState(RoundState.PLAYER_FINISHED_TURN);
        roundView.update(round);
        if(round.getPlayerGroup().getPlayersStillIn().length > 1){
            round = new Round(round.getPlayerGroup().nextPlayerTurn(), round.getCurrentCard(), round.getDeck(), round.getCurrentCategory(), round.getRoundState());
            round.getPlayerGroup().getCurrentPlayer().playCard(round.getCurrentCard(), round.getCurrentCategory(), this);
        } else {
            round = round.setRoundState(RoundState.ROUND_OVER);
            roundView.update(round);
            gameActions.RoundFinished(new RoundResult(round.getPlayerGroup().getPlayersStillIn()[0], round.getPlayerGroup().getAllPlayers()));
        }
    }

    @Override
    public void removePlayerFromGame(IPlayer player) {
        round = round.setPlayerGroup(round.getPlayerGroup().removePlayerFromGame(player));
        gameActions.playerRemovedFromGame(player);
    }
}
