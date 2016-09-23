package cmblack.controller;

import cmblack.card.CardType;
import cmblack.card.ICard;
import cmblack.category.ICategory;
import cmblack.category.cleavage.CleavageCategory;
import cmblack.category.crustalabundance.CrustalAbundanceCategory;
import cmblack.category.economicvalue.EconomicValueCategory;
import cmblack.category.hardness.HardnessCategory;
import cmblack.category.specificgravity.SpecificGravityCategory;
import cmblack.player.IBotAI;
import cmblack.player.IPlayer;
import cmblack.player.round.ITurn;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class RoundController implements IRoundActions, IRoundController{
    private ITurn turn;
    private final IBotAI botAI;

    public RoundController(ITurn round, IBotAI botAI){
        this.turn = round;
        this.botAI = botAI;
    }

    @Override
    public void findCategoryFromPlayer() {
        turn = turn.setCurrentCategory(botAI.findBestCategory(turn.getCurrentPlayer(), new ICategory[]{
                new CleavageCategory(),
                new HardnessCategory(),
                new SpecificGravityCategory(),
                new CrustalAbundanceCategory(),
                new EconomicValueCategory()
        }));
    }

    @Override
    public void findCardFromPlayer() {
        ICard card = botAI.findBestCard(turn.getCurrentPlayer(), turn.getCurrentCard(), turn.getCurrentCategory());
        if(card.getType().equals(CardType.TRUMP_CARD) || card.getType().equals(CardType.PLAY_CARD)){
            turn = turn.setCurrentCard(card);
        }
    }

    @Override
    public void nextPlayerTurn(IPlayer player) {

    }

    @Override
    public void checkWin(IPlayer player) {

    }

    public ITurn getTurn() {
        return turn;
    }

    @Override
    public void selectedCategory(ICategory category) {
        turn = turn.setCurrentCategory(category);
    }

    @Override
    public void selectedCard(ICard card) {
        turn = turn.setCurrentCard(card);
        turn.getCurrentPlayer().getPlayerHand().removeCard(card);
    }
}
