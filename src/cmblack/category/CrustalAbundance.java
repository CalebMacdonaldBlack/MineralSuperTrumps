package cmblack.category;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class CrustalAbundance extends Category {
    private CrustalAbundanceOptions value;

    public CrustalAbundance(String name, CrustalAbundanceOptions value) {
        super(name);
        this.value = value;
    }

    public CrustalAbundance(CrustalAbundanceOptions value){
        this("Crustal abundance", value);
    }

    public CrustalAbundanceOptions getValue() {
        return value;
    }

    public enum CrustalAbundanceOptions {
        ULTRATRACE(0, "ultratrace"),
        TRACE(1, "trace"),
        LOW(2, "low"),
        MODERATE(3, "moderate"),
        HIGH(4, "high"),
        VERY_HIGH(5, "very high");

        private final int value;
        private final String label;

        private static Map<String, CrustalAbundanceOptions> crustalAbundanceOptionsMap = new HashMap<String, CrustalAbundanceOptions>();

        static {
            for (CrustalAbundanceOptions crustalAbundanceOptions : CrustalAbundanceOptions.values()) {
                crustalAbundanceOptionsMap.put(crustalAbundanceOptions.getLabel(), crustalAbundanceOptions);
            }
        }

        CrustalAbundanceOptions(int value, String label) {
            this.value = value;
            this.label = label;
        }

        public int getValue() {
            return value;
        }

        public String getLabel() {
            return label;
        }

        public static CrustalAbundanceOptions getWithLabel(String label) {
            return crustalAbundanceOptionsMap.get(label);
        }
    }
}
