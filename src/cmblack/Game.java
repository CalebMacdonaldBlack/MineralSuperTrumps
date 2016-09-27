package cmblack;

import cmblack.card.EmptyCard;
import cmblack.category.EmptyCategory;
import cmblack.deck.IDeck;
import cmblack.deck.ShuffledDeck;
import cmblack.player.IPlayer;
import cmblack.player.round.*;
import cmblack.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by calebmacdonaldblack on 26/9/16.
 */
public class Game implements IGame{

    private final IDeck deck;
    private IPlayerGroup playerGroup;
    private final IView view;
    private List<IPlayer> winners = new ArrayList<>();

    public Game(IDeck deck, IPlayerGroup playerGroup, IView view) {
        this.deck = new ShuffledDeck(deck);
        this.playerGroup = playerGroup;
        this.view = view;
    }

    @Override
    public List<IPlayer> startGame() {
        IRoundResult roundResult = new RoundResult(playerGroup, new EmptyCategory(), new ArrayList<>());
        distributeCardsToPlayers();
        while(playerGroup.getPlayersStillInGame().length > 1){
            IRound round = new Round(deck, playerGroup, new EmptyCard(), roundResult.getNextRoundCategory(), playerGroup.getCurrentPlayer(), view);
            view.roundStarted(roundResult);
            roundResult = round.haveRound();
            playerGroup = new PlayerGroup(roundResult.getPlayerGroup().getPlayersStillInGame(), roundResult.getPlayerGroup().getCurrentPlayer());
            addWinningPlayers(roundResult.getPlayersToRemoveFromGame());
        }
        return winners;
    }

    private void addWinningPlayers(List<IPlayer> playersToRemoveFromGame) {
        for(IPlayer player: playersToRemoveFromGame){
            this.winners.add(player);
        }
    }

    private void distributeCardsToPlayers() {
        // TODO: 23/9/16 this goes in a game class higher up
        for(IPlayer player: playerGroup.getPlayersStillInGame()){
            for(int i=0; i<1;i++){
                // TODO: 23/9/16 this will be slow. shuffling every time
                player.getPlayerHand().giveCard(deck.takeCard());
            }
        }
    }
}
