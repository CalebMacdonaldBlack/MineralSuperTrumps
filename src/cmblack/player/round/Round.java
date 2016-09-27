package cmblack.player.round;

import cmblack.card.CardType;
import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;
import cmblack.controller.ITurnController;
import cmblack.controller.TurnController;
import cmblack.deck.IDeck;
import cmblack.deck.ShuffledDeck;
import cmblack.player.BotAI;
import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;
import cmblack.player.PlayerType;
import cmblack.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by calebmacdonaldblack on 23/9/16.
 */
public class Round implements IRound {
    private final IDeck deck;
    private final ICard startingCard;
    private final ICategory startingCategory;
    private final IPlayer startingPlayer;
    private final IView view;
    private final IPlayerGroup playerGroup;

    public Round(IDeck deck, IPlayerGroup playerGroup, ICard startingCard, ICategory startingCategory, IPlayer startingPlayer, IView view) {
        this.deck = deck;
        this.playerGroup = playerGroup;
        this.startingCard = startingCard;
        this.startingCategory = startingCategory;
        this.startingPlayer = startingPlayer;
        this.view = view;
    }

    public Round(IDeck deck, IPlayerGroup playerGroup, IView view) {
        this(deck, playerGroup, new EmptyCard(), new EmptyCategory(), new EmptyPlayer(), view);
    }

    @Override
    public IRoundResult haveRound() {
        ITurnController turnController = new TurnController(new Turn(startingCard, deck, startingCategory, startingPlayer), new BotAI(), view);
        IPlayerGroup playerGroup = this.playerGroup;
        if (turnController.getTurn().getCurrentPlayer().equals(new EmptyPlayer())) {
            turnController.nextPlayerTurn(playerGroup.getCurrentPlayer());
        }

        if (turnController.getTurn().getCurrentCategory().equals(new EmptyCategory())) {
            turnController.findCategoryFromPlayer();
        }

        while (playerGroup.getPlayersStillInRound().length > 1) {
            IPlayer player = playerGroup.getCurrentPlayer();
            List<IPlayer> playersToRemoveFromGame = new ArrayList<>();


            ICard currentCard = turnController.getTurn().getCurrentCard();

            if (player.getPlayerType().equals(PlayerType.BOT)) {
                turnController.findCardFromPlayer();
            } else if (player.getPlayerType().equals(PlayerType.HUMAN)) {
                turnController.humanGetCard();
            }

            ICard newCard = turnController.getTurn().getCurrentCard();

            if (newCard.equals(currentCard)) {
                playerGroup = playerGroup.removePlayerFromRound(player);
                if (deck.length() > 0) {
                    player.getPlayerHand().giveCard(deck.takeCard());
                } else {
                    view.deckIsEmpty(player);
                }
                view.playerDrewCard(turnController.getTurn());
            } else if (newCard.getType().equals(CardType.TRUMP_CARD)) {
                turnController.findCategoryFromPlayer(newCard.changeableTrumpCategories());
                return new RoundResult(playerGroup, turnController.getTurn().getCurrentCategory());
            }

            if (turnController.getTurn().getCurrentPlayer().equals(new EmptyPlayer())) {
                playersToRemoveFromGame.add(playerGroup.getCurrentPlayer());
            }
            if (playerGroup.getPlayersStillInRound().length < 2) {
                break;
            }

            playerGroup = playerGroup.nextPlayerTurn();
            turnController.nextPlayerTurn(playerGroup.getCurrentPlayer());

            for (IPlayer playerToRemove : playersToRemoveFromGame) {
                playerGroup = playerGroup.removePlayerFromGame(playerToRemove);
            }

        }
        return new RoundResult(playerGroup, new EmptyCategory());
    }
}
