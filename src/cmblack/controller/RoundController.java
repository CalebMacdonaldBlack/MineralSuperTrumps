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
import cmblack.player.round.IRound;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class RoundController implements IRoundActions, IRoundController{
    private IRound round;
    private final IBotAI botAI;

    public RoundController(IRound round, IBotAI botAI){
        this.round = round;
        this.botAI = botAI;
    }

    @Override
    public void findCategoryFromPlayer() {
        round = round.setCurrentCategory(botAI.findBestCategory(round.getCurrentPlayer(), new ICategory[]{
                new CleavageCategory(),
                new HardnessCategory(),
                new SpecificGravityCategory(),
                new CrustalAbundanceCategory(),
                new EconomicValueCategory()
        }));
    }

    @Override
    public void findCardFromPlayer() {
        ICard card = botAI.findBestCard(round.getCurrentPlayer(), round.getCurrentCard(), round.getCurrentCategory());
        if(card.getType().equals(CardType.TRUMP_CARD) || card.getType().equals(CardType.PLAY_CARD)){
            round = round.setCurrentCard(card);
        }
    }

    @Override
    public void nextPlayerTurn(IPlayer player) {

    }

    @Override
    public void checkWin(IPlayer player) {

    }

    @Override
    public IRound getRound() {
        return round;
    }

    @Override
    public void selectedCategory(ICategory category) {
        round = round.setCurrentCategory(category);
    }

    @Override
    public void selectedCard(ICard card) {
        round = round.setCurrentCard(card);
        round.getCurrentPlayer().getPlayerHand().removeCard(card);
    }
}
