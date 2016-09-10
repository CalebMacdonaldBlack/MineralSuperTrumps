package cmblack.category.crustalabundance;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public enum CrustalAbundanceValue {
    TRUMPCARD("trumpcard"),
    ULTRATRACE("ultratrace"),
    TRACE("trace"),
    LOW("low"),
    MODERATE("moderate"),
    HIGH("high"),
    VERY_HIGH("very high");

    private final String text;

    CrustalAbundanceValue(String text) {
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
