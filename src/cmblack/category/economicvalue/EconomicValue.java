package cmblack.category.economicvalue;

import cmblack.category.Category;
import cmblack.category.ICategory;
import cmblack.category.IStat;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class EconomicValue implements IEconomicValue {
    private final EconomicValueValue value;
    private final ICategory category;

    public EconomicValue(EconomicValueValue value, ICategory category) {
        this.value = value;
        this.category = category;
    }

    public EconomicValue(EconomicValueValue value) {
        this.value = value;
        this.category = new Category("Economic getValue");
    }


    @Override
    public EconomicValueValue getValue() {
        return this.value;
    }

    @Override
    public boolean equals(IEconomicValue economicValue) {
        return this.value == economicValue.getValue()
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

//    private final EconomicValueOptions getValue;
//
//    public EconomicValue(EconomicValueOptions getValue) {
//        super(category);
//        this("Economic getValue", getValue);
//    }
//
//    public EconomicValue(String name, EconomicValueOptions getValue) {
//        super(name);
//        this.getValue = getValue;
//    }
//
//    public EconomicValueOptions getValue() {
//        return this.getValue;
//    }
//
//    @Override
//    public boolean compareWith(Category category) {
//        if(category instanceof EconomicValue){
//            return ((EconomicValue) category).getValue().getValue < this.getValue().getValue;
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
//        private final int getValue;
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
//        EconomicValueOptions(int getValue, String label) {
//            this.getValue = getValue;
//            this.label = label;
//        }
//
//        public int getValue() {
//            return getValue;
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
