package App;

import App.Controllers.RoundController;
import App.Models.*;
import App.Models.Card.Card;
import App.Models.Card.EmptyCard;
import App.Views.Round.IRoundView;
import App.Views.Round.RoundStatus;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class Round implements RoundController {
    private final ArrayList<Player> players;
    private final Deck deck;
    private final IRoundView roundView;
    private final BotAI botAI;
    private final Player humanPlayer;
    private boolean respondedWithCard = false;

    private Card currentCard = new EmptyCard();
    private TrumpCategory currentTrumpCategory;

    /**
     * Creates a new instance of a round
     * @param players The players in the round
     * @param deck    The deck instance
     * @param roundView
     * @param humanPlayer
     */
    public Round(ArrayList<Player> players, Deck deck, IRoundView roundView, Player humanPlayer) {
        this.players = players;
        this.deck = deck;
        this.humanPlayer = humanPlayer;
        this.botAI = new BotAI();
        this.roundView = roundView;
    }

    /**
     * Begins a round
     *
     * @param roundResult The round result of the previous round to set up this one correctly
     * @return New roundResult instance of this round
     */
    public RoundResult begin(RoundResult roundResult) {
        // Initialize round
        currentTrumpCategory = roundResult.getCategory();
        Player startingPlayer = roundResult.getPlayer();
        roundView.roundBegan(new RoundStatus(players, currentCard, currentTrumpCategory, startingPlayer, humanPlayer, this));
        startRound(startingPlayer, roundResult);

        // Put starting player in the first index
        Collections.rotate(players, players.indexOf(startingPlayer) * -1);
        while (players.size() > 1) {
            // Rotate so the next player is in the first index
            Collections.rotate(players, -1);

            Card oldCard = currentCard;
            Player player = players.get(0);
            roundView.playerTurn(player, new RoundStatus(players, currentCard, currentTrumpCategory, player, humanPlayer, this));

            // Remove player if they have no cards (they won)
            if (player.getCards().size() == 0) {
                players.remove(player);
                continue;
            }

            // Get player to play a card
            if (player.getPlayerType().equals(Player.PlayerType.BOT)) {
                currentCard = botAI.getCard(player, currentTrumpCategory, currentCard);
            } else {
                roundView.card(player, currentCard, currentTrumpCategory, this);
                waitForResponse();
            }

            // They didn't play a card
            if (oldCard.equals(currentCard)) {
                players.remove(player);
                Collections.rotate(players, 1);
                roundView.playerRemoved(player);
                try {
                    player.getCards().add(deck.takeRandomCard());
                    roundView.drawCard(player);
                } catch (NullPointerException e) {
                    roundView.noCardsLeftInDeck(player);
                }
                // They played a trump card
            } else if (currentCard.getCardType().equals(Card.CardType.TRUMP)) {
                roundView.trumpCardSelected(player, currentCard);
                if (player.getPlayerType().equals(Player.PlayerType.BOT)) {
                    return new RoundResult(player, botAI.getCategory(new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE}), RoundResult.RoundResultType.TRUMP);
                } else {
                    roundView.category(new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE}, player, this);
                    roundView.categorySelected(player, currentTrumpCategory, new RoundStatus(players, currentCard, currentTrumpCategory, player, humanPlayer, this));
                    return new RoundResult(player, currentTrumpCategory, RoundResult.RoundResultType.NORMAL);
                }
                // They played a regular card
            } else {
                roundView.cardSelected(player, currentCard, new RoundStatus(players, currentCard, currentTrumpCategory, player, humanPlayer, this));
            }
        }
        roundView.roundWinner(players.get(0));

        // Return new round result
        if (players.get(0).getPlayerType().equals(Player.PlayerType.BOT)) {
            return new RoundResult(players.get(0), botAI.getCategory(new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE}), RoundResult.RoundResultType.NORMAL);
        } else {
            roundView.category(new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE}, players.get(0), this);
            roundView.categorySelected(players.get(0), currentTrumpCategory, new RoundStatus(players, currentCard, currentTrumpCategory, players.get(0), humanPlayer, this));
            return new RoundResult(players.get(0), currentTrumpCategory, RoundResult.RoundResultType.NORMAL);
        }
    }

    private void waitForResponse() {
        while(!respondedWithCard){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleep: " + respondedWithCard);
        }
        respondedWithCard = false;
    }

    /**
     * Initializes the round
     *
     * @param startingPlayer The starting player
     * @param roundResult    The roundResult for the previous round
     */
    private void startRound(Player startingPlayer, RoundResult roundResult) {
        roundView.playerTurn(startingPlayer, new RoundStatus(players, currentCard, currentTrumpCategory, startingPlayer, humanPlayer, this));

        if (roundResult.getRoundResultType().equals(RoundResult.RoundResultType.START)) {
            if (startingPlayer.getPlayerType().equals(Player.PlayerType.BOT)) {
                currentTrumpCategory = botAI.getCategory(new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE});
            } else {
                roundView.category(new TrumpCategory[]{TrumpCategory.ECONOMIC_VALUE, TrumpCategory.SPECIFIC_GRAVITY, TrumpCategory.CLEAVAGE, TrumpCategory.HARDNESS, TrumpCategory.CRUSTAL_ABUNDANCE}, startingPlayer, this);
            }
            roundView.categorySelected(startingPlayer, currentTrumpCategory, new RoundStatus(players, currentCard, currentTrumpCategory, startingPlayer, humanPlayer, this));
        }

        if (roundResult.getRoundResultType().equals(RoundResult.RoundResultType.NORMAL) || roundResult.getRoundResultType().equals(RoundResult.RoundResultType.START)) {
            if (startingPlayer.getPlayerType().equals(Player.PlayerType.BOT)) {

                currentCard = botAI.getCard(startingPlayer, currentTrumpCategory, new EmptyCard());
                roundView.cardSelected(startingPlayer, currentCard, new RoundStatus(players, currentCard, currentTrumpCategory, startingPlayer, humanPlayer, this));
            } else {
                roundView.card(startingPlayer, currentCard, currentTrumpCategory, this);
                waitForResponse();
                roundView.cardSelected(startingPlayer, currentCard, new RoundStatus(players, currentCard, currentTrumpCategory, startingPlayer, humanPlayer, this));
            }
        }
    }

    /**
     * View callback for selecting a category
     *
     * @param category The category to change to
     */
    @Override
    public void selectCategory(TrumpCategory category) {
        this.currentTrumpCategory = category;
    }

    /**
     * View callback for selecting a card
     *
     * @param currentCard The newly selected card
     */
    @Override
    public void selectCard(Card currentCard) {
        this.respondedWithCard = true;
        System.out.println("REspONSED WITH CARD " + respondedWithCard);
        this.currentCard = currentCard;
    }
}
