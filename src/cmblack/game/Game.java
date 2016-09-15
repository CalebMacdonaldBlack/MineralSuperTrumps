package cmblack.game;

import cmblack.deck.IDeck;
import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;
import cmblack.player.round.IRound;
import cmblack.player.round.IRoundObserver;
import cmblack.player.round.IRoundResult;
import cmblack.player.round.Round;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class Game implements IGame, IObservableGame, IRoundObserver {

    private final IPlayer[] players;
    private final IDeck deck;
    private final ArrayList<IGameObserver> observers;
    private final ArrayList<IPlayer> winners = new ArrayList<>();

    //TODO these aren't final. fix this
    IPlayer currentPlayer = new EmptyPlayer();
    GameState gameState = GameState.START;
    private IRound round;

    public IRound getRound() {
        return round;
    }

    public Game(IPlayer[] players, IDeck deck, ArrayList<IGameObserver> observers) {
        this.players = players;
        this.deck = deck;
        this.observers = observers;
    }

    @Override
    public void startGame() {

        distributeCards(players, deck);
        changeState(GameState.DEALING_CARDS);
        ArrayList<IRoundObserver> roundObservers = new ArrayList<>();
        roundObservers.add(this);
        while(winners.size() < players.length - 1){


            IRoundResult roundResult = new Round(deck, players, currentPlayer, roundObservers).haveRound();
            changeState(GameState.PLAYER_ROUND);
            if(true)
                throw new NullPointerException("NOTE FOR CALEB: make new emptyRoundResult and set player_round state before haveRound and aafter new Round()");

            addWinningPlayersToList(roundResult.playersWhoWon(), winners);

            currentPlayer = roundResult.roundWinningPlayer();
            changeState(GameState.PLAYER_WON_ROUND);
        }
    }

    @Override
    public GameState getGameState() {
        return this.gameState;
    }

    private void addWinningPlayersToList(IPlayer[] players, ArrayList<IPlayer> winners) {
        for(IPlayer player: players){
            winners.add(player);
        }
    }

    private void changeState(GameState gameState){
        this.gameState = gameState;
        this.notifyGameObservers();
    }

    //TODO card distributer?
    private void distributeCards(IPlayer[] players, IDeck deck) {
        for(IPlayer player: players){
            for(int i=0; i<5;i++){
                player.giveCard(deck.takeCard());
            }
        }
    }

    @Override
    public void notifyGameObservers() {
        for(IGameObserver gameObserver: this.observers){
            gameObserver.update(this);
        }
    }

    @Override
    public void addGameObserver(IGameObserver gameObserver) {
        this.observers.add(gameObserver);
    }

    public IDeck getDeck() {
        return deck;
    }

    public ArrayList<IPlayer> getWinners() {
        return winners;
    }

    public IPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public void update(IRound round) {
        this.round = round;
        this.notifyGameObservers();
    }
}
