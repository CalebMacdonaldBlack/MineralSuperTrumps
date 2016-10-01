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

    public Player begin(Player startingPlayer) {
        roundView.roundBegan();
        startRound(startingPlayer);
        Collections.rotate(players, players.indexOf(startingPlayer));
        while (players.size() > 1){
            Collections.rotate(players, 1);

            Card oldCard = currentCard;
            Player player = players.get(0);

            if(player.getCards().size() == 0){
                players.remove(player);
                continue;
            }

            if(player.getPlayerType().equals(Player.PlayerType.BOT)){
                currentCard = botAI.getCard(player, currentTrumpCategory, currentCard);
            }else{
                roundView.card(player, currentCard, currentTrumpCategory);
            }

            if(oldCard.equals(currentCard)){
                players.remove(player);
                roundView.playerRemoved(player);
                try {
                    player.getCards().add(deck.takeRandomCard());
                    roundView.drawCard(player);
                }catch(NullPointerException e){
                    roundView.noCardsLeftInDeck(player);
                }
            } else if(currentCard.getCardType().equals(Card.CardType.TRUMP)){
                roundView.trumpCardSelected(player, currentCard);
                if(player.getPlayerType().equals(Player.PlayerType.BOT)){
                    currentTrumpCategory = botAI.getCategory(currentCard.getTrumpCategories());
                } else {
                    roundView.category(currentCard.getTrumpCategories(), player, currentCard);
                }
                roundView.categorySelected(player, currentTrumpCategory);
            } else {
                roundView.cardSelected(player, currentCard);
            }
        }
        roundView.roundWinner(players.get(0));
        return players.get(0);
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
            roundView.category(currentCard.getTrumpCategories(), startingPlayer, currentCard);
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
