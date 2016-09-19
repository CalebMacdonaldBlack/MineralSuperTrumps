package cmblack.player.round;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;
import cmblack.deck.IDeck;
import cmblack.player.IPlayer;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IRound {
    IPlayerGroup getPlayerGroup();
    ICard getCurrentCard();
    IDeck getDeck();
    ICategory getCurrentCategory();
    RoundState getRoundState();

    IRound setCurrentCard(ICard card);
    IRound setCurrentCategory(ICategory category);
    IRound setRoundState(RoundState roundState);

    IRound setPlayerGroup(IPlayerGroup playerGroup);



    class FakeRound implements IRound {
        ICard currentCard = new IPlayCard.FakePlayCard();
        ICategory currentCategory = new ICategory.FakeCleavageCategory();
        IPlayerGroup playerGroup = new IPlayerGroup.FakePlayerGroup();
        RoundState roundState = RoundState.START;

        @Override
        public IPlayerGroup getPlayerGroup() {
            return playerGroup;
        }

        @Override
        public ICard getCurrentCard() {
            return currentCard;
        }

        @Override
        public IDeck getDeck() {
            return new IDeck.FakeDeck();
        }

        @Override
        public ICategory getCurrentCategory() {
            return currentCategory;
        }

        @Override
        public RoundState getRoundState() {
            return roundState;
        }

        @Override
        public IRound setCurrentCard(ICard card) {
            this.currentCard = card;
            return this;
        }

        @Override
        public IRound setCurrentCategory(ICategory category) {
            this.currentCategory = category;
            return this;
        }

        @Override
        public IRound setRoundState(RoundState roundState) {
            this.roundState = roundState;
            return this;
        }

        @Override
        public IRound setPlayerGroup(IPlayerGroup playerGroup) {
            this.playerGroup = playerGroup;
            return this;
        }
    }
}
