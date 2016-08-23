package cmblack.category;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class Cleavage extends Category{
    private final CleavageOptions value;

    public Cleavage(CleavageOptions value) {
        super("Cleavage");
        this.value = value;
    }

    public CleavageOptions getValue() {
        return value;
    }


    enum CleavageOptions {
        NONE(0, "none"),
        POOR_NONE(1, "poor/none"),
        POOR1(2, "1 poor"),
        POOR2(3, "2 poor"),
        GOOD1(4, "1 good"),
        GOOD1_POOR1(5, "1 good, 1 poor"),
        GOOD2(5, "2 good"),
        GOOD3(6, "3 good"),
        PERFECT1(7, "1 perfect"),
        PERFECT1_GOOD1(8, "1 perfect, 1 good"),
        PERFECT1_GOOD2(9, "1 perfect, 2 good"),
        PERFECT2_GOOD1(10, "2 perfect, 1 good"),
        PERFECT3(11, "3 perfect"),
        PERFECT4(12, "4 perfect"),
        PERFECT6(13, "6 perfect");

        private final int value;
        private final String label;

        CleavageOptions(int value, String label) {
            this.value = value;
            this.label = label;
        }

        public int getValue() {
            return value;
        }

        public String getLabel() {
            return label;
        }
    }
}
