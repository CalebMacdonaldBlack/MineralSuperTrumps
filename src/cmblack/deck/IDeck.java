package cmblack.deck;

import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.deck.deckbuilder.IJsonReaderWrapper;
import cmblack.deck.deckbuilder.JSONDeckBuilder;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IDeck {
    ICard takeCard();
    ICard takeCardAt(int index);
    int length();

    class FakeDeck implements IDeck {

        ArrayList<ICard> cards = new ArrayList<>();

        public FakeDeck() {
            try{
                IDeck deck = new JSONDeckBuilder(new IJsonReaderWrapper.FakeJsonReaderWrapper().getReader()).build();

                for(int i=0;i<deck.length();i++){
                    cards.add(deck.takeCard());
                }
            }catch(FileNotFoundException e){
                throw new NullPointerException();
            }
        }

        @Override
        public ICard takeCard() {
            try{
                ICard card = cards.get(0);
                cards.remove(card);
                return card;
            }catch(IndexOutOfBoundsException e){
                return new EmptyCard();
            }
        }

        @Override
        public ICard takeCardAt(int index) {
            ICard card = cards.get(index);
            cards.remove(card);
            return card;
        }

        @Override
        public int length() {
            return cards.size();
        }
    }
}

