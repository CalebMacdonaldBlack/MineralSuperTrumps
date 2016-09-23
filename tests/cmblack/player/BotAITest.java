package cmblack.player;

import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;
import cmblack.category.cleavage.CleavageCategory;
import cmblack.category.hardness.HardnessCategory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 23/9/16.
 */
public class BotAITest {

    IBotAI botAI = new BotAI();

    @Test
    public void testFindBestCard() throws Exception {
        IPlayer player = new IPlayer.FakePlayer();
        player.getPlayerHand().giveCard(new IPlayCard.FakeGoodPlayCard());
        assertTrue(new IPlayCard.FakeGoodPlayCard().equals(botAI.findBestCard(player, new IPlayCard.FakeBadPlayCard(), new CleavageCategory())));
    }

    @Test
    public void testFindBestCategory() throws Exception {
        IPlayer player = new IPlayer.FakePlayer();
        player.getPlayerHand().giveCard(new IPlayCard.FakeGoodPlayCard()).giveCard(new IPlayCard.FakeGoodPlayCard());
        assertTrue(new CleavageCategory().equals(botAI.findBestCategory(player, new ICategory[]{new CleavageCategory(), new HardnessCategory()})));
    }
}