package cmblack.deck;

import cmblack.card.CardDescription;
import cmblack.card.ICard;
import cmblack.card.ICardDescription;
import cmblack.card.playcard.PlayCard;
import cmblack.card.stats.IStats;
import cmblack.card.stats.Stats;
import cmblack.card.trumpcard.TrumpCard;
import cmblack.category.Category;
import cmblack.category.ICategory;
import cmblack.category.cleavage.Cleavage;
import cmblack.category.cleavage.CleavageValue;
import cmblack.category.cleavage.ICleavageBuilder;
import cmblack.category.crustalabundance.CrustalAbundance;
import cmblack.category.crustalabundance.CrustalAbundanceValue;
import cmblack.category.crustalabundance.ICrustalAbundanceBuilder;
import cmblack.category.economicvalue.EconomicValue;
import cmblack.category.economicvalue.EconomicValueValue;
import cmblack.category.hardness.Hardness;
import cmblack.category.specificgravity.SpecificGravity;
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
