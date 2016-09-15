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
public class Round implements IRound, IObservableRound {

    private final IDeck deck;
    private final IPlayer[] players;
    private final IPlayer winnerOfLastRound;
    private final ArrayList<IRoundObserver> roundObservers;

    // TODO: 15/09/2016 these should be final fix
    private RoundState roundState = RoundState.START;
    private IPlayer currentPlayer;
    private IPlayerTurnResult playerTurnResult;
    ArrayList<IPlayer> winners = new ArrayList<>();

    public Round(IDeck deck, IPlayer[] players, IPlayer winnerOfLastRound, ArrayList<IRoundObserver> roundObservers) {
        this.deck = deck;
        this.players = players;
        this.winnerOfLastRound = winnerOfLastRound;
        this.roundObservers = roundObservers;
    }


    //todo break this up
    @Override
    public IRoundResult haveRound() {

        IPlayerGroup playerGroup = new PlayerGroup(players);

        currentPlayer = this.winnerOfLastRound;

        ICategory currentCategory = new EmptyCategory();
        ICard currentCard = new EmptyCard();

        while(playerGroup.getRoundWinningPlayer().equals(new EmptyPlayer())){
            if(currentPlayer.equals(new EmptyPlayer())){
                currentPlayer = playerGroup.getNextPlayer(currentPlayer);
            }
            changeState(RoundState.PLAYER_TURN);

            playerTurnResult = new PlayerTurn(currentCard, currentPlayer, currentCategory, deck).haveTurn();

            currentPlayer = playerGroup.getNextPlayer(currentPlayer);

            if(currentCard.equals(playerTurnResult.getCurrentCard())){
                playerGroup.removePlayer(playerTurnResult.getCurrentPlayer());
                changeState(RoundState.PLAYER_REMOVED);

                playerTurnResult.getCurrentPlayer().giveCard(deck.takeCard());
                changeState(RoundState.PLAYER_DREW_CARD);
            }else{

                currentCard = playerTurnResult.getCurrentCard();
                changeState(RoundState.PLAYER_PLAYED_CARD);
                currentCategory = playerTurnResult.getCurrentCategory();
                changeState(RoundState.CATEGORY_UPDATED);
                if(playerTurnResult.getCurrentPlayer().getCountOfCards() == 0){
                    winners.add(playerTurnResult.getCurrentPlayer());
                    playerGroup.removePlayer(playerTurnResult.getCurrentPlayer());
                    changeState(RoundState.PLAYER_WON_GAME);
                }
            }

        }


        return new RoundResult(
                winners.toArray(new IPlayer[winners.size()]),
                playerGroup.getRoundWinningPlayer());
    }

    @Override
    public RoundState getRoundState() {
        return this.roundState;
    }

    @Override
    public IPlayer getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public IPlayerTurnResult getPlayerTurnResult() {
        return this.playerTurnResult;
    }

    @Override
    public ArrayList<IPlayer> getWinners() {
        return this.winners;
    }

    private void changeState(RoundState roundState) {
        this.roundState = roundState;
        this.notifyRoundObservers();
    }

    @Override
    public void notifyRoundObservers() {
        //TODO unit test this
        for(IRoundObserver roundObserver: roundObservers){
            roundObserver.update(this);
        }
    }

    @Override
    public void addRoundObserver(IRoundObserver roundObserver) {
        //TODO unit test this
        this.roundObservers.add(roundObserver);
    }
}
