package cmblack.view;

import cmblack.category.ICategory;
import cmblack.controller.ITurnActions;
import cmblack.controller.TurnController;
import cmblack.player.IPlayer;
import cmblack.player.round.IRoundResult;
import cmblack.player.round.ITurn;

/**
 * Created by calebmacdonaldblack on 23/9/16.
 */
public interface IView {

    void currentCardUpdated(ITurn turn);

    void currentCategoryUpdated(ITurn turn);

    void currentPlayerUpdated(ITurn turn);

    void currentPlayerRemoved(ITurn turn);

    void roundStarted(IRoundResult roundResult);

    void playerDrewCard(ITurn turn);

    void playerWon(ITurn turn);

    void deckIsEmpty(IPlayer player);

    void askHumanForCard(ITurn turn, ITurnActions turnController);

    void humanPlayedWrongCard(ITurn turn);

    void askHumanForCategory(ITurn turn, TurnController turnController, ICategory[] categories);

    class FakeView implements IView{

        @Override
        public void currentCardUpdated(ITurn turn) {

        }

        @Override
        public void currentCategoryUpdated(ITurn turn) {

        }

        @Override
        public void currentPlayerUpdated(ITurn turn) {

        }

        @Override
        public void currentPlayerRemoved(ITurn turn) {

        }

        @Override
        public void roundStarted(IRoundResult roundResult) {

        }

        @Override
        public void playerDrewCard(ITurn turn) {

        }

        @Override
        public void playerWon(ITurn turn) {

        }

        @Override
        public void deckIsEmpty(IPlayer player) {

        }

        @Override
        public void askHumanForCard(ITurn turn, ITurnActions turnController) {

        }

        @Override
        public void humanPlayedWrongCard(ITurn turn) {

        }

        @Override
        public void askHumanForCategory(ITurn turn, TurnController turnController, ICategory[] categories) {

        }
    }
}
