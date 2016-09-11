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
        ArrayList<IPlayer> playersInRound = getPlayersAsArrayList(players);
        ArrayList<IPlayer> playersWithNoCards = new ArrayList<>();
        IPlayer currentPlayer = this.winnerOfLastRound;
        ICategory currentCategory = new EmptyCategory();
        ICard currentCard = new EmptyCard();
        boolean startOfRound = true;

        System.out.println("\n==============");
        System.out.println("Starting round with " + playersInRound.size() + " players");
        System.out.println("==============");

        while(playersInRound.size() > 1){
            if(startOfRound && currentPlayer.equals(new EmptyPlayer()) || !startOfRound){
                currentPlayer = this.getNextPlayer(currentPlayer, playersInRound);
            }
            startOfRound = false;

            IPlayerTurnResult playerTurnResult = new PlayerTurn(currentCard, currentPlayer, currentCategory, deck).haveTurn();


            if(currentCard.equals(playerTurnResult.getCurrentCard())){
                playersInRound.remove(playerTurnResult.getCurrentPlayer());
                System.out.println(currentPlayer.getName() + " could not beat " + playerTurnResult.getCurrentCard().getTitle() + " and was removed");
                playerTurnResult.getCurrentPlayer().giveCard(deck.takeCard());
            }else{
                System.out.println(currentPlayer.getName() + " played " + playerTurnResult.getCurrentCard().getTitle());

                currentCard = playerTurnResult.getCurrentCard();
                currentCategory = playerTurnResult.getCurrentCategory();
                if(playerTurnResult.getCurrentPlayer().getCountOfCards() == 0){
                    System.out.println(currentPlayer.getName() + " has no cards left and wins");
                    playersWithNoCards.add(playerTurnResult.getCurrentPlayer());
                    playersInRound.remove(playerTurnResult.getCurrentPlayer());
                }
            }
            System.out.println(playerTurnResult.getCurrentPlayer().getName() + "'s card count: " + playerTurnResult.getCurrentPlayer().getCountOfCards());

        }

        System.out.println(playersInRound.get(0).getName() + "Won the round!");

        return new RoundResult(
                playersWithNoCards.toArray(new IPlayer[playersWithNoCards.size()]),
                this.getPlayersLeft(playersWithNoCards),
                playersInRound.get(0));
    }

    private IPlayer[] getPlayersLeft(ArrayList<IPlayer> playersWithNoCards) {
        ArrayList<IPlayer> playersLeft = new ArrayList<>();
        for(IPlayer player: players){
            if(!playersWithNoCards.contains(player)){
                playersLeft.add(player);
            }
        }
        return playersLeft.toArray(new IPlayer[playersLeft.size()]);
    }

    private IPlayer getNextPlayer(IPlayer currentPlayer, ArrayList<IPlayer> playersInRound) {
        if(currentPlayer.equals(new EmptyPlayer())){
            currentPlayer = playersInRound.get(0);
        }

        for(int i=0;i<playersInRound.size();i++){
            if(playersInRound.get(i).equals(currentPlayer)){
                if(i == playersInRound.size() -1){
                    return playersInRound.get(0);
                }else{
                    return playersInRound.get(i + 1);
                }
            }
        }
        throw new NullPointerException(currentPlayer.getName() + " cound not be found in the players in round");
    }

    private ArrayList<IPlayer> getPlayersAsArrayList(IPlayer[] players) {
        ArrayList<IPlayer> playersAsList = new ArrayList<>();
        for(IPlayer player: players){
            playersAsList.add(player);
        }
        return playersAsList;
    }
}
