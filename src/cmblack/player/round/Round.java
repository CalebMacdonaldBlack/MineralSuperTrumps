package cmblack.player.round;

import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;
import cmblack.deck.IDeck;
import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;
import cmblack.player.round.turn.IPlayerTurnResult;
import cmblack.player.round.turn.PlayerTurn;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class Round implements IRound {

    private final IDeck deck;
    private final IPlayer[] players;
    private final IPlayer winnerOfLastRound;

    public Round(IDeck deck, IPlayer[] players, IPlayer winnerOfLastRound) {
        this.deck = deck;
        this.players = players;
        this.winnerOfLastRound = winnerOfLastRound;
    }


    //todo break this up
    @Override
    public IRoundResult haveRound() {

        IPlayerGroup playerGroup = new PlayerGroup(players);

        ArrayList<IPlayer> winners = new ArrayList<>();

        IPlayer currentPlayer = this.winnerOfLastRound;
        ICategory currentCategory = new EmptyCategory();
        ICard currentCard = new EmptyCard();

        System.out.println("\n==============");
        System.out.println("Starting round with " + playerGroup.getRemainingPlayers().size() + " players");
        System.out.println("==============");

        while(playerGroup.getRoundWinningPlayer().equals(new EmptyPlayer())){
            if(currentPlayer.equals(new EmptyPlayer())){
                currentPlayer = playerGroup.getNextPlayer(currentPlayer);
            }

            IPlayerTurnResult playerTurnResult = new PlayerTurn(currentCard, currentPlayer, currentCategory, deck).haveTurn();

            currentPlayer = playerGroup.getNextPlayer(currentPlayer);

            if(currentCard.equals(playerTurnResult.getCurrentCard())){
                playerGroup.removePlayer(playerTurnResult.getCurrentPlayer());
                System.out.println(playerTurnResult.getCurrentPlayer().getName() + " could not beat " + playerTurnResult.getCurrentCard().getTitle() + " and was removed");
                playerTurnResult.getCurrentPlayer().giveCard(deck.takeCard());
            }else{
                System.out.println(playerTurnResult.getCurrentPlayer().getName() + " played " + playerTurnResult.getCurrentCard().getTitle());

                currentCard = playerTurnResult.getCurrentCard();
                currentCategory = playerTurnResult.getCurrentCategory();
                if(playerTurnResult.getCurrentPlayer().getCountOfCards() == 0){
                    System.out.println(playerTurnResult.getCurrentPlayer().getName() + " has no cards left and wins");
                    winners.add(playerTurnResult.getCurrentPlayer());
                    playerGroup.removePlayer(playerTurnResult.getCurrentPlayer());
                }
            }
            System.out.println(playerTurnResult.getCurrentPlayer().getName() + "'s card count: " + playerTurnResult.getCurrentPlayer().getCountOfCards());

        }

        System.out.println(playerGroup.getRoundWinningPlayer().getName() + "Won the round!");

        return new RoundResult(
                winners.toArray(new IPlayer[winners.size()]),
                playerGroup.getRoundWinningPlayer());
    }
}
