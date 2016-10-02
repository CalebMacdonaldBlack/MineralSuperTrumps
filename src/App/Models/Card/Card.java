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

    /**
     * Creates a new instance
     *
     * @param title            Card title
     * @param description      Card description
     * @param hardness         range
     * @param specificGravity  range
     * @param cleavage         enum value
     * @param crustalAbundance enum value
     * @param economicValue    enum value
     * @param trumpCategories  enum value
     * @param cardType         enum value
     */
    Card(String title, String description, Range hardness, Range specificGravity, Cleavage cleavage, CrustalAbundance crustalAbundance, EconomicValue economicValue, TrumpCategory[] trumpCategories, CardType cardType) {
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

    /**
     * Title
     *
     * @return Card title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Description
     *
     * @return Card description
     */
    String getDescription() {
        return description;
    }

    /**
     * Hardness
     *
     * @return Hardness range
     */
    Range getHardness() {
        return hardness;
    }

    /**
     * Specific Gravity
     *
     * @return Specific Gravity Range
     */
    Range getSpecificGravity() {
        return specificGravity;
    }

    /**
     * Cleavage
     *
     * @return Cleavage enum value
     */
    Cleavage getCleavage() {
        return cleavage;
    }

    /**
     * Crustal abundance
     *
     * @return Crustal abundance enum value
     */
    CrustalAbundance getCrustalAbundance() {
        return crustalAbundance;
    }

    /**
     * Economic value
     *
     * @return Economic value enum value
     */
    EconomicValue getEconomicValue() {
        return economicValue;
    }

    /**
     * Trump categories this card can change to. Only used for trump card
     *
     * @return Array of trump categories
     */
    TrumpCategory[] getTrumpCategories() {
        return TrumpCategories;
    }

    /**
     * Card type enum. TRUMP or PLAYCARD
     *
     * @return Card type
     */
    public CardType getCardType() {
        return cardType;
    }

    /**
     * Determines if this card is better than the one passed in for a specific category
     *
     * @param currentCard     The comparing card
     * @param currentCategory The comparing trump category
     * @return true if this card is better
     */
    public boolean isBetterThan(Card currentCard, TrumpCategory currentCategory) {
        switch (currentCategory) {
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

    /**
     * Used for outputting the card to the console
     *
     * @return String representation of a card
     */
    public abstract String toString();
}
