package cmblack.card;

import cmblack.category.Cleavage;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class PlayCard extends Card{
    private final String chemicalCompound, classification, crystalSystem;
    private final String[] occurrences;

    public PlayCard(String title, String subTitle, String imageFilename, String chemicalCompound, String classification, String crystalSystem, String[] occurrences) {
        super(title, subTitle, imageFilename);
        this.chemicalCompound = chemicalCompound;
        this.classification = classification;
        this.crystalSystem = crystalSystem;
        this.occurrences = occurrences;
    }

    public String getChemicalCompound() {
        return chemicalCompound;
    }

    public String getClassification() {
        return classification;
    }

    public String getCrystalSystem() {
        return crystalSystem;
    }

    public String[] getOccurrences() {
        return occurrences;
    }
}
