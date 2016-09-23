package cmblack.player.round;

import cmblack.card.ICard;
import cmblack.category.ICategory;
import cmblack.deck.IDeck;
import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class Turn implements ITurn {
    private final ICard currentCard;
    private final IDeck deck;
    private final ICategory currentCategory;
    private final IPlayer player;

    public Turn(ICard currentCard, IDeck deck, ICategory currentCategory, IPlayer player) {
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
    public ITurn setCurrentCard(ICard card) {
        return new Turn(card, this.deck, this.currentCategory, player);
    }

    @Override
    public ITurn setCurrentCategory(ICategory category) {
        return new Turn(this.currentCard, this.deck, category, player);
    }

    @Override
    public ITurn setCurrentPlayer(IPlayer player) {
        return new Turn(this.currentCard, this.deck, this.currentCategory, player);
    }
}
