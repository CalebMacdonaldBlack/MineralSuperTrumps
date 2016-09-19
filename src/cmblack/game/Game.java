package cmblack.game;

import cmblack.card.EmptyCard;
import cmblack.controller.RoundController;
import cmblack.deck.IDeck;
import cmblack.player.IPlayer;
import cmblack.player.round.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class Game implements IGame {
    private final IDeck deck;
    private final IRoundView roundView;
    private final GameState gameState;
    private final IRoundResult[] roundResults;
    private final IPlayer[] players;
    private final IPlayer[] winningPlayers;

    public Game(IPlayer[] players, IDeck deck, IRoundView roundView, GameState gameState, IRoundResult[] roundResults, IPlayer[] winningPlayers) {
        this.players = players;
        this.deck = deck;
        this.roundView = roundView;
        this.gameState = gameState;
        this.roundResults = roundResults;
        this.winningPlayers = winningPlayers;
    }

    @Override
    public IGame startRound(IGameActions gameActions) {
        IRound round = null;

        if(roundResults.length == 0){
            round = new Round(new PlayerGroup(players), new EmptyCard(), deck, players[0].chooseCategory(), RoundState.START);
        } else {
            IRoundResult roundResult = roundResults[roundResults.length - 1];
            round = new Round(new PlayerGroup(roundResult.getPlayers(), roundResult.getRoundWinningPlayer()), new EmptyCard(), deck, roundResult.getRoundWinningPlayer().chooseCategory(), RoundState.START);
        }

        RoundController roundController = new RoundController(round, this.roundView, gameActions);
        round.getPlayerGroup().getAllPlayers()[0].playCard(round.getCurrentCard(), round.getCurrentCategory(), roundController);

        return this;
        }

    @Override
    public GameState getGameState() {
        return gameState;
    }

    @Override
    public IGame dealCards() {
        for(IPlayer player: players){
            for(int count=1;count<=5;count++){
                player.giveCard(deck.takeCard());
            }
        }
        return this;
    }

    @Override
    public IGame setGameState(GameState gameState) {
        return new Game(players, deck, roundView, gameState, roundResults, winningPlayers);
    }

    @Override
    public IGame addWinningPlayer(IPlayer player) {
        List<IPlayer> winningPlayers = new ArrayList<>();
        for(IPlayer p: this.winningPlayers){
            winningPlayers.add(p);
        }
        winningPlayers.add(player);

        return new Game(players, deck, roundView, gameState, roundResults, winningPlayers.toArray(new IPlayer[winningPlayers.size()]));
    }

    @Override
    public IPlayer[] getWinningPlayers() {
        return winningPlayers;
    }

    public IRoundResult[] getRoundResults() {
        return roundResults;
    }

    @Override
    public IGame addRoundResult(IRoundResult roundResult) {
        List<IRoundResult> roundResults = new ArrayList<>();

        for(IRoundResult rr: this.roundResults){
            roundResults.add(rr);
        }
        roundResults.add(roundResult);
        return new Game(players, deck, roundView, gameState, roundResults.toArray(new IRoundResult[roundResults.size()]),winningPlayers);
    }
}
