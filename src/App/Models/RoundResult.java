package App.Models;

/**
 * Created by calebmacdonaldblack on 2/10/16.
 */
public class RoundResult {
    private final Player currentPlayer;
    private final TrumpCategory category;
    private final RoundResultType roundResultType;

    public RoundResult(Player currentPlayer, TrumpCategory category, RoundResultType roundResultType) {
        this.currentPlayer = currentPlayer;
        this.category = category;
        this.roundResultType = roundResultType;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public TrumpCategory getCategory() {
        return category;
    }

    public RoundResultType getRoundResultType() {
        return roundResultType;
    }

    public enum RoundResultType {
        NORMAL,
        START, TRUMP
    }
}
