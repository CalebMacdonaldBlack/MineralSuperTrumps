package cmblack.controller;

import cmblack.card.ICard;
import cmblack.category.ICategory;
import cmblack.player.IPlayer;
import cmblack.player.round.ITurn;
import cmblack.view.IView;

/**
 * Created by calebmacdonaldblack on 21/9/16.
 */
public interface ITurnController extends ITurnActions {
    void findCategoryFromPlayer(ICategory[] changableTrumpCategories);
    void findCategoryFromPlayer();
    void findCardFromPlayer();
    void nextPlayerTurn(IPlayer player);
    void checkWin(IPlayer player);
    ITurn getTurn();
    IView getView();
    void humanGetCard();
    void humanGetCategory();

    class FakeTurnController implements ITurnController {

        @Override
        public void findCategoryFromPlayer(ICategory[] changableTrumpCategories) {

        }

        @Override
        public void findCategoryFromPlayer() {

        }

        @Override
        public void findCardFromPlayer() {

        }

        @Override
        public void nextPlayerTurn(IPlayer player) {

        }

        @Override
        public void checkWin(IPlayer player) {

        }

        public ITurn getTurn() {
            return null;
        }

        @Override
        public IView getView() {
            return null;
        }

        @Override
        public void humanGetCard() {

        }

        @Override
        public void humanGetCategory() {

        }

        @Override
        public void selectedCategory(ICategory category) {

        }

        @Override
        public void selectedCard(ICard card) {

        }
    }
}
