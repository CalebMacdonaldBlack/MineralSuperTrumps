package cmblack.player.playerhand;

import cmblack.card.CardType;
import cmblack.card.ICard;
import cmblack.player.playerhand.IPlayerHand;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 21/9/16.
 */
public class PlayerHand implements IPlayerHand {
    private final ArrayList<ICard> cards = new ArrayList<>();

    @Override
    public IPlayerHand giveCard(ICard card) {
        cards.add(card);
        return this;
    }

    @Override
    public IPlayerHand removeCard(ICard card) {
        cards.remove(card);
        return this;
    }

    @Override
    public ArrayList<ICard> getCards() {
        return cards;
    }

    @Override
    public int getCountOfCards() {
        return cards.size();
    }
}
