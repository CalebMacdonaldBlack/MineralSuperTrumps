package cmblack.category.economicvalue;

import cmblack.category.Category;
import cmblack.category.ICategory;
import cmblack.category.IStat;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class EconomicValue implements IEconomicValue {
    private final int value;
    private final String valueName;
    private final ICategory category;

    public EconomicValue(int value, String valueName, ICategory category) {
        this.value = value;
        this.valueName = valueName;
        this.category = category;
    }

    public EconomicValue(int value, String valueName) {
        this.value = value;
        this.valueName = valueName;
        this.category = new Category("Economic value");
    }


    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public String getValueName() {
        return this.valueName;
    }

    @Override
    public boolean equals(IEconomicValue economicValue) {
        return this.value == economicValue.getValue()
            && this.valueName.equals(economicValue.getValueName())
            && this.category.equals(economicValue.getCategory());
    }

    @Override
    public ICategory getCategory() {
        return this.category;
    }

    @Override
    public boolean isBetterThan(IStat stat) {
        throw new NotImplementedException();
    }

//    private final EconomicValueOptions value;
//
//    public EconomicValue(EconomicValueOptions value) {
//        super(category);
//        this("Economic value", value);
//    }
//
//    public EconomicValue(String name, EconomicValueOptions value) {
//        super(name);
//        this.value = value;
//    }
//
//    public EconomicValueOptions getValue() {
//        return this.value;
//    }
//
//    @Override
//    public boolean isBetterThan(Category category) {
//        if(category instanceof EconomicValue){
//            return ((EconomicValue) category).getValue().value < this.getValue().value;
//        }
//        throw new IllegalArgumentException(category.getName() + " is not an instance of " + this.getName());
//    }
//
//    public enum EconomicValueOptions {
//        TRIVIAL(0, "trivial"),
//        LOW(1, "low"),
//        MODERATE(2, "moderate"),
//        HIGH(3, "high"),
//        VERY_HIGH(4, "very high"),
//        IM_RICH(5, "I'm rich!");
//
//        private final int value;
//        private final String label;
//
//        private static Map<String, EconomicValueOptions> economicValueOptionsMap = new HashMap<String, EconomicValueOptions>();
//
//        static {
//            for (EconomicValueOptions economicValueOptions : EconomicValueOptions.values()) {
//                economicValueOptionsMap.put(economicValueOptions.getLabel(), economicValueOptions);
//            }
//        }
//
//        EconomicValueOptions(int value, String label) {
//            this.value = value;
//            this.label = label;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public String getLabel() {
//            return label;
//        }
//
//        public static EconomicValueOptions getWithLabel(String label) {
//            return economicValueOptionsMap.get(label);
//        }
//    }
}
