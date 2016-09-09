package cmblack.deck;

import cmblack.card.ICard;
import cmblack.card.playcard.PlayCard;
import cmblack.card.playcard.playcardstats.IPlayCardStats;
import cmblack.card.playcard.playcardstats.PlayCardStats;
import cmblack.card.trumpcard.TrumpCard;
import cmblack.category.cleavage.Cleavage;
import cmblack.category.cleavage.CleavageEnum;
import cmblack.category.crustalabundance.CrustalAbundance;
import cmblack.category.economicvalue.EconomicValue;
import cmblack.category.hardness.Hardness;
import cmblack.category.specificgravity.SpecificGravity;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class JSONDeckBuilder implements DeckBuilder {

    private final ParsedCardsArray parsedCardsArray;

    public JSONDeckBuilder(ParsedCardsArray parsedCardsArray) {
        this.parsedCardsArray = parsedCardsArray;

    }

    public JSONDeckBuilder(String fileName) throws FileNotFoundException {
        //TODO this looks dodgy as hell
        this((ParsedCardsArray) new Gson().fromJson(new Gson().newJsonReader(new FileReader(fileName)), ParsedCardsArray.class));
    }

    @Override
    public oldDeck getDeck() {
        ArrayList<ICard> cards = new ArrayList<ICard>();

        //TODO error handing the crap out of this

        for (ParsedCard parsedCard : parsedCardsArray.getCards()) {
            if (parsedCard.getChemistry() != null) {

                IPlayCardStats playCardStats = new PlayCardStats(

                );

                cards.add(new PlayCard(
                        parsedCard.getTitle(),
                        parsedCard.getFileName(),
                        new PlayCardStats(
                                CleavageEnum.findWithValueName(parsedCard.getCleavage()),

                        )
                        ));
//
//                cards.add(new PlayCard(
//                        parsedCard.getTitle(),
//                        parsedCard.getFileName(),
//                        parsedCard.getChemistry(),
//                        parsedCard.getClassification(),
//                        parsedCard.getCrystal_system(),
//                        parsedCard.getOccurrence(),
//                        new PlayCardStats(
//                                new Cleavage(Cleavage.CleavageOptions.getWithLabel(parsedCard.getCleavage())),
//                                new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.getWithLabel(parsedCard.getCrustal_abundance())),
//                                new EconomicValue(EconomicValue.EconomicValueOptions.getWithLabel(parsedCard.getEconomic_value())),
//                                new Hardness(this.getLowFromRangeString(parsedCard.getHardness()), this.getHighFromRangeString(parsedCard.getHardness())),
//                                new SpecificGravity(this.getLowFromRangeString(parsedCard.getSpecific_gravity()), this.getHighFromRangeString(parsedCard.getSpecific_gravity()))
//
//                        ),
//                        cardDescription));
            } else {
//                cards.add(new TrumpCard(parsedCard.getTitle(), parsedCard.getSubTitle(), parsedCard.getFileName(), parsedCard.getCategories(), title1));
            }
        }
        return new oldDeck(cards, new ArrayList<ICard>());
    }

    /**
     * get the lowest value in the string range
     *
     * @param doubleRange
     * @return lowest value in the range
     */
    private Double getLowFromRangeString(String doubleRange) {
        return Double.parseDouble(doubleRange.split("-")[0]);
    }

    /**
     * get the highest value in the range from string
     *
     * @param doubleRange
     * @return highest value in the range
     */
    private Double getHighFromRangeString(String doubleRange) {
        String[] splitDouble = doubleRange.split("-");
        return splitDouble.length > 1 ? Double.parseDouble(splitDouble[1]) : Double.parseDouble(splitDouble[0]);
    }
}
