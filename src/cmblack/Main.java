package cmblack;

import cmblack.card.playcard.IPlayCard;
import cmblack.card.trumpcard.ITrumpCard;
import cmblack.category.cleavage.CleavageCategory;
import cmblack.controller.RoundController;
import cmblack.deck.IDeck;
import cmblack.game.IGameActions;
import cmblack.player.BotPlayer;
import cmblack.player.HumanPlayer;
import cmblack.player.IPlayer;
import cmblack.player.round.PlayerGroup;
import cmblack.player.round.Round;
import cmblack.player.round.RoundState;
import cmblack.player.round.RoundView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by calebmacdonaldblack on 16/08/2016.
 */
public class Main {
    public static void main(String[] args) {
        IPlayer player = new HumanPlayer("Caleb");
        player.giveCard(new IPlayCard.FakeGoodPlayCard()).giveCard(new IPlayCard.FakeBadPlayCard()).giveCard(new ITrumpCard.FakeTrumpCard());
        player.playCard(
                new IPlayCard.FakeGoodPlayCard(),
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
}
