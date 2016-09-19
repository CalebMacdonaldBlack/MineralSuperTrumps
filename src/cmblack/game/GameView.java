package cmblack.game;

import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 19/09/2016.
 */
public class GameView implements IGameView{
    @Override
    public void update(IGame game) {
        switch(game.getGameState()){
            case DEALING_CARDS:
                System.out.println("Cards have been dealt");
                break;
            case START:
                System.out.println("A game has started");
                break;
            case PLAYER_WON_GAME:
                System.out.println(game.getWinningPlayers()[game.getWinningPlayers().length - 1].getName() + " has no cards an won");
                break;
            case FINISHED:
                System.out.println("The game is finished winners in order:");
                for(IPlayer p: game.getWinningPlayers()){
                    System.out.println("- " + p.getName());
                }
        }
    }
}
