package cmblack.controller;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;
import cmblack.player.IPlayer;
import cmblack.player.round.IRound;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public interface IRoundActions {
    void changeCategory(ICategory category);
    void playACard(ICard card);
    void removeAPlayer(IPlayer player);
    void drawACard(IPlayer player);
    void turnEnded(IPlayer player);
    IRound getRound();

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
        public void drawACard(IPlayer player) {
            player.giveCard(new IPlayCard.FakePlayCard());
        }

        @Override
        public void turnEnded(IPlayer player) {

        }

        @Override
        public IRound getRound() {
            return new IRound.FakeRound();
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
