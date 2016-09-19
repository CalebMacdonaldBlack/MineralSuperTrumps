package cmblack.player.round;

/**
 * Created by calebmacdonaldblack on 19/09/2016.
 */
public class RoundView implements IRoundView{

    public void update(IRound round) {
        switch (round.getRoundState()){
            case START:
                System.out.println("Game starting\n");
                break;
            case CATEGORY_UPDATED:
                System.out.println("Category updated to: " + round.getCurrentCategory().getCategoryName() + " by " + round.getPlayerGroup().getCurrentPlayer().getName());
                break;
            case PLAYER_PLAYED_CARD:
                System.out.println(round.getPlayerGroup().getCurrentPlayer().getName() + " played the card: " + round.getCurrentCard().getTitle());
                System.out.println(round.getPlayerGroup().getCurrentPlayer().getName() + " card count: " + round.getPlayerGroup().getCurrentPlayer().getCountOfCards());
                break;
            case PLAYER_TURN:
                System.out.println("It is now " + round.getPlayerGroup().getCurrentPlayer().getName() + "'s turn");
                break;
            case PLAYER_REMOVED:
                System.out.println(round.getPlayerGroup().getCurrentPlayer().getName() + " couldn't play a card and was removed");
                break;
            case PLAYER_DREW_CARD:
                System.out.println(round.getPlayerGroup().getCurrentPlayer().getName() + " drew " + round.getCurrentCard().getTitle());
                System.out.println(round.getPlayerGroup().getCurrentPlayer().getName() + " card count: " + round.getPlayerGroup().getCurrentPlayer().getCountOfCards());
                break;
            case PLAYER_FINISHED_TURN:
                System.out.println(round.getPlayerGroup().getCurrentPlayer().getName() + " ended their turn\n==============="  );
                break;
            case ROUND_OVER:
                System.out.println("Round is finished. " + round.getPlayerGroup().getPlayersStillIn()[0].getName() + " won the round\n");

        }
    }
}
