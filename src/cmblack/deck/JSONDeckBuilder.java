package cmblack.deck;

import cmblack.card.Card;
import cmblack.card.PlayCard;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class JSONDeckBuilder implements DeckBuilder{


    @Override
    public Deck getDeck() {


        Gson gson = new Gson();
        ArrayList<Card> cards = new ArrayList<Card>();

        try {

            ParsedCardsArray parsedCardsArray = gson.fromJson(gson.newJsonReader(new FileReader("cards.json")), ParsedCardsArray.class);

            for(ParsedCard parsedCard: parsedCardsArray.getCards()){
                if(parsedCard.chemistry != null){
                    cards.add(new PlayCard(parsedCard.title, parsedCard.))
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
