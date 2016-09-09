package cmblack.category;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class CrustalAbundance implements ICrustalAbundance {
    private final int value;
    private final String valueName;
    private final ICategory category;

    public CrustalAbundance(int value, String valueName, ICategory category) {
        this.value = value;
        this.valueName = valueName;
        this.category = category;
    }

    public CrustalAbundance(int value, String valueName) {
        this(value, valueName, new Category("Crustal abundance"));
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
    public boolean equals(ICrustalAbundance crustalAbundance) {
        return this.value == crustalAbundance.getValue()
            && this.valueName.equals(crustalAbundance.getValueName())
            && this.category.equals(crustalAbundance.getCategory());
    }

    @Override
    public ICategory getCategory() {
        return this.category;
    }

    @Override
    public boolean isBetterThan(IStat stat) {
        return false;
    }
}
