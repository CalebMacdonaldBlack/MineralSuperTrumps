package cmblack.view;

import cmblack.card.CardType;
import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.card.playcard.PlayCard;
import cmblack.category.EmptyCategory;
import cmblack.controller.ITurnActions;
import cmblack.player.IPlayer;
import cmblack.player.round.IRoundResult;
import cmblack.player.round.ITurn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by calebmacdonaldblack on 23/9/16.
 */
public class View implements IView {
    @Override
    public void currentCardUpdated(ITurn turn) {
        sleep();
        System.out.println(turn.getCurrentPlayer().getName() + " played " + turn.getCurrentCard().getTitle());
    }

    @Override
    public void currentCategoryUpdated(ITurn turn) {
        sleep();
        System.out.println(turn.getCurrentPlayer().getName() + " selected the category " + turn.getCurrentCategory().getCategoryName());
    }

    @Override
    public void currentPlayerUpdated(ITurn turn) {
        sleep();
        System.out.println("It is now " + turn.getCurrentPlayer().getName() + "'s turn");
    }

    @Override
    public void currentPlayerRemoved(ITurn turn) {
        sleep();
        System.out.println(turn.getCurrentPlayer().getName() + " couldn't play a card and was removed from the round");
    }

    @Override
    public void roundStarted(IRoundResult roundResult) {
        sleep();
        System.out.print("\n========Round Started========\nPlayers:");
        for (IPlayer player :roundResult.getPlayerGroup().getPlayersStillInGame()) {
            // TODO: 26/9/16 fix comma formatting
            System.out.print(player.getName() + ", ");
        }
        System.out.println("");
        if(!roundResult.getNextRoundCategory().equals(new EmptyCategory())){

        }
    }

    @Override
    public void playerDrewCard(ITurn turn) {
        sleep();
        int cardCount = turn.getCurrentPlayer().getPlayerHand().getCountOfCards();
        System.out.println(
                turn.getCurrentPlayer().getName() +
                " draw a card and now has " +
                cardCount +
                " card" +
                (cardCount == 1 ? "" : "s") +
                " in their hand"
        );
    }

    @Override
    public void playerWon(ITurn turn) {
        sleep();
        System.out.println(turn.getCurrentPlayer().getName() + " Has no cards and won!");
        System.out.println(turn.getCurrentPlayer().getName() + " was removed from the game");
    }

    @Override
    public void deckIsEmpty(IPlayer player) {
        sleep();
        System.out.println(player.getName() + " couldn't draw a card. There are none left in the deck");
    }

    @Override
    public void askHumanForCard(ITurn turn, ITurnActions turnController) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ICard> cards = turn.getCurrentPlayer().getPlayerHand().getCards();

        System.out.println("options\n=============================\n");
        for(int i=0;i<cards.size();i++){
            System.out.println(i + ")\n" + cards.get(i).toString());
            System.out.println("");
        }
        System.out.println(cards.size() + ")\nDon't play a card");
        System.out.println("\n");
        if(!turn.getCurrentCard().getType().equals(CardType.EMPTY_CARD)){
            System.out.println("Current Card: " + turn.getCurrentCard().toString());
            sleep();
        } else {
            System.out.println("No current card. Play any card");
            sleep();
        }
        System.out.println("Current Category: " + turn.getCurrentCategory().getCategoryName());

        System.out.println("\n Please enter an option: ");


        int selection = scanner.nextInt();
        while(selection < 0 || selection > cards.size()){
            selection = scanner.nextInt();
        }

        if(selection < cards.size()){
            turnController.selectedCard(turn.getCurrentPlayer().getPlayerHand().getCards().get(selection));
        }else{
            turnController.selectedCard(new EmptyCard());
        }
    }

    @Override
    public void humanPlayedWrongCard(ITurn turn) {
        System.out.println("This card is not better than " + turn.getCurrentCard().getTitle() + " in the category: " + turn.getCurrentCategory().getCategoryName());
        sleep();
    }

    private void sleep(){
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
