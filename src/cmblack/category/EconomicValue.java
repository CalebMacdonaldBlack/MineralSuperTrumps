package cmblack.category;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class EconomicValue {
    private final EconomicValueOptions value;

    public EconomicValue(EconomicValueOptions value) {
        this.value = value;
    }

    public EconomicValueOptions getValue() {
        return null;
    }

    enum EconomicValueOptions {
        TRIVIAL(0, "trivial"),
        LOW(1, "low"),
        MODERATE(2, "moderate"),
        HIGH(3, "high"),
        VERY_HIGH(4, "very high"),
        IM_RICH(5, "I'm Rich!");

        private final int value;
        private final String label;

        EconomicValueOptions(int value, String label) {
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
