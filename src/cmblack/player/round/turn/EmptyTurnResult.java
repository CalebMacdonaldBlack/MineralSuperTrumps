package cmblack.player.round.turn;

import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;
import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class EmptyTurnResult implements IPlayerTurnResult {
    @Override
    public ICard getCurrentCard() {
        return new EmptyCard();
    }

    @Override
    public IPlayer getCurrentPlayer() {
        return new EmptyPlayer();
    }

    @Override
    public ICategory getCurrentCategory() {
        return new EmptyCategory();
    }

    @Override
    public boolean equals(IPlayerTurnResult playerTurnResult) {
        return getCurrentCard().equals(playerTurnResult.getCurrentCard())
            && getCurrentPlayer().equals(playerTurnResult.getCurrentPlayer())
            && getCurrentCategory().equals(playerTurnResult.getCurrentCategory());
    }
}
