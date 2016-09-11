package cmblack.player;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;

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
