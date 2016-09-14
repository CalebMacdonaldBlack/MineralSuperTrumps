package cmblack.deck;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class DeckTest {
    ArrayList<ICard> cards = new ArrayList<>();
    IDeck deck = null;

    public DeckTest(){
        cards.add(new IPlayCard.FakePlayCard());
        cards.add(new IPlayCard.FakePlayCard1());
        this.deck = new Deck(cards);
    }

    @Test
    public void testTakeCard() throws Exception {
        assertEquals(2, deck.length());
        assertEquals("Gold", this.deck.takeCard().getTitle());
        assertEquals(1, deck.length());
    }

    @Test
    public void testTakeCardAt() throws Exception {
        assertEquals("Gold", this.deck.takeCardAt(1).getTitle());
    }

    @Test
    public void testLength() throws Exception {
        assertEquals(2, this.deck.length());
    }
}