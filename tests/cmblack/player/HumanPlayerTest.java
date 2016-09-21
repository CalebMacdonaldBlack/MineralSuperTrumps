package cmblack.player;

import cmblack.card.playcard.IPlayCard;
import cmblack.card.trumpcard.ITrumpCard;
import cmblack.category.cleavage.CleavageCategory;
import cmblack.controller.RoundController;
import cmblack.deck.IDeck;
import cmblack.game.IGameActions;
import cmblack.player.round.PlayerGroup;
import cmblack.player.round.Round;
import cmblack.player.round.RoundState;
import cmblack.player.round.RoundView;
import org.junit.Test;
import sun.net.www.content.text.PlainTextInputStream;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 20/09/2016.
 */
public class HumanPlayerTest {

    IPlayer player = new HumanPlayer("Caleb");

    @Test
    public void testAddCard() throws Exception {
        assertEquals(0, player.getCountOfCards());
        assertEquals(1, player.giveCard(new IPlayCard.FakePlayCard()).getCountOfCards());
    }

    @Test
    public void testPlayCard() throws Exception {
        player.giveCard(new IPlayCard.FakeGoodPlayCard()).giveCard(new ITrumpCard.FakeTrumpCard());
        player.playCard(
                new IPlayCard.FakeBadPlayCard(),
                new CleavageCategory(),
                new RoundController(
                        new Round(
                                new PlayerGroup(
                                        new IPlayer[]{player, new BotPlayer("bot1")}
                                ),
                                new IPlayCard.FakeBadPlayCard(),
                                new IDeck.FakeDeck(),
                                new CleavageCategory(),
                                RoundState.START
                        ),
                        new RoundView(
                                new Scanner(System.in)
                        ),
                        new IGameActions.FakeGameActions()
                )
        );
    }

    @Test
    public void testGetName() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {
    }

    @Test
    public void testChooseCategory() throws Exception {

    }

    @Test
    public void testChooseCategory1() throws Exception {

    }

    @Test
    public void testGetCountOfCards() throws Exception {

    }

    @Test
    public void testGiveCard() throws Exception {

    }

    @Test
    public void testGetCards() throws Exception {

    }
}