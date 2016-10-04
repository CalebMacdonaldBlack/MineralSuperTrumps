package App.Views.Round;

import App.Controllers.RoundController;
import App.Models.Card.Card;
import App.Models.Player;
import App.Models.TrumpCategory;

/**
 * Created by calebmacdonaldblack on 5/10/2016.
 */
public class RoundViewGui implements IRoundView {

    public RoundViewGui(){
    }

    @Override
    public void roundBegan() {

    }

    @Override
    public void category(TrumpCategory[] categories, Player player, RoundController roundController) {

    }

    @Override
    public void card(Player player, Card currentCard, TrumpCategory currentTrumpCategory, RoundController roundController) {

    }

    @Override
    public void categorySelected(Player player, TrumpCategory currentTrumpCategory) {

    }

    @Override
    public void cardSelected(Player player, Card currentCard) {

    }

    @Override
    public void playerTurn(Player player) {

    }

    @Override
    public void playerRemoved(Player player) {

    }

    @Override
    public void noCardsLeftInDeck(Player player) {

    }

    @Override
    public void drawCard(Player player) {

    }

    @Override
    public void trumpCardSelected(Player player, Card currentCard) {

    }

    @Override
    public void roundWinner(Player player) {

    }
}
