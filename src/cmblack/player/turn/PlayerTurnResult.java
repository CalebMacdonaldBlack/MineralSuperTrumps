package cmblack.player.turn;

import cmblack.card.ICard;
import cmblack.category.ICategory;
import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class PlayerTurnResult implements IPlayerTurnResult {

    private final ICard currentCard;
    private final IPlayer currentPlayer;
    private final ICategory currentCategory;

    public PlayerTurnResult(ICard currentCard, IPlayer currentPlayer, ICategory currentCategory) {
        this.currentCard = currentCard;
        this.currentPlayer = currentPlayer;
        this.currentCategory = currentCategory;
    }

    @Override
    public ICard getCurrentCard() {
        return this.currentCard;
    }

    @Override
    public IPlayer getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ICategory getCurrentCategory() {
        return this.currentCategory;
    }
}
