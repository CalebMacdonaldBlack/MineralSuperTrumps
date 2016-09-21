package cmblack.player.round;

import cmblack.card.ICard;
import cmblack.category.ICategory;
import cmblack.deck.IDeck;
import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class Round implements IRound {
    private final ICard currentCard;
    private final IDeck deck;
    private final ICategory currentCategory;
    private final IPlayer player;

    public Round(ICard currentCard, IDeck deck, ICategory currentCategory, IPlayer player) {
        this.currentCard = currentCard;
        this.deck = deck;
        this.currentCategory = currentCategory;
        this.player = player;
    }

    @Override
    public IPlayer getCurrentPlayer() {
        return player;
    }

    @Override
    public ICard getCurrentCard() {
        return this.currentCard;
    }

    @Override
    public IDeck getDeck() {
        return this.deck;
    }

    @Override
    public ICategory getCurrentCategory() {
        return this.currentCategory;
    }

    @Override
    public IRound setCurrentCard(ICard card) {
        return new Round(card, this.deck, this.currentCategory, player);
    }

    @Override
    public IRound setCurrentCategory(ICategory category) {
        return new Round(this.currentCard, this.deck, category, player);
    }

    @Override
    public IRound setCurrentPlayer(IPlayer player) {
        return new Round(this.currentCard, this.deck, this.currentCategory, player);
    }
}
