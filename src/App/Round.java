package App;

import App.Controllers.RoundController;
import App.Models.*;
import App.Models.Card.Card;
import App.Models.Card.EmptyCard;
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

    public RoundResult begin(RoundResult roundResult) {
        currentTrumpCategory = roundResult.getCategory();
        Player startingPlayer = roundResult.getCurrentPlayer();
        roundView.roundBegan();
        startRound(startingPlayer, roundResult);
        Collections.rotate(players, players.indexOf(startingPlayer) * -1);
        while (players.size() > 1){
            Collections.rotate(players, -1);

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
                Collections.rotate(players, 1);
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
                    return new RoundResult(player, botAI.getCategory(new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE}), RoundResult.RoundResultType.TRUMP);
                }else{
                    roundView.category(new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE}, player, currentCard);
                    roundView.categorySelected(player, currentTrumpCategory);
                    return new RoundResult(player, currentTrumpCategory, RoundResult.RoundResultType.NORMAL);
                }
            } else {
                roundView.cardSelected(player, currentCard);
            }
        }
        roundView.roundWinner(players.get(0));
        if(players.get(0).getPlayerType().equals(Player.PlayerType.BOT)){
            return new RoundResult(players.get(0), botAI.getCategory(new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE}), RoundResult.RoundResultType.NORMAL);
        }else{
            roundView.category(new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE}, players.get(0), currentCard);
            roundView.categorySelected(players.get(0), currentTrumpCategory);
            return new RoundResult(players.get(0), currentTrumpCategory, RoundResult.RoundResultType.NORMAL);
        }
    }

    private void startRound(Player startingPlayer, RoundResult roundResult) {
        roundView.playerTurn(startingPlayer);
        TrumpCategory[] categories = new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE};

        if(roundResult.getRoundResultType().equals(RoundResult.RoundResultType.START)){
            if(startingPlayer.getPlayerType().equals(Player.PlayerType.BOT)){
                currentTrumpCategory = botAI.getCategory(new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE});
            }else{
                roundView.category(new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE}, startingPlayer, currentCard);
            }
            roundView.categorySelected(startingPlayer, currentTrumpCategory);
        }

        if(roundResult.getRoundResultType().equals(RoundResult.RoundResultType.NORMAL) || roundResult.getRoundResultType().equals(RoundResult.RoundResultType.START)){
            if(startingPlayer.getPlayerType().equals(Player.PlayerType.BOT)){

                currentCard = botAI.getCard(startingPlayer, currentTrumpCategory, new EmptyCard());
                roundView.cardSelected(startingPlayer, currentCard);
            }else{
                roundView.card(startingPlayer, currentCard, currentTrumpCategory);
                roundView.cardSelected(startingPlayer, currentCard);
            }
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
