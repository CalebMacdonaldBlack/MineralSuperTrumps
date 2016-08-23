package cmblack.card;

import cmblack.category.*;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class PlayCardStats {
    private final Cleavage cleavage;
    private final CrustalAbundance crustalAbundance;
    private final EconomicValue economicValue;
    private final Hardness hardness;
    private final SpecificGravity specificGravity;

    public PlayCardStats(Cleavage cleavage, CrustalAbundance crustalAbundance, EconomicValue economicValue, Hardness hardness, SpecificGravity specificGravity) {
        this.cleavage = cleavage;
        this.crustalAbundance = crustalAbundance;
        this.economicValue = economicValue;
        this.hardness = hardness;
        this.specificGravity = specificGravity;
    }

    public Cleavage getCleavage() {
        return cleavage;
    }

    public CrustalAbundance getCrustalAbundance() {
        return crustalAbundance;
    }

    public EconomicValue getEconomicValue() {
        return economicValue;
    }

    public Hardness getHardness() {
        return hardness;
    }

    public SpecificGravity getSpecificGravity() {
        return specificGravity;
    }
}
