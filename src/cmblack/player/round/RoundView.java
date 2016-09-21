package cmblack.player.round;

import cmblack.card.CardType;
import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.category.ICategory;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by calebmacdonaldblack on 19/09/2016.
 */
public class RoundView implements IRoundView{

    private final Scanner scanner;

    public RoundView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void update(IRound round) {
        // TODO: 21/09/2016 Convert states to methods
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
                System.out.println(round.getPlayerGroup().getCurrentPlayer().getName() + " drew " + round.getPlayerGroup().getCurrentPlayer().getCards().get(round.getPlayerGroup().getCurrentPlayer().getCards().size() - 1).getTitle());
                System.out.println(round.getPlayerGroup().getCurrentPlayer().getName() + " card count: " + round.getPlayerGroup().getCurrentPlayer().getCountOfCards());
                break;
            case PLAYER_FINISHED_TURN:
                System.out.println(round.getPlayerGroup().getCurrentPlayer().getName() + " ended their turn\n==============="  );
                break;
            case ROUND_OVER:
                System.out.println("Round is finished. " + round.getPlayerGroup().getPlayersStillIn()[0].getName() + " won the round\n");

        }
    }

    @Override
    public ICard getCardSelection(ICard[] cards) {
        for(int i=0;i<cards.length;i++){
            System.out.println("Option: " + i + "\n==================");
            printCard(cards[i]);
        }
        System.out.println("Option: " + cards.length + "\n==================");
        System.out.println("Skip playing a card and draw instead");

        while(true){
            try{
                System.out.print("\n\nSelect an option: ");
                int index = Integer.parseInt(scanner.nextLine());
                if(index >= 0 && index <= cards.length){
                    if(index == cards.length){
                        return new EmptyCard();
                    } else {
                        return cards[index];
                    }
                }
            }catch(NumberFormatException e){
                System.out.print("Not a number. ");
            }

            System.out.println("Please enter a valid number");
        }
    }

    private void printCard(ICard card) {
        System.out.println("Play card: " + card.getTitle());
        switch (card.getType()){
            case PLAY_CARD:
                System.out.println("Regular Card");
                System.out.println("Stats");
                System.out.println("Cleavage: " + card.getStats().getCleavage().getValue().getText());
                System.out.println("Crustal Abundance: " + card.getStats().getCrustalAbundance().getValue().getText());
                System.out.println("Economic Value: " + card.getStats().getEconomicValue().getValue().getText());
                System.out.println("Hardness: " + card.getStats().getHardness().getMinimumValue() + "-" + card.getStats().getHardness().getMaximumValue());
                System.out.println("Specific Gravity: " + card.getStats().getSpecificGravity().getMinimumValue() + "-" + card.getStats().getSpecificGravity().getMaximumValue());
                break;
            case TRUMP_CARD:
                System.out.println("Trump Card");
                System.out.println("Trump Categorys");
                for(ICategory category: card.changeableTrumpCategories()){
                    System.out.println("- " + category.getCategoryName());
                }
        }
        System.out.println();
    }
}
