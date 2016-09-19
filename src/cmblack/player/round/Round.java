package cmblack.player.round;

import cmblack.card.ICard;
import cmblack.category.ICategory;
import cmblack.deck.IDeck;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class Round implements IRound {
    private final IPlayerGroup playerGroup;
    private final ICard currentCard;
    private final IDeck deck;
    private final ICategory currentCategory;
    private final RoundState roundState;

    public Round(IPlayerGroup playerGroup, ICard currentCard, IDeck deck, ICategory currentCategory, RoundState roundState) {
        this.playerGroup = playerGroup;
        this.currentCard = currentCard;
        this.deck = deck;
        this.currentCategory = currentCategory;
        this.roundState = roundState;
    }

    @Override
    public IPlayerGroup getPlayerGroup() {
        return this.playerGroup;
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
    public RoundState getRoundState() {
        return this.roundState;
    }

    @Override
    public IRound setCurrentCard(ICard card) {
        return new Round(this.playerGroup, card, this.deck, this.currentCategory, roundState);
    }

    @Override
    public IRound setCurrentCategory(ICategory category) {
        return new Round(this.playerGroup, this.currentCard, this.deck, category, roundState);
    }

    @Override
    public IRound setRoundState(RoundState roundState) {
        return new Round(this.playerGroup, this.currentCard, this.deck, this.currentCategory, roundState);
    }

    @Override
    public IRound setPlayerGroup(IPlayerGroup playerGroup) {
        return new Round(playerGroup, this.currentCard, this.deck, this.currentCategory, this.roundState);
    }
}
