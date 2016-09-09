package cmblack.category.economicvalue;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public enum EconomicValueEnum {
        TRIVIAL(new EconomicValue(0, "trivial")),
        LOW(new EconomicValue(1, "low")),
        MODERATE(new EconomicValue(2, "moderate")),
        HIGH(new EconomicValue(3, "high")),
        VERY_HIGH(new EconomicValue(4, "very high")),
        IM_RICH(new EconomicValue(5, "I'm rich!"));

    private final EconomicValue economicValue;

    EconomicValueEnum(EconomicValue economicValue) {
        this.economicValue = economicValue;
    }

    public EconomicValue getEconomicValue() {
        return economicValue;
    }

    //TODO check if this is ok with alex or lachlan
    public static EconomicValueEnum findWithValueName(String valueName){
        for(EconomicValueEnum economicValueEnum: EconomicValueEnum.values()){
            if(valueName.equals(economicValueEnum.getEconomicValue().getValueName())){
                return economicValueEnum;
            }
        }
        throw new NullPointerException();
    }
}
