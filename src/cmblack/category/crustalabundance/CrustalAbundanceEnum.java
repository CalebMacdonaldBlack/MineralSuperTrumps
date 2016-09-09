package cmblack.category.crustalabundance;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public enum CrustalAbundanceEnum {
        ULTRATRACE(new CrustalAbundance(0, "ultratrace")),
        TRACE(new CrustalAbundance(1, "trace")),
        LOW(new CrustalAbundance(2, "low")),
        MODERATE(new CrustalAbundance(3, "moderate")),
        HIGH(new CrustalAbundance(4, "high")),
        VERY_HIGH(new CrustalAbundance(5, "very high"));

    private final CrustalAbundance crustalAbundance;

    CrustalAbundanceEnum(CrustalAbundance crustalAbundance) {
        this.crustalAbundance = crustalAbundance;
    }

    public CrustalAbundance getCrustalAbundance() {
        return crustalAbundance;
    }

    //TODO check if this is ok with alex or lachlan
    public static CrustalAbundanceEnum findWithValueName(String valueName){
        for(CrustalAbundanceEnum crustalAbundanceEnum: CrustalAbundanceEnum.values()){
            if(valueName.equals(crustalAbundanceEnum.getCrustalAbundance().getValueName())){
                return crustalAbundanceEnum;
            }
        }
        throw new NullPointerException();
    }
}
