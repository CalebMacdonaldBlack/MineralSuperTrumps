package cmblack.deck;

import cmblack.card.ICard;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class JSONDeckBuilder implements IDeckBuilder {

    private final JsonReader jsonReader;
    //private final IPlayCardBuilder playCardBuilder;

    public JSONDeckBuilder(JsonReader jsonReader) throws FileNotFoundException {
        this.jsonReader = jsonReader;
    }

    // TODO break up into playCardBuilder and TrumpCardBuilder.
    // TODO playCardBuilder with have a builder for each category
    @Override
    public IDeck getDeck() {
        ArrayList<ICard> cards = new ArrayList<ICard>();

        //TODO error handing the crap out of this

        for (ParsedCard parsedCard : ((ParsedCardsArray) new Gson().fromJson(jsonReader, ParsedCardsArray.class)).getCards()) {
            if (parsedCard.getChemistry() != null) {

//                cards.add(new PlayCard(
//                        parsedCard.getTitle(),
//                        parsedCard.getFileName(),
//                        this.createPlayCardStats(parsedCard),
//                        this.createCardDescription(parsedCard)
//                        ));
            } else {
                //cards.add(new TrumpCard(parsedCard.getTitle(), parsedCard.getSubTitle(), parsedCard.getFileName(), this.createCategories(parsedCard)));
            }
        }
        return new Deck(cards);
    }
}
