package cmblack.player.round;

import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public interface IPlayerGroup {
    IPlayer[] getPlayersStillInGame();
    IPlayer[] getPlayersStillInRound();
    IPlayer getCurrentPlayer();
    IPlayerGroup nextPlayerTurn();
    boolean equals(IPlayerGroup playerGroup);
    IPlayerGroup removePlayerFromRound(IPlayer player);
    IPlayerGroup removePlayerFromGame(IPlayer player);





    class FakePlayerGroup implements IPlayerGroup {

        public IPlayer[] getPlayersStillInGame() {
            return new IPlayer[0];
        }

        public IPlayer[] getPlayersStillInRound() {
            return new IPlayer[0];
        }

        @Override
        public IPlayer getCurrentPlayer() {
            return new IPlayer.FakePlayer();
        }

        @Override
        public IPlayerGroup nextPlayerTurn() {
            return this;
        }

        @Override
        public boolean equals(IPlayerGroup playerGroup) {
            return playerGroup.getPlayersStillInRound().length == 0
                && playerGroup.getPlayersStillInGame().length == 0;
        }

        @Override
        public IPlayerGroup removePlayerFromRound(IPlayer player) {
            return this;
        }

        @Override
        public IPlayerGroup removePlayerFromGame(IPlayer player) {
            return this;
        }
    }
}
