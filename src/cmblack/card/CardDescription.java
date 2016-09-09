package cmblack.card;

import java.util.Arrays;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class CardDescription implements ICardDescription {

    private final String chemicalCompound, classification, crystalSystem;
    private final String[] occurrences;

    public CardDescription(String chemicalCompound, String classification, String crystalSystem, String[] occurrences) {
        this.chemicalCompound = chemicalCompound;
        this.classification = classification;
        this.crystalSystem = crystalSystem;
        this.occurrences = occurrences;
    }

    @Override
    public String getChemicalCompound() {
        return this.chemicalCompound;
    }

    @Override
    public String getClassification() {
        return this.classification;
    }

    @Override
    public String getCrystalSystem() {
        return this.crystalSystem;
    }

    @Override
    public String[] getOccurrences() {
        return this.occurrences;
    }

    @Override
    public boolean equals(ICardDescription cardDescription) {
        return this.chemicalCompound.equals(cardDescription.getChemicalCompound())
                && this.classification.equals(cardDescription.getClassification())
                && this.crystalSystem.equals(cardDescription.getCrystalSystem())
                && Arrays.equals(this.occurrences, cardDescription.getOccurrences());
    }
}
