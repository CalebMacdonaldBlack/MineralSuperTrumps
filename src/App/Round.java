package App;

import App.Controllers.RoundController;
import App.Models.BotAI;
import App.Models.Card.Card;
import App.Models.Card.EmptyCard;
import App.Models.Deck;
import App.Models.Player;
import App.Models.TrumpCategory;
import App.Views.RoundView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class Round implements RoundController{
    private final ArrayList<Player> players;
    private final Deck deck;
    private final RoundView roundView;
    private final BotAI botAI;

    private Card currentCard = new EmptyCard();
    private TrumpCategory currentTrumpCategory;

    public Round(ArrayList<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
        this.roundView = new RoundView(this);
        this.botAI = new BotAI();
    }

    public void begin(Player startingPlayer) {
        roundView.roundBegan();
        startRound(startingPlayer);
        Collections.rotate(players, players.indexOf(startingPlayer));
        while (players.size() > 1){
            Collections.rotate(players, 1);

            Card oldCard = currentCard;
            Player player = players.get(0);
            if(player.getPlayerType().equals(Player.PlayerType.BOT)){
                currentCard = botAI.getCard(player, currentTrumpCategory, currentCard);
                roundView.cardSelected(player, currentCard);
            }else{
                roundView.card(player, currentCard, currentTrumpCategory);
                roundView.cardSelected(player, currentCard);
            }

            if(oldCard.equals(currentCard)){
                players.remove(player);
                roundView.playerRemoved(player);
            } else if(currentCard.getCardType().equals(Card.CardType.TRUMP)){
                if(player.getPlayerType().equals(Player.PlayerType.BOT)){
                    currentTrumpCategory = botAI.getCategory(currentCard.getTrumpCategories());
                } else {
                    roundView.category(currentCard.getTrumpCategories());
                }
            }


        }
    }

    private void startRound(Player startingPlayer) {
        roundView.playerTurn(startingPlayer);
        TrumpCategory[] categories = new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE};

        if(startingPlayer.getPlayerType().equals(Player.PlayerType.BOT)){
            currentTrumpCategory = botAI.getCategory(categories);
            roundView.categorySelected(startingPlayer, currentTrumpCategory);

            currentCard = botAI.getCard(startingPlayer, currentTrumpCategory, new EmptyCard());
            roundView.cardSelected(startingPlayer, currentCard);
        }else{
            roundView.category(categories);
            roundView.categorySelected(startingPlayer, currentTrumpCategory);

            roundView.card(startingPlayer, currentCard, currentTrumpCategory);
            roundView.cardSelected(startingPlayer, currentCard);
        }
    }

    @Override
    public void selectCategory(TrumpCategory category) {
        this.currentTrumpCategory = category;
    }

    @Override
    public void selectCard(Card currentCard) {
        this.currentCard = currentCard;
    }
}
