package cmblack.player.round;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;
import cmblack.deck.IDeck;
import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface ITurn {
    IPlayer getCurrentPlayer();
    ICard getCurrentCard();
    IDeck getDeck();
    ICategory getCurrentCategory();

    ITurn setCurrentCard(ICard card);
    ITurn setCurrentCategory(ICategory category);
    ITurn setCurrentPlayer(IPlayer player);



    class FakeTurn implements ITurn {
        ICard currentCard = new IPlayCard.FakePlayCard();
        ICategory currentCategory = new ICategory.FakeCleavageCategory();
        IPlayerGroup playerGroup = new IPlayerGroup.FakePlayerGroup();
        IPlayer player = new IPlayer.FakePlayer();

        @Override
        public IPlayer getCurrentPlayer() {
            return player;
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
        public ITurn setCurrentCard(ICard card) {
            this.currentCard = card;
            return this;
        }

        @Override
        public ITurn setCurrentCategory(ICategory category) {
            this.currentCategory = category;
            return this;
        }

        @Override
        public ITurn setCurrentPlayer(IPlayer player) {
            return this;
        }
    }
}
