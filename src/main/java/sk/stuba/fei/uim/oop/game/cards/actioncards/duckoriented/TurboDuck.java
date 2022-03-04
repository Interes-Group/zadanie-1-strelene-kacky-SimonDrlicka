package sk.stuba.fei.uim.oop.game.cards.actioncards.duckoriented;

import sk.stuba.fei.uim.oop.game.cards.actioncards.ActionCard;
import sk.stuba.fei.uim.oop.game.pond.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class TurboDuck extends ActionCard {
    @Override
    public void performAction(Pond pond) {
        int chosenDuck = ZKlavesnice.readInt("Choose a duck to TURBO move ");
        int newPosition = ZKlavesnice.readInt("Where do you want to move the duck?");
        if(chosenDuck >6 || chosenDuck<1){
            System.out.println("Both indexes must be between 1 to 6");
            performAction(pond);
            return;
        }
        if(newPosition > 6 || newPosition < 1){
            System.out.println("Both indexes must be between 1 to 6");
            performAction(pond);
            return;
        }
        boolean successful = pond.moveDuck(chosenDuck, chosenDuck);
        if(!successful){
            System.out.println("You cant move water!");
            performAction(pond);
        }else{
            System.out.println("Duck successfully moved from " + chosenDuck + " to " + newPosition);
            pond.addToTrash(this);
        }
    }

    @Override
    public String toString() {
        return "Turbo duck card";
    }
}
