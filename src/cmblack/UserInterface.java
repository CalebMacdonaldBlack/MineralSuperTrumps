package cmblack;

import cmblack.card.ICard;
import cmblack.game.Game;
import cmblack.game.GameState;
import cmblack.game.IGameObserver;
import cmblack.player.IPlayer;
import cmblack.player.round.IRound;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 14/09/2016.
 */
public class UserInterface implements IGameObserver{

    @Override
    public void update(Game game) {
        System.out.println("\n===============");
        System.out.println("Cards in deck: " + game.getDeck().length());

        switch (game.getGameState()){
            case START:
                System.out.println("\n*** GAME STARTING ***\n");
                break;
            case DEALING_CARDS:
                System.out.println("\n*** CARDS DEALT ***\n");
                break;
            case PLAYER_ROUND:
                System.out.println("\n*** GAME STARTING ***\n");
                IRound round = game.getRound();
                switch (round.getRoundState()){
                    case PLAYER_TURN:
                        System.out.println("\n### PLAYER STARTING TURN ###\n");
                        System.out.println(round.getCurrentPlayer().getName() + "'s turn.");
                        break;
                    case PLAYER_REMOVED:
                        System.out.println("\n### PLAYER REMOVED FROM ROUND ###\n");
                        System.out.println(round.getPlayerTurnResult().getCurrentPlayer().getName() + " was removed");
                        break;
                    case PLAYER_DREW_CARD:
                        System.out.println("\n### PLAYER REMOVED FROM ROUND ###\n");
                        ArrayList<ICard> cards = round.getPlayerTurnResult().getCurrentPlayer().getCards();
                        System.out.println(round.getPlayerTurnResult().getCurrentPlayer().getName() + " drew " + cards.get(cards.size() - 1).getTitle());
                        break;
                    case PLAYER_PLAYED_CARD:
                        System.out.println("\n### PLAYER PLAYED A CARD ###\n");
                        System.out.println(round.getPlayerTurnResult().getCurrentPlayer().getName() + " played " + round.getPlayerTurnResult().getCurrentCard());
                        break;
                    case CATEGORY_UPDATED:
                        System.out.println("\n### CURRENT CATEGORY ###\n");
                        System.out.println("Category: " + round.getPlayerTurnResult().getCurrentCategory());
                        break;
                    case PLAYER_WON_GAME:
                        System.out.println("\n### A PLAYER WON ###\n");
                        System.out.println(round.getWinners().get(round.getWinners().size() - 1).getName() + " has no cards and won!");
                        break;
                    default:
                        System.out.println("State: " + round.getRoundState());
                }
                break;
            case PLAYER_WON_ROUND:
                System.out.println("\n*** PLAYER WON ROUND***\n");
                System.out.println("Winning player: " + game.getCurrentPlayer().getName());
                break;
            default:
                System.out.println("State: " + game.getGameState());
        }

    }
}
