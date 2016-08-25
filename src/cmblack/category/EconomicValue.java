package cmblack.category;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class EconomicValue extends Category{
    private final EconomicValueOptions value;

    public EconomicValue(EconomicValueOptions value) {
        this("Economic Value", value);
    }

    public EconomicValue(String name, EconomicValueOptions value) {
        super(name);
        this.value = value;
    }

    public EconomicValueOptions getValue() {
        return this.value;
    }

    public enum EconomicValueOptions {
        TRIVIAL(0, "trivial"),
        LOW(1, "low"),
        MODERATE(2, "moderate"),
        HIGH(3, "high"),
        VERY_HIGH(4, "very high"),
        IM_RICH(5, "I'm Rich!");

        private final int value;
        private final String label;

        private static Map<String, EconomicValueOptions> economicValueOptionsMap = new HashMap<String, EconomicValueOptions>();

        static {
            for (EconomicValueOptions economicValueOptions : EconomicValueOptions.values()) {
                economicValueOptionsMap.put(economicValueOptions.getLabel(), economicValueOptions);
            }
        }

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

        public static EconomicValueOptions getWithLabel(String label) {
            return economicValueOptionsMap.get(label);
        }
    }
}
