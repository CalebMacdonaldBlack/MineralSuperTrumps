package cmblack.player.round;

/**
 * Created by calebmacdonaldblack on 19/09/2016.
 */
public class RoundView {

    public void update(IRound round) {
        switch (round.getRoundState()){
            case START:
                System.out.println("Game starting\n");
                break;

        }
    }
}
