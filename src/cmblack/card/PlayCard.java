package cmblack.card;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class PlayCard implements IPlayCard {
    private final String chemicalCompound, classification, crystalSystem;
    private final String[] occurrences;
    private final PlayCardStats playCardStats;
    private final String title;
    private final String imageFileName;
    private final ICardDescription cardDescription;

    public PlayCard(String title, String imageFileName, String chemicalCompound, String classification, String crystalSystem, String[] occurrences, PlayCardStats playCardStats, ICardDescription cardDescription) {
        this.title = title;
        this.imageFileName = imageFileName;
        this.chemicalCompound = chemicalCompound;
        this.classification = classification;
        this.crystalSystem = crystalSystem;
        this.occurrences = occurrences;
        this.playCardStats = playCardStats;
        this.cardDescription = cardDescription;
    }

    @Override
    public ICardDescription getCardDescription() {
        return null;
    }

    @Override
    public PlayCardStats getPlayCardStats() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getImageFilename() {
        return null;
    }
}
