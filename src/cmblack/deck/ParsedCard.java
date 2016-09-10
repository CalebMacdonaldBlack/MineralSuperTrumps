package cmblack.deck;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class ParsedCard implements IParsedCard{
    private final String fileName;
    private final String title;
    private final String chemistry;
    private final String classification;
    private final String crystal_system;
    private final String hardness;
    private final String specific_gravity;
    private final String cleavage;
    private final String crustal_abundance;
    private final String economic_value;
    private final String[] occurrence;
    private final String subTitle;
    private final String[] categories;


    public ParsedCard(String chemistry, String hardness, String crystal_system, String title, String classification, String specific_gravity, String[] occurrence, String fileName, String cleavage, String economic_value, String crustal_abundance, String subTitle, String[] categories) {
        this.chemistry = chemistry;
        this.hardness = hardness;
        this.crystal_system = crystal_system;
        this.title = title;
        this.classification = classification;
        this.specific_gravity = specific_gravity;
        this.occurrence = occurrence;
        this.fileName = fileName;
        this.cleavage = cleavage;
        this.economic_value = economic_value;
        this.crustal_abundance = crustal_abundance;
        this.subTitle = subTitle;
        this.categories = categories;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTitle() {
        return title;
    }

    public String getChemistry() {
        return chemistry;
    }

    public String getClassification() {
        return classification;
    }

    public String getCrystal_system() {
        return crystal_system;
    }

    public String getHardness() {
        return hardness;
    }

    public String getSpecific_gravity() {
        return specific_gravity;
    }

    public String getCleavage() {
        return cleavage;
    }

    public String getCrustal_abundance() {
        return crustal_abundance;
    }

    public String getEconomic_value() {
        return economic_value;
    }

    public String[] getOccurrence() {
        return occurrence;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String[] getCategories() {
        return categories;
    }
}
