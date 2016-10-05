package App.Views.Round;

import App.Controllers.RoundController;
import App.Models.Card.Card;
import App.Models.Player;
import App.Models.TrumpCategory;

/**
 * Created by calebmacdonaldblack on 5/10/2016.
 */
public interface IRoundView {

    /**
     * Display round began
     */
    void roundBegan(RoundStatus roundStatus);

    /**
     * Gets category from human player
     *
     * @param categories      The categories to choose from
     * @param player          The human player to select the categories
     * @param roundController The controller for the round
     */
    void category(TrumpCategory[] categories, Player player, RoundController roundController);

    /**
     * Gets a card from the human player
     *
     * @param player               The human player
     * @param currentCard          The current card
     * @param currentTrumpCategory The current trump category
     * @param roundController      The controller for the round
     */
    void card(Player player, Card currentCard, TrumpCategory currentTrumpCategory, RoundController roundController);

    /**
     * Display a category was selected
     *
     * @param player               The player who selected the category
     * @param currentTrumpCategory The trump category selected
     * @param roundStatus          The status of the round
     */
    void categorySelected(Player player, TrumpCategory currentTrumpCategory, RoundStatus roundStatus);

    /**
     * Display a card was selected
     *
     * @param player      The player who selected the card
     * @param currentCard The card selected by the player
     * @param roundStatus The status of the round
     */
    void cardSelected(Player player, Card currentCard, RoundStatus roundStatus);

    /**
     * Display player turn
     *
     * @param player The player who's turn it is
     */
    void playerTurn(Player player, RoundStatus roundStatus);

    /**
     * Display a removed player
     *
     * @param player The player who got removed
     */
    void playerRemoved(Player player);

    /**
     * Display there are no cards in the deck
     *
     * @param player The player who tried to draw a card
     */
    void noCardsLeftInDeck(Player player);

    /**
     * Display a player drawed a card
     *
     * @param player The player who drew the card
     */
    void drawCard(Player player);

    /**
     * Display a trump card was selected
     *
     * @param player      The player who drew the card
     * @param currentCard The trump card that was played
     */
    void trumpCardSelected(Player player, Card currentCard);

    /**
     * Display the round winner
     *
     * @param player The player who won the round
     */
    void roundWinner(Player player);
}