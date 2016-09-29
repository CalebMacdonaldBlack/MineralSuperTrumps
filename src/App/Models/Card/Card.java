package App.Models.Card;

import App.Models.TrumpCategory;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public abstract class Card {
    private final String title;
    private final String description;
    private final Range hardness;
    private final Range specificGravity;
    private final Cleavage cleavage;
    private final CrustalAbundance crustalAbundance;
    private final EconomicValue economicValue;
    private final TrumpCategory[] TrumpCategories;
    private final CardType cardType;

    protected Card(String title, String description, Range hardness, Range specificGravity, Cleavage cleavage, CrustalAbundance crustalAbundance, EconomicValue economicValue, TrumpCategory[] trumpCategories, CardType cardType) {
        this.title = title;
        this.description = description;
        this.hardness = hardness;
        this.specificGravity = specificGravity;
        this.cleavage = cleavage;
        this.crustalAbundance = crustalAbundance;
        this.economicValue = economicValue;
        TrumpCategories = trumpCategories;
        this.cardType = cardType;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Range getHardness() {
        return hardness;
    }

    public Range getSpecificGravity() {
        return specificGravity;
    }

    public Cleavage getCleavage() {
        return cleavage;
    }

    public CrustalAbundance getCrustalAbundance() {
        return crustalAbundance;
    }

    public EconomicValue getEconomicValue() {
        return economicValue;
    }

    public TrumpCategory[] getTrumpCategories() {
        return TrumpCategories;
    }

    public CardType getCardType() {
        return cardType;
    }

    public boolean isBetterThan(Card currentCard, TrumpCategory currentCategory){
        switch (currentCategory){
            case HARDNESS:
                return this.hardness.getHighValue() > currentCard.hardness.getHighValue();
            case CLEAVAGE:
                return this.cleavage.ordinal() > currentCard.cleavage.ordinal();
            case CRUSTAL_ABUNDANCE:
                return this.crustalAbundance.ordinal() > currentCard.crustalAbundance.ordinal();
            case SPECIFIC_GRAVITY:
                return this.specificGravity.getHighValue() > currentCard.specificGravity.getHighValue();
            case ECONOMIC_VALUE:
                return this.economicValue.ordinal() > currentCard.economicValue.ordinal();
        }
        throw new NullPointerException("Trump category doesn't exist");
    }

    public enum CardType {
        REGULAR,
        EmptyCard, TRUMP
    }
}
