package cmblack.controller;

import cmblack.card.ICard;
import cmblack.category.ICategory;
import cmblack.player.IPlayer;
import cmblack.player.round.IRound;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class RoundController implements IRoundActions, IRoundController{
    private IRound round;

    public RoundController(IRound round){
        this.round = round;
    }

    @Override
    public void findCategoryFromPlayer() {

    }

    @Override
    public void findCardFromPlayer() {

    }

    @Override
    public void nextPlayerTurn(IPlayer player) {

    }

    @Override
    public void checkWin(IPlayer player) {

    }

    @Override
    public IRound getRound() {
        return null;
    }

    @Override
    public void selectedCategory(ICategory category) {

    }

    @Override
    public void selectedCard(ICard card) {

    }
}
