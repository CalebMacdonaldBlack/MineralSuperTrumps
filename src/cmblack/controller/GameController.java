package cmblack.controller;

import cmblack.game.GameState;
import cmblack.game.IGame;
import cmblack.game.IGameActions;
import cmblack.game.IGameView;
import cmblack.player.IPlayer;
import cmblack.player.round.IRoundResult;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class GameController implements IGameActions{

    private final IGameView gameView;
    private IGame game;

    public GameController(IGameView gameView, IGame game) {
        this.gameView = gameView;
        this.game = game;
    }

    @Override
    public void RoundFinished(IRoundResult roundResult) {
        game = game.setGameState(GameState.ROUND_OVER).addRoundResult(roundResult);
        gameView.update(game);

        if(this.game.getRoundResults()[game.getRoundResults().length - 1].getPlayers().length > 1){
            game = game.setGameState(GameState.START).startRound(this);
        } else {
            game = game.setGameState(GameState.FINISHED);
            this.gameView.update(game);
        }
    }

    @Override
    public void playerRemovedFromGame(IPlayer player) {
        game = game.setGameState(GameState.PLAYER_WON_GAME).addWinningPlayer(player);
        gameView.update(game);
    }

    @Override
    public void dealCards() {
        game = game.dealCards().setGameState(GameState.DEALING_CARDS);
        gameView.update(game);
    }

    @Override
    public void startGame() {
        game = game.startRound(this).setGameState(GameState.START);
        gameView.update(game);
    }
}
