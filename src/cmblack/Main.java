package cmblack;

import cmblack.deck.IDeck;
import cmblack.player.BotPlayer;
import cmblack.player.HumanPlayer;
import cmblack.player.IPlayer;
import cmblack.player.playerhand.PlayerHand;
import cmblack.player.round.PlayerGroup;
import cmblack.view.View;

/**
 * Created by calebmacdonaldblack on 16/08/2016.
 */
public class Main {
    public static void main(String[] args) {
        IPlayer[] players = new IPlayer[]{
                new HumanPlayer("Caleb", new PlayerHand()),
                new BotPlayer("bot 2", new PlayerHand()),
                new BotPlayer("bot 3", new PlayerHand())
        };
        IGame game = new Game(new IDeck.FakeDeck(), new PlayerGroup(players), new View());
        game.startGame();
    }
}
