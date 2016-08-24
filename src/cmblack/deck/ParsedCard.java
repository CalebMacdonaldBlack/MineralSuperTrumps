package cmblack.deck;

import java.util.List;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class ParsedCard {
    protected String fileName;
    protected String title;
    protected String chemistry;
    protected String classification;
    protected String crystal_system;
    protected String hardness;
    protected String specific_gravity;
    protected String cleavage;
    protected String crustal_abundance;
    protected String economic_value;
    protected List<String> occurrence;

    public ParsedCard(String chemistry, String hardness, String crystal_system, String title, String classification, String specific_gravity, List<String> occurrence, String fileName, String cleavage, String economic_value, String crustal_abundance) {
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
    }
}
