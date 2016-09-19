package cmblack.controller;

import cmblack.card.ICard;
import cmblack.category.ICategory;
import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public interface IRoundActions {
    void changeCategory(ICategory category);
    void playACard(ICard card);
    void removeAPlayer(IPlayer player);
    void nextPlayerTurn(IPlayer player);

    class FakeRoundActions implements IRoundActions {

        private ICategory category;
        private ICard card;
        private IPlayer removedPlayer;
        private IPlayer currentPlayer;

        @Override
        public void changeCategory(ICategory category) {
            this.category = category;
        }

        @Override
        public void playACard(ICard card) {
            this.card = card;
        }

        @Override
        public void removeAPlayer(IPlayer player) {
            this.removedPlayer = player;
        }

        @Override
        public void nextPlayerTurn(IPlayer player) {
            this.currentPlayer = player;
        }

        public ICategory getCategory() {
            return category;
        }

        public ICard getCard() {
            return card;
        }

        public IPlayer getRemovedPlayer() {
            return removedPlayer;
        }

        public IPlayer getCurrentPlayer() {
            return currentPlayer;
        }
    }
}
