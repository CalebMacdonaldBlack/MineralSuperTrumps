package cmblack.card;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class PlayCard extends Card{
    private final String chemicalCompound, classification, crystalSystem;
    private final String[] occurrences;
    private final PlayCardStats playCardStats;

    public PlayCard(String title, String imageFilename, String chemicalCompound, String classification, String crystalSystem, String[] occurrences, PlayCardStats playCardStats) {
        super(title, imageFilename);
        this.chemicalCompound = chemicalCompound;
        this.classification = classification;
        this.crystalSystem = crystalSystem;
        this.occurrences = occurrences;
        this.playCardStats = playCardStats;
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

    public PlayCardStats getPlayCardStats() {
        return playCardStats;
    }
}
