package cmblack.player.round.turn;

import cmblack.card.ICard;
import cmblack.category.ICategory;
import cmblack.deck.IDeck;
import cmblack.player.IPlayer;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class PlayerTurn implements IPlayerTurn{

    private final ICard currentCard;
    private final IPlayer currentPlayer;
    private final ICategory currentCategory;
    private final IDeck deck;

    public PlayerTurn(ICard currentCard, IPlayer currentPlayer, ICategory currentCategory, IDeck deck) {
        this.currentCard = currentCard;
        this.currentPlayer = currentPlayer;
        this.currentCategory = currentCategory;
        this.deck = deck;
    }

    @Override
    public IPlayerTurnResult haveTurn() {
        ICard playedCard = this.currentPlayer.playCard(this.currentCard, this.currentCategory);
        switch(playedCard.getType()){
            case PLAY_CARD:
                return new PlayerTurnResult(playedCard, this.currentPlayer, this.currentCategory);
            case EMPTY_CARD:
                this.currentPlayer.giveCard(this.deck.takeCard());
                return new PlayerTurnResult(this.currentCard, this.currentPlayer, this.currentCategory);
            case TRUMP_CARD:
                return new PlayerTurnResult(playedCard, this.currentPlayer, this.currentPlayer.chooseCategory());
            default:
                throw new NullPointerException();
        }

    }
}
