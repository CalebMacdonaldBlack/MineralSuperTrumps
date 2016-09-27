package cmblack.controller;

import cmblack.card.CardType;
import cmblack.card.ICard;
import cmblack.category.CategoryComparisonResult;
import cmblack.category.ICategory;
import cmblack.category.cleavage.CleavageCategory;
import cmblack.category.crustalabundance.CrustalAbundanceCategory;
import cmblack.category.economicvalue.EconomicValueCategory;
import cmblack.category.hardness.HardnessCategory;
import cmblack.category.specificgravity.SpecificGravityCategory;
import cmblack.player.EmptyPlayer;
import cmblack.player.IBotAI;
import cmblack.player.IPlayer;
import cmblack.player.PlayerType;
import cmblack.player.round.ITurn;
import cmblack.view.IView;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class TurnController implements ITurnActions, ITurnController {
    private ITurn turn;
    private final IBotAI botAI;
    private final IView view;

    public TurnController(ITurn turn, IBotAI botAI, IView view){
        this.turn = turn;
        this.botAI = botAI;
        this.view = view;
    }

    @Override
    public void findCategoryFromPlayer(ICategory[] changableTrumpCategories) {
        turn = turn.setCurrentCategory(botAI.findBestCategory(turn.getCurrentPlayer(), changableTrumpCategories));
        view.currentCategoryUpdated(turn);
    }

    @Override
    public void findCategoryFromPlayer() {
        this.findCategoryFromPlayer(
                new ICategory[]{
                new CleavageCategory(),
                new HardnessCategory(),
                new SpecificGravityCategory(),
                new CrustalAbundanceCategory(),
                new EconomicValueCategory()
        });
    }

    @Override
    public void findCardFromPlayer() {
        ICard card = botAI.findBestCard(turn.getCurrentPlayer(), turn.getCurrentCard(), turn.getCurrentCategory());
        if(card.getType().equals(CardType.TRUMP_CARD) || card.getType().equals(CardType.PLAY_CARD)){
            turn = turn.setCurrentCard(card);
            turn.getCurrentPlayer().getPlayerHand().removeCard(card);
            view.currentCardUpdated(turn);
            if(turn.getCurrentPlayer().getPlayerHand().getCountOfCards() < 1){
                view.playerWon(turn);
                turn = turn.setCurrentPlayer(new EmptyPlayer());
            }
        } else {
            view.currentPlayerRemoved(turn);
        }
    }

    @Override
    public void nextPlayerTurn(IPlayer player) {
        turn = turn.setCurrentPlayer(player);
        view.currentPlayerUpdated(turn);
    }

    @Override
    public void checkWin(IPlayer player) {

    }

    @Override
    public ITurn getTurn() {
        return turn;
    }

    @Override
    public IView getView() {
        return this.view;
    }

    @Override
    public void humanFindCard() {
        view.askHumanForCard(turn, this);
    }

    @Override
    public void humanFindCategory(ICategory[] categories) {
        view.askHumanForCategory(turn, this, categories);
    }

    @Override
    public void humanFindCategory() {
        humanFindCategory(new ICategory[]{
                new CleavageCategory(),
                new HardnessCategory(),
                new SpecificGravityCategory(),
                new CrustalAbundanceCategory(),
                new EconomicValueCategory()
        });
    }

    @Override
    public void selectedCategory(ICategory category) {
        turn = turn.setCurrentCategory(category);
        view.currentCategoryUpdated(turn);
    }

    @Override
    public void selectedCard(ICard card) {
        CategoryComparisonResult categoryComparisonResult = card.getStats().compareWith(turn.getCurrentCard().getStats());
        if(!card.getType().equals(CardType.EMPTY_CARD) && categoryComparisonResult.valueForCategory(turn.getCurrentCategory()) <= 0 && !card.getType().equals(CardType.TRUMP_CARD)){
            if(turn.getCurrentPlayer().getPlayerType().equals(PlayerType.HUMAN)){
                view.humanPlayedWrongCard(turn);
                humanFindCard();
            }
        } else if(card.getType().equals(CardType.EMPTY_CARD)){
            view.currentPlayerRemoved(turn);
        } else {
            turn = turn.setCurrentCard(card);
            turn.getCurrentPlayer().getPlayerHand().removeCard(card);
            view.currentCardUpdated(turn);
            if(turn.getCurrentPlayer().getPlayerHand().getCountOfCards() < 1){
                view.playerWon(turn);
                turn = turn.setCurrentPlayer(new EmptyPlayer());
            }
        }


    }
}
