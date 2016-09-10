package cmblack.card.stats;


import cmblack.deck.deckbuilder.IParsedCard;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface IStatsBuilder {
    IStats build(IParsedCard parsedCard);

    class FakeStatsBuilder implements IStatsBuilder {

        @Override
        public IStats build(IParsedCard parsedCard) {
            return new IStats.FakePlayCardStats();
        }
    }
}
