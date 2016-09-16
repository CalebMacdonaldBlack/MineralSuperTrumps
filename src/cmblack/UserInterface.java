package cmblack;

import cmblack.card.CardType;
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


        // TODO: 16/09/2016 Break this down into another class
        switch (game.getGameState()){
            case START:
                System.out.println("\n*** GAME STARTING ***");
                break;
            case DEALING_CARDS:
                System.out.println("\n*** CARDS DEALT ***");
                break;
            case PLAYER_ROUND:
                System.out.println("\n*** PLAYER ROUND ***");
                IRound round = game.getRound();
                switch (round.getRoundState()){
                    case START:
                        System.out.println("\t### A ROUND HAS BEGUN ###");
                        break;
                    case PLAYER_TURN:
                        System.out.println("\t### PLAYER STARTING TURN ###");
                        System.out.print("\t\n\t\t");
                        System.out.println(round.getCurrentPlayer().getName() + "'s turn.");
                        break;
                    case PLAYER_REMOVED:
                        System.out.println("\t### PLAYER REMOVED FROM ROUND ###");
                        System.out.print("\t\n\t\t");
                        System.out.println(round.getPlayerTurnResult().getCurrentPlayer().getName() + " couldn't play a card and was removed");
                        break;
                    case PLAYER_DREW_CARD:
                        System.out.println("\t### PLAYER REMOVED FROM ROUND ###");
                        System.out.print("\t\n\t\t");
                        ArrayList<ICard> cards = round.getPlayerTurnResult().getCurrentPlayer().getCards();
                        System.out.println(round.getPlayerTurnResult().getCurrentPlayer().getName() + " drew " + cards.get(cards.size() - 1).getTitle());
                        break;
                    case PLAYER_PLAYED_CARD:
                        System.out.println("\t### PLAYER PLAYED A CARD ###");
                        System.out.print("\t\n\t\t");
                        if(round.getPlayerTurnResult().getCurrentCard().getType().equals(CardType.PLAY_CARD)){
                            System.out.println(round.getPlayerTurnResult().getCurrentPlayer().getName() + " played " + round.getPlayerTurnResult().getCurrentCard().getTitle());
                        }else{
                            System.out.println(round.getPlayerTurnResult().getCurrentPlayer().getName() + " played the trump card " + round.getPlayerTurnResult().getCurrentCard().getTitle());
                        }

                        break;
                    case CATEGORY_UPDATED:
                        System.out.println("\t### CURRENT CATEGORY ###");
                        System.out.print("\t\n\t\t");
                        System.out.println("Category: " + round.getPlayerTurnResult().getCurrentCategory().getCategoryName());
                        break;
                    case PLAYER_WON_GAME:
                        System.out.println("\t### A PLAYER WON ###");
                        System.out.print("\t\n\t\t");
                        System.out.println(round.getWinners().get(round.getWinners().size() - 1).getName() + " has no cards and won!");
                        break;
                    default:
                        System.out.println("State: " + round.getRoundState());
                }
                break;
            case PLAYER_WON_ROUND:
                System.out.println("\n*** PLAYER WON ROUND***");
                System.out.println("Winning player: " + game.getCurrentPlayer().getName());
                break;
            default:
                System.out.println("State: " + game.getGameState());
        }

    }
}
