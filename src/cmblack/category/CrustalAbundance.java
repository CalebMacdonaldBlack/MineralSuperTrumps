package cmblack.category;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class CrustalAbundance extends Category {
    private CrustalAbundanceValue value;

    public CrustalAbundance(String name, CrustalAbundanceValue value) {
        super(name);
        this.value = value;
    }

    public CrustalAbundance(CrustalAbundanceValue value){
        this("Crustal abundance", value);
    }

    public CrustalAbundanceValue getValue() {
        return value;
    }

    enum CrustalAbundanceValue {
        ULTRATRACE(0, "ultratrace"),
        TRACE(1, "trace"),
        LOW(2, "low"),
        MODERATE(3, "moderate"),
        HIGH(4, "high"),
        VERY_HIGH(5, "very high");

        private final int value;
        private final String label;

        CrustalAbundanceValue(int value, String label) {
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
