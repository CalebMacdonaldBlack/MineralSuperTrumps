package cmblack.card.playcard;

import cmblack.card.CardDescription;
import cmblack.card.ICardDescription;
import cmblack.card.stats.IStats;
import cmblack.card.stats.Stats;
import cmblack.category.cleavage.Cleavage;
import cmblack.category.cleavage.CleavageValue;
import cmblack.category.crustalabundance.CrustalAbundance;
import cmblack.category.crustalabundance.CrustalAbundanceValue;
import cmblack.category.economicvalue.EconomicValue;
import cmblack.category.economicvalue.EconomicValueValue;
import cmblack.category.hardness.Hardness;
import cmblack.category.specificgravity.SpecificGravity;
import cmblack.deck.IParsedCard;
import cmblack.deck.ParsedCard;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class PlayCardBuilder implements IPlayCardBuilder{

    @Override
    public IPlayCard build(IParsedCard parsedCard) {
        return new PlayCard(
                parsedCard.getTitle(),
                parsedCard.getFileName(),
                this.createPlayCardStats(parsedCard),
                this.createCardDescription(parsedCard)
        );
    }


    private ICardDescription createCardDescription(IParsedCard parsedCard) {
        return new CardDescription(
                parsedCard.getChemistry(),
                parsedCard.getClassification(),
                parsedCard.getCrystal_system(),
                parsedCard.getOccurrence()
        );
    }

    private IStats createPlayCardStats(IParsedCard parsedCard) {
        return new Stats(
                this.createCleavage(parsedCard.getCleavage()),
                this.createCrustalAbundance(parsedCard.getCrustal_abundance()),
                this.createEconomicValue(parsedCard.getEconomic_value()),
                new Hardness(
                        this.getLowFromRangeString(parsedCard.getHardness()),
                        this.getHighFromRangeString(parsedCard.getHardness())
                ),
                new SpecificGravity(
                        this.getLowFromRangeString(parsedCard.getSpecific_gravity()),
                        this.getHighFromRangeString(parsedCard.getSpecific_gravity())
                )

        );
    }

    private Cleavage createCleavage(String valueText) {
        switch(valueText){
            case "none":
                return new Cleavage(CleavageValue.NONE);
            case "poor/none":
                return new Cleavage(CleavageValue.POOR_NONE);
            case "1 poor":
                return new Cleavage(CleavageValue.POOR1);
            case "2 poor":
                return new Cleavage(CleavageValue.POOR2);
            case "1 good":
                return new Cleavage(CleavageValue.GOOD1);
            case "1 good, 1 poor":
                return new Cleavage(CleavageValue.GOOD1_POOR1);
            case "2 good":
                return new Cleavage(CleavageValue.GOOD2);
            case "3 good":
                return new Cleavage(CleavageValue.GOOD3);
            case "1 perfect":
                return new Cleavage(CleavageValue.PERFECT1);
            case "1 perfect, 1 good":
                return new Cleavage(CleavageValue.PERFECT1_GOOD1);
            case "1 perfect, 2 good":
                return new Cleavage(CleavageValue.PERFECT1_GOOD2);
            case "2 perfect, 1 good":
                return new Cleavage(CleavageValue.PERFECT2_GOOD1);
            case "3 perfect":
                return new Cleavage(CleavageValue.PERFECT3);
            case "4 perfect":
                return  new Cleavage(CleavageValue.PERFECT4);
            case "6 perfect":
                return new Cleavage(CleavageValue.PERFECT6);
            default:
                throw new NullPointerException("Cleavage getValue for " + valueText + " is not found");
        }
    }

    private CrustalAbundance createCrustalAbundance(String valueText) {
        switch (valueText){
            case "ultratrace":
                return new CrustalAbundance(CrustalAbundanceValue.ULTRATRACE);
            case "trace":
                return new CrustalAbundance(CrustalAbundanceValue.TRACE);
            case "low":
                return new CrustalAbundance(CrustalAbundanceValue.LOW);
            case "moderate":
                return new CrustalAbundance(CrustalAbundanceValue.MODERATE);
            case "high":
                return new CrustalAbundance(CrustalAbundanceValue.HIGH);
            case "very high":
                return new CrustalAbundance(CrustalAbundanceValue.VERY_HIGH);
            default:
                throw new NullPointerException("CrustalAbundance getValue for " + valueText + " is not found");
        }
    }

    private EconomicValue createEconomicValue(String valueText) {
        switch (valueText){
            case "trivial":
                return new EconomicValue(EconomicValueValue.TRIVIAL);
            case "low":
                return new EconomicValue(EconomicValueValue.LOW);
            case "moderate":
                return new EconomicValue(EconomicValueValue.MODERATE);
            case "high":
                return new EconomicValue(EconomicValueValue.HIGH);
            case "very high":
                return new EconomicValue(EconomicValueValue.VERY_HIGH);
            case "I'm rich!":
                return new EconomicValue(EconomicValueValue.IM_RICH);
            default:
                throw new NullPointerException("EconomicValue getValue for " + valueText + " is not found");
        }
    }


    private Double getLowFromRangeString(String doubleRange) {
        return Double.parseDouble(doubleRange.split("-")[0]);
    }

    private Double getHighFromRangeString(String doubleRange) {
        String[] splitDouble = doubleRange.split("-");
        return splitDouble.length > 1 ? Double.parseDouble(splitDouble[1]) : Double.parseDouble(splitDouble[0]);
    }
}
