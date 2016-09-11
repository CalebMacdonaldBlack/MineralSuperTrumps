package cmblack.player;

import cmblack.card.ICard;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class PlayerTurn implements IPlayerTurn {

    private final ICard currentCard;
    private final IPlayer currentPlayer;
    private final ICategory currentCategory;

    public PlayerTurn(ICard currentCard, IPlayer currentPlayer, ICategory currentCategory) {
        this.currentCard = currentCard;
        this.currentPlayer = currentPlayer;
        this.currentCategory = currentCategory;
    }

    @Override
    public IPlayerTurnResult haveTurn() {
        return null;
    }
}