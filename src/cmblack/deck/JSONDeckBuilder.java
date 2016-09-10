package cmblack.deck;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCardBuilder;
import cmblack.card.playcard.PlayCardBuilder;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class JSONDeckBuilder implements IDeckBuilder {

    private final JsonReader jsonReader;
    private final IPlayCardBuilder playCardBuilder;

    public JSONDeckBuilder(JsonReader jsonReader, IPlayCardBuilder playCardBuilder) throws FileNotFoundException {
        this.jsonReader = jsonReader;
        this.playCardBuilder = playCardBuilder;
    }

    public JSONDeckBuilder(JsonReader jsonReader) throws FileNotFoundException {
        this(jsonReader, new PlayCardBuilder());
    }

    @Override
    public IDeck getDeck() {
        ArrayList<ICard> cards = new ArrayList<ICard>();

        //TODO error handing the crap out of this

        for (ParsedCard parsedCard : ((ParsedCardsArray) new Gson().fromJson(jsonReader, ParsedCardsArray.class)).getCards()) {
            if (parsedCard.getChemistry() != null) {
                cards.add(this.playCardBuilder.build(parsedCard));
            } else {
                //cards.add(new TrumpCard(parsedCard.getTitle(), parsedCard.getSubTitle(), parsedCard.getFileName(), this.createCategories(parsedCard)));
            }
        }
        return new Deck(cards);
    }
}
